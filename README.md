# Gatling Maven Demo

A first Java simulation based on the [official Gatling Maven demo](https://github.com/gatling/gatling-maven-plugin-demo-java).

Requires JDK 17 or later and Maven 3.9 or later. Run commands from the project root.

## Run the demo

```powershell
mvn gatling:test "-Dgatling.simulationClass=example.BasicSimulation"
```

The simulation sends one virtual user to `GET https://api-ecomm.gatling.io/session`.
It fails if any request fails. This command makes requests to Gatling's public demo API.

To change the number of virtual users:

```powershell
mvn gatling:test "-Dgatling.simulationClass=example.BasicSimulation" "-Dvu=5"
```

After a run, open `target/gatling/<run-directory>/index.html` for the HTML report.

## Try a free practice API

[JSONPlaceholder](https://jsonplaceholder.typicode.com/) is a free fake REST API with no signup or API key.
The example reads one sample post:

```http
GET https://jsonplaceholder.typicode.com/posts/1
Accept: application/json
```

Open `requests/jsonplaceholder.http` in IntelliJ IDEA and click the run icon beside the request
(requires the IDE's HTTP Client support). It checks HTTP 200 and that `id` and `userId` are both 1.
You can also send the request from PowerShell:

```powershell
Invoke-RestMethod https://jsonplaceholder.typicode.com/posts/1
```

Run the same request in Gatling with one virtual user:

```powershell
mvn gatling:test "-Dgatling.simulationClass=example.JsonPlaceholderSimulation"
```

Edit `src/test/java/example/JsonPlaceholderSimulation.java` to change the request or its checks.
This example sends a single request to the public service for practice.

## Edit the demo

- `pom.xml`: dependency, plugin versions, and Java compiler settings.
- `src/test/java/example/BasicSimulation.java`: HTTP protocol, scenario, virtual users, and assertion.
- `src/test/resources/gatling.conf`: Gatling configuration overrides.
- `src/test/resources/logback-test.xml`: logging configuration, including optional HTTP request debugging.

To compile without sending HTTP requests:

```powershell
mvn test-compile
```

The files under `src/main/resources/archetype-resources` are the original Maven archetype templates; executable simulations belong under `src/test/java`.
