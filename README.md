# mockito
Repo for the Mockito Unit testing Udemy course

For mockito faq - https://github.com/mockito/mockito/wiki/FAQ
Mockito repo for course - https://github.com/in28minutes/MockitoTutorialForBeginners

Steps involved in using an in-memory db:
1. Input the JPA and h2 dependencies in pom.
2. Create the entity class.
3. Add properties in application.properties(refer) to enable options regarding h2.
4. To view the output in h2 db (property needs to be enabled in prior):
	- Start the app.
	- go to /h2-console.
	- JDBC Url:  jdbc:h2:mem:testdb (Use only this, as this is the db used by springboot).
	- leave the rest of the settings to default and connect.