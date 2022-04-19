# demo-rest-api  
Technical assignment:    
## Installation    
To use this repository, you need to download it. Then you need to change the url of the username and password from your database demo/src/main/resources/initDB.sql   
spring.datasource.url=jdbc:postgresql://localhost:5432/baza1-----edit here  
spring.datasource.username=root-----edit here  
spring.datasource.password=root-----edit here  


Usage         
This application has multiple entry points:         
 
-GET /clients/{id} - returns client by id.  
-GET /clients/mail/{mail} - returns boclientsoks by mail..  
-GET /clients/number/{number} - returns clients by phone number.  
-GET /clients/firstname/{firstname} - search client by name.  
-GET /clients/firstname/{firstname}/lastname/{lastname} - returns clients by firstname and lastname.  
-POST /clients - create client.  
-DELETE /clients/{id} - delete client by id.  
-PUT /clients/{id} - update client by id.  
