# mockito
Repo for the Mockito Unit testing Udemy course

For mockito faq - https://github.com/mockito/mockito/wiki/FAQ
Mockito repo for course - https://github.com/in28minutes/MockitoTutorialForBeginners

Steps involved in using an in-memory db:
1. Input the JPA and h2 dependencies in pom.
2. Create the entity class.
3. Add properties in application.properties(refer) to enable options 	regarding h2.
4. To view the output in h2 db (property needs to be enabled in prior):
	- Start the app.
	- go to /h2-console.
	- JDBC Url:  jdbc:h2:mem:testdb (Use only this, as this is the db used by springboot).
	- leave the rest of the settings to default and connect.
	- you can see that a db has been created for the  entity class.
	- each instance of the entity class will form a row in the db.
5. Create a data.sql file in src/main/resources.
6. Put some insert commands in it.
7. On starting the app, you can see that data has been populated in the db     	from the insert commands. 
8. Now you have to build a service to retrieve data from db. That can be  	done using a repository (Refer ItemRepository). That can be easily done 	using Spring-data-jpa.Separate method to retrieve all data is also 	written in the controller.
9. The entity needs to have a default constructor, else whitelabel error 	will be thrown.