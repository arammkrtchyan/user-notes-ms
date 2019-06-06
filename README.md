### Spring boot Microservice with Domain Driven Design.


#####Services

Note Service:

    1. Get notes of the user.
    2. Author can modify his notes.
    3. Author can submit a new note.

User Service:

     1. Provides ability to pull user by email. 


#####Service Architecture

Note Service uses hexagonal architecture. With corresponding layers:

    Domain/Model
    Application
    port/adatpers
    
     

#####Authentication/Authorization

Basic authorization has been implement for note service.

During authentication and authorization note-service pulls data from user management service
in order to check whether user exists in our system.


#####Where I did not follow to Best Practices.

1. For repository implementation I used JPA and did mapping directly on domain entities
I know this is not a good practice , but because of time limitations I can't to better. (Sorry for that.)

2. For basic authentication I pull data from user service , user service provides user's password to 
notes service. I know this is not secure and it can be implemented with best practices.
But I wanted to show how two services should communicate with each other in Domain Driven Design.

3. In Adapters I used hardcoded URL of user management service, it can be configurable or
    ome service discovery functionality can be injected to the system. 
  


### CURL Commands

Get user notes:

    curl -u user:password http://localhost:8080/notes
    
Submit note:
    
    curl -d '{"title":"new title", "note":"new note"}' -H "Content-Type: application/json" -X POST -u user:password http://localhost:8080/notes
    
Modify note:

    curl -d '{"title":"updated title", "note":"updated note"}' -H "Content-Type: application/json" -X PUT -u user:password http://localhost:8080/notes/{not_id}
        
    
#####Unit/Integration/ Performance tests

It's very important for me to write at least unit and integration tests, but unfortunatly 
today I could not write some. Maybe we can discuss about this in the future (I hope).
   


