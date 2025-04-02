# authservice
Auth for Concert Booking 
## Instructions to Run the Auth Application: 

##### MySQL db installation


##### Start the db 

*  mysql -u root -p
*  Enter password - 

##### Create db and tables 

* CREATE DATABASE authdb;

##### Run the Spring boot Application 

* mvn spring-boot:run

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
{
    "id": 1,
    "email": "tejaswini@example.com",
    "password": "password123"
}
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
{
    "id": 2,
    "email": "john.doe@example.com",
    "password": "securePass456"
}

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
<<<<<<< HEAD
Login successful!
=======
Login successful! 🔥
>>>>>>> 83daecf (Update README.md)
```


*  Login With Wrong Credentials : 

###### Request: 

```
curl -X POST "http://localhost:8081/api/auth/login" \
     -H "Content-Type: application/json" \
     -d '{
           "email": "tejaswini@example.com",
           "password": "wrongpassword"
         }'                                                                                                                                                                     
```

###### Response: 

```
<<<<<<< HEAD
Invalid credentials! 
=======
Invalid credentials! ❌     
>>>>>>> 83daecf (Update README.md)
```

##### Database Output: 

```

mysql> select * from users;
+----+-----------------------+---------------+
| id | email                 | password      |
+----+-----------------------+---------------+
|  1 | tejaswini@example.com | password123   |
|  2 | john.doe@example.com  | securePass456 |
|  3 | alice@example.com     | alicePass789  |
+----+-----------------------+---------------+
```
