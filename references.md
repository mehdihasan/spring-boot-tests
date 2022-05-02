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
3. [Maven Setup For Testing Java Applications](https://rieckpil.de/maven-setup-for-testing-java-applications/)
   1. Maven Archetype
   2. Maven Surefire & Failsafe Plugins 
   3. Maven built-in lifecycles
      1. `validate`: validate that our project setup is correct (e.g., we have the correct Maven folder structure)
      2. `compile`: compile our source code with javac 
      3. `test`: run our unit tests 
      4. `package`: build our project in its distributable format (e.g., JAR or WAR)
      5. `verify`: run our integration tests and further checks (e.g., the OWASP dependency check)
      6. `install`: install the distributable format into our local repository (~/.m2 folder)
      7. `deploy`: deploy the project to a remote repository (e.g., Maven Central or a company hosted Nexus Repository/Artifactory)
4. [Java Testing - JUnit 5 Crash Course](https://www.youtube.com/watch?v=flpmSXVTqBI)
5. [How Spring Boot’s Autoconfiguration Work](https://www.marcobehler.com/guides/spring-boot)
6. [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
7. [Five JUnit 5 Features You Might Not Know Yet](https://rieckpil.de/five-junit-5-features-you-might-not-know-yet/)
8. [Mockito](https://site.mockito.org/)
9. [Spring Boot Test Slices: Overview and Usage](https://rieckpil.de/spring-boot-test-slices-overview-and-usage/)
10. [recommended-resources-for-testing-java-applications](https://rieckpil.de/recommended-resources-for-testing-java-applications/)
11. [Spring Data JPA Persistence Layer Tests With @DataJpaTest](https://rieckpil.de/test-your-spring-boot-jpa-persistence-layer-with-datajpatest/)