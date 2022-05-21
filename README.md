## Maven Surefire Plugin
is designed to run our unit tests. The following patterns are the defaults so that the plugin will detect a class as a test:
- `**/Test*.java`
- `**/*Test.java`
- `**/*Tests.java`
- `**/*TestCase.java`

## Maven Failsafe Plugin
Designed to run our integration tests. Unlike the Maven Surefire Plugin, the Maven Failsafe Plugin is not a core plugin and hence won't be part of our project unless we manually include it. Detects our integration tests by the following default patterns:
- `**/IT*.java`
- `**/*IT.java`
- `**/*ITCase.java`


## Maven commands explained

The following commands will not run the integration tests which contains the [above-mentioned](#maven-failsafe-plugin) patterns. 
```bash
mvn surefire:test
```

```bash
mvn test
```

If we want to run our integration tests manually, we can do so with the following command:
```bash
mvn failsafe:integration-test failsafe:verify
```

The following will run both the integration and unit test if `maven-failsafe-plugin` is mentioned in the `pom` file.
```bash
mvn verify
```

For scenarios where we don't want to run our integration test (but still our unit tests), we can add -DskipITs to our Maven execution:
```bash
mvn verify -DskipITs
```

## [Slice Annotations](https://rieckpil.de/spring-boot-test-slices-overview-and-usage/)

### @WebMvcTest
This annotation creates a Spring TestContext with only relevant Spring MVC (model-view-controller) components:
- @Controller and @RestController
- @ControllerAdvice
- @JsonComponent
- Converter, Filter, WebMvcConfigurer

### @DataJpaTest
Spring TestContext contains the following components:
- @Repository or any class extending a Spring Data repository
- EntityManager and TestEntityManager ??
- DataSource

> Nevertheless, it's still worthing testing the entire JPA entity lifecycle by storing an entity, flushing the EntityManager, and retrieving the entity from the database again. This way, we ensure that Hibernate can destruct and construct our entity objects.

