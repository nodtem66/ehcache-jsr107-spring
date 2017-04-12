# Ehcache 3.x JSR-107 Spring 4.0 Demo
Just another demo forked from [@gibsong](https://github.com/gibsong/ehcache-jsr107-spring).
I tried to config **Disk Tier** in `ehcache.xml`. By trials and errors, This config success to use caching on disk

## Running the application:
* at the project root directory in command-line, type `mvnw spring-boot:run` 
* open browser, goto `http://localhost:8080/person/{ssn}` where {ssn} should be replaced by an actual number,
like the following: `http://localhost:8080/person/987654321`

## Documentation
* `/person/{ssn}` print Person infomation with number `ssn`
* `/cache/{ssn}` print cache of Person with number `ssn`
* `/caches` print name of all available caches