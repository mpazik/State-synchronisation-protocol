# Identity of entity
What is an entity? Is it only a state with a reference. Maybe also with version of the state. What about other data like relation.
Can state be immutable? Is it still a state if it's not mutable. IMHO state is mutable by definition.
But entities can have immutable properties like some relation with other entities e.g. parent, category. 
Having explicitly declared some data as immutable could express better entity and some performance and code readability benefits. 

##  How entity could be created?
Event replaying should recreate state. But how to initiate the entity? Where entity has its begging?

- we can assume that for each possible id entity exists but with version 0. 
This is ok if we assume that entities won't have any other data, like relations, beside state.
We can not also check if the given entity exists but we could check if it contains any events  so that could be equivalent.

- entity creation event could belongs to the parents.
That will require to process parent state before we could process state of our entity and we could obtain it only from parent.

- create a special type of change that would mean that entity has been created at this moment. 
That event could have initial data. 
Who should process that event? Entity can not do that because it doesn't exists yet. Probably other entity - parent entity.
Maybe this solution can be reduced to this with entity parents

