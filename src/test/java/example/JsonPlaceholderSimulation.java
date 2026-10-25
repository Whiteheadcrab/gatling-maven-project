package example;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class JsonPlaceholderSimulation extends Simulation {

  private final HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://jsonplaceholder.typicode.com")
      .acceptHeader("application/json");

  private final ScenarioBuilder getPost = scenario("Read a sample post")
      .exec(http("GET /posts/1")
          .get("/posts/1")
          .check(
              status().is(200),
              jsonPath("$.id").ofInt().is(1),
              jsonPath("$.userId").ofInt().is(1)));

  {
    setUp(getPost.injectOpen(atOnceUsers(1)))
        .protocols(httpProtocol)
        .assertions(global().failedRequests().count().is(0L));
  }
}
