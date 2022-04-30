# References
1. [Guide to Testing With the Spring Boot Starter Test](https://rieckpil.de/guide-to-testing-with-spring-boot-starter-test/)
   1. ingredients of spring boot starter test
   2. how to exclude a specific dependency or use a different dependency other than the default dependencies
   3. migration from JUnit 4 to 5
   4. intro to Mockito
   5. Introduction to Hamcrest
   6. Introduction to AssertJ
   7. Introduction to JSONassert
   8. Introduction to JsonPath
2. [A Set of Unit Testing Rules](https://www.artima.com/weblogs/viewpost.jsp?thread=126923)
   - A test is not a unit test if:
     1. It talks to the database 
     2. It communicates across the network 
     3. It touches the file system 
     4. It can't run at the same time as any of your other unit tests 
     5. You have to do special things to your environment (such as editing config files) to run it.
3. [How Spring Boot’s Autoconfiguration Work](https://www.marcobehler.com/guides/spring-boot)
4. [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
5. [Five JUnit 5 Features You Might Not Know Yet](https://rieckpil.de/five-junit-5-features-you-might-not-know-yet/)
6. [Mockito](https://site.mockito.org/)