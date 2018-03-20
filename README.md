# Using Liquibase plugins effectively
## Step one - A simple API for customers
* Enter the following command in your git client ``` git checkout step-1```
* This will checkout the 1st commit with the necessary entity, controller and an initial sql script. 
* The SQL script is run at the start of the application to create a table and insert some sample data.
* To view all customers - ```http://localhost:8080/api/customers``` 
* To view only one customer - ```http://localhost:8080/api/customers/1``` 
* To create a customer - 
```
{
  "id":"3",
  "customerNumber":"103",
  "customerName":"Jon"
}
```
* The entity [Customer](https://github.com/amudhanlistertech/liquibase-demo/tree/master/src/main/java/amudhan/liquibase/entities/Customer.java)
* The controller [CustomerController](https://github.com/amudhanlistertech/liquibase-demo/blob/master/src/main/java/amudhan/liquibase/controller/CustomerController.java)
