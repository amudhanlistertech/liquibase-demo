# Using Liquibase plugins effectively
## Step one - A simple API for customers
* Enter the following command in your git client ``` git checkout step-1```
* The SQL script is run at the start of the application to create a table named customer in the database customerdb
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

## Step two - Generating schema
* Enter the following command in your git client ```git checkout step-2```
* Create a changelog-master file with the name ```db.changelogp-master.xml```
* Add this in the properties file ```spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml```
* Add the liquibase-maven-plugin and set up its configuration such as

```
<outputChangeLogFile>src/main/resources/db/changelog/changelog.xml</outputChangeLogFile>
<changeLogFile>src/main/resources/db/changelog/db.changelog-master.xml</changeLogFile>
```

* Now generate the schema from the existing database

```
mvn liquibase:generateChangeLog
```

* This will generate a change with create script for the table customer
* Now add the goal changelogSync to the liquibase-maven:plugin.
* What this goal will do is, it will ignore the generated schema by the command  and mark the generated tables as created```liquibase:generateChangeLog``` 

```
mvn liquibase:changelogSync
```
Or this can be added as part of the execution

```
<executions>
	<execution>
		<phase>process-resources</phase>
		<goals>
			<goal>changelogSync</goal>
		</goals>
	</execution>
</executions> 
```

* Any table, column or anything that is going to be added here after, will be tracked by liquibase 