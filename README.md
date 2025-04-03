# authservice
Auth for Concert Booking 

## Instructions to Run the Auth Application: 

##### Database installation 

```
brew install mysql
brew services start mysql
mysql -u root -p
```

##### Start the db 

*  mysql -u root -p
*  Enter password - 

##### Create db and tables 

* CREATE DATABASE authdb;

* Replace the jwt.secret=${JWT_SECRET} with a new secret in the application.properties by generating it using the below command

* openssl rand -base64 32

##### Run the Spring boot Application 
* rm -rf target
* mvn clean install -U
* mvn spring-boot:run

### API web server Info

```
host - localhost
port - 8081
```
##### Apis in Auth Service 

##### API 1: Register User 

###### Path : 

```
/api/auth/register
```

###### Request: 

```
curl -X POST "http://localhost:8081/api/auth/register" \
     -H "Content-Type: application/json" \
     -d '{
           "email": "tejaswini@example.com",
           "password": "password123"
         }'

```

###### Response: 

```
User registered successfully
```


###### Request : 

```
curl -X POST "http://localhost:8081/api/auth/register" \
     -H "Content-Type: application/json" \
     -d '{
           "email": "john.doe@example.com",
           "password": "securePass456"
         }'
```

###### Response: 

```
User registered successfully

```


##### API 2: Login User


###### Path : 

```
/api/auth/login
```

###### Request: 

```
curl -X POST "http://localhost:8081/api/auth/login" \
     -H "Content-Type: application/json" \
     -d '{
           "email": "tejaswini@example.com",
           "password": "password123"
         }'


```

###### Response: 

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZWphc3dpbmlAZXhhbXBsZS5jb20iLCJpYXQiOjE3NDM2NDg5NTIsImV4cCI6MTc0MzY1MjU1Mn0.vdOGLXGMRP5b24UxeeEfhiSOUFH0lft4bO4a_Y7WskI%     

```


*  Login With Wrong Credentials : 

###### Request: 

```
curl -X POST "http://localhost:8081/api/auth/login" \
     -H "Content-Type: application/json" \
     -d '{
           "email": "tejaswini@example.com",
           "password": "pasword123" 
         }'
 ```

###### Response: 

```
Invalid credentials!% 
```

##### Database Output: 

```
mysql> select * from users;
+----+---------------------------+-------------------+
| id | email                     | password          |
+----+---------------------------+-------------------+
|  7 | tejaswini@example.com     | password123       |
|  8 | emma.watson@example.com   | emmaSecure123     |
|  9 | robert.downey@example.com | ironMan789        |
| 10 | chris.evans@example.com   | captainAmerica456 |
+----+---------------------------+-------------------+
```


##### API 3 - Validate 

###### Path 

```
api/auth/validate
```

###### Request 

```
 curl -X GET "http://localhost:8081/api/auth/validate" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyMTIzIiwiZXhwIjoxNjk5MDcwOTcwfQ.tBBd27cNfOEZFrfztPXFVdHlTVjeJ9bp4KrPi8gZxJw"
                                                                                                                                                                                                      
```

###### Response 

```
false 
```

###### Request 

```
curl -X GET "http://localhost:8081/api/auth/validate" \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaHJpcy5ldmFuc0BleGFsZS5jb20iLCJpYXQiOjE3NDM2NjExNzgsImV4cCI6MTc0MzY2NDc3OH0.41K8L3mqGgAizNrmVppuGrb4d61eXrYCdwMC6Nc_gYo"
```

###### Response: 

```
true
```


