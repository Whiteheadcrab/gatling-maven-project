package org.example;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://jsonplaceholder.typicode.com")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/jxl,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("pl-PL,pl;q=0.9,uk-UA;q=0.8,uk;q=0.7,ru-UA;q=0.6,ru;q=0.5,en-US;q=0.4,en;q=0.3")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/155.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"155\", \"Chromium\";v=\"155\", \"Not(A:Brand\";v=\"24"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "none"),
    Map.entry("sec-fetch-user", "?1")
  );


  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .exec(
      http("request_0")
        .get("/posts/1")
        .headers(headers_0)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
