# Event replaying
It's an action of applying changes (events) to the entity in order to reconstruct its state.
This mechanism seems to ideally fit for need of synchronisation state with multiple clients.
In order to do that server just have to send events to the clients. 
Clients could also cache the state and if it's relatively fresh, they can fetch only necessary events to make it updated. 

## Requirements of event replaying mechanism
- replaying same events on the same state always result same outcome state
    - replaying events requires initial state and list of events
    - events has to be processed sequentially (no parallelization, ordering required)
    - no event can be missed if we want to update state correctly
    - state change from event has to always be the same (no possibility to change event processing behaviour)
    - only way to change the state of an entity is by processing events (no out of band changes)
- replaying events can be done multiple times
    - processing events is side effect free

## From requirements
- we would need multiple independent states
    - because state has to be processed sequentially, so processing a single game state would be bottleneck
    - because we want to synchronise only fragment of the game state with clients and no event can be omitted during state replaying.
- not all domain events would fulfil the requirements. Some will have side effects. 
Special type of event for replying should be created and only it will have 
the right to be responsible of update the state directly (no out of band changes).
- what about changing state of multiple entities by same event? 
That would make hard fetching all events required to synchronize a single state.
Probably it's better to create a rule that event that changes a state can modify a single independent state.
In other words these events belongs to the independent state.

## Proposition
Create a separate event type called *change*. 
Other event wouldn't be allowed to update the state. They could only crate create changes. 
The second type we be called *command*.

Independent state with Id will be called *entity*.
There may exists different type of entities. *entity type* determine the way state is build from changes.