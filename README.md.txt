# Mint Customer REST Service

This project contains basic REST services example for Mint Customer Services

### Prerequisites

Spring latest version 4.0.0.RELEASE and utilize Spring Jackson JSON integration to send JSON response in the rest call response. 
pom.xml provides all the dependancies.

```
REST Services urls with postman
```
List customer: http://localhost:8080/SpringRestExample/rest/cust
Create customer: http://localhost:8080/SpringRestExample/rest/create
List customer: http://localhost:8080/SpringRestExample/rest/update/{firstname}
List customer: http://localhost:8080/SpringRestExample/rest/delete/{firstname}

Sample JSON:
{"firstname":"Tom","lastname":"Martin","addresses":"Sydney"}

## Running the tests

Test case check for all the REST webservices dummy request in class TestMintCustomerRESTService

