package example;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.Simulation;

public class JsonPlaceholderSimulation extends Simulation {

  public JsonPlaceholderSimulation() {
    setUp(
        scenario("Get one post")
            .exec(
                http("Get post 1")
                    .get("https://jsonplaceholder.typicode.com/posts/1")
                    .check(status().is(200))
            )
            .injectOpen(atOnceUsers(1))
    );
  }
}
