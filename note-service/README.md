### Spring boot Microservice with Domain Driven Design.

Service will allow:
1. Get notes of the user.
2. Author can modify his notes.
3. Author can submit a new note.


During authentication and authorization note-service pulls data from user management service
in order to check whether user exists in our system.


#####Not Best Practices I used.

1. In this domain we need only author's identity and name.
For repository implementation I used JPA and did mapping directly on domain entities
I know this is not a good practice , but because of time limitations I can't to better. (Sorry for that.)

2. For basic authentication I pull data from user service , user service provides user's password to 
notes service. I know this is not secure and it can be implemented with best practices.
But I wanted to show how two services should communicate with each other in Domain Driven Design.
  


### CURL Commands

Get user notes:

    curl -u aram@gmail.com:encoded_password http://localhost:8080/notes
    
Submit note:
    
    curl -d '{"title":"new title", "note":"new note"}' -H "Content-Type: application/json" -X POST -u aram@gmail.com:encoded_passord http://localhost:8080/notes
    
Modify note:

    curl -d '{"title":"updated title", "note":"updated note"}' -H "Content-Type: application/json" -X PUT -u aram@gmail.com:encoded_passord http://localhost:8080/notes/{not_id}

        
    
    
