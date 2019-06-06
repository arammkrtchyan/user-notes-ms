### Spring boot Microservice with Domain Driven Design.

Service will allow a author to do simple CRUD operations on his notes.


#####Some notes

1. In this domain we need only to have author's identity and name.
For repository implementation I used JPA and did mapping directly on domain entities
I know this is not a good practice , but because of time limitations I can't to better. (Sorry for that.)

2. For basic authentication I pull data from user service , user service provides user's password to 
notes service. I know this is not secure and it can be implemented with best practices.
But I wanted to show how two services should communicate with each other in Domain Driven Design.
  



    
