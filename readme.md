# State synchronization protocol - Experiment

## About
A project that is trying to help solve the problem with state synchronization between client and distributed server.

The use case for which it is designed is a MMO game which is the source of the requirements.
The requirement for this project is to synchronization efficiently state with multiple clients.

## Requirements/Assumptions:
- clients require only some parts of state of the application an the given moment of time.
- clients are not trustworthy. All inputs from clients have to be validated before it could have any impact on the state
- there may be multiple sources of the state. 
Application may consist of many independent services including even third party.
- there are different kinds of state. Some state may be synchronised within seconds 
other have to be synchronized within dozens of milliseconds.
- possibility to track state changes and things that cause it.
Required for:
    - gather information to balance the game play
    - analyzing behaviour of users in order to check how and how often given parts of systems are used
    - possibility to add new types of state that could be calculated from already happened events.
 
## Pages

- [State Replaying](docs/state-replaying.md)
- [Entity](docs/entity.md)


## Inspirations:
- [Implementing Domain-Driven Design](https://vaughnvernon.co/?page_id=168#iddd)
- [Event Sourcing vs Command Sourcing](http://thinkbeforecoding.com/post/2013/07/28/Event-Sourcing-vs-Command-Sourcing)
