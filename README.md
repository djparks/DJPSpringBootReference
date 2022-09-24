# My Reference/Playground for Spring Boot based REST, etc. learning, testing, etc.

Start of project roughly based on the tutorial `Spring Boot call REST API Tutorial` by Dav Vega at <https://www.youtube.com/watch?v=XEtPVm_SL2Q>

## Goals:
* Well covered in Unit Tests
* Integrate a number of technologies as possible for learning.
* Self-documenting as possible, but include comments throughout code of things I've learned and explanations.

## Running the applications

```BASH
mvn clean package
mvn spring-boot:run
```
Open Index page: <http://localhost:8080/>

```BASH
docker build -t djparks/sbreference .
docker-compose up
```

- The Todo service will make a request to JSON Placeholder and will persist those results to an in-memory database. This service runs on port 8080.
- Todo Application H2 Console <http://localhost:8080/h2-console>

