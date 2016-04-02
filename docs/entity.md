# Identity of entity
What is an entity? Is it only a state with a reference. Maybe also with version of the state. 
What about other data like permanent relation? Can state be immutable? 
Is it still a state if it's not mutable. IMHO state is mutable by definition.
But entities can have immutable properties like some relation with other entities e.g. parent, category. 
Having explicitly declared some data as immutable could express better entity and some performance and code readability benefits. 

##  How entity could be created?
Changes replaying should recreate state. But how to initiate the entity? Where entity has its begging?
There are two possibilities.

### Entities are already created for each possible id
There could be a factory or a service that for any given id will return and entity with version 0
if it wasn't created before.
Then it could be populated with an initial change.

#### Characteristics
- No possibility to initiate an entity. It can not have immutable data because version 0 doesn't have any data.
Only immutable data is id and type if there are many types of entities.
- If there are multiple types of entities, type is required to get an entity of given id. 
Even UUID is not unique because we assume that for each entity type there is an entity for each possible id. 

### Something creates an entity from its first event
A creation event/change will contain information that determine how to create an entity from it. 
It could be a type which application can associate with logic that is able to create entity from the event. 

#### Characteristics
- If entities have unique id across all types it is not required to have 
a type to unambiguously determine entity and how to interpret its events. It's comes from the first event.
- Creation change can define immutable parameters of an entity as entity with version 0 is uncorrect.

### Which one to choose
Although I'm trying I do not see benefits of using first approach. 
Perhaps it make creating entities easier. 
Probably it could works well in systems where there are only an entities with one type and no initial state.

However for MMO game I would chose second approach.