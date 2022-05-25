package com.example.firstservice;

import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {

  public final Environment env;

  @GetMapping("welcome")
  public String welcome() {
    return "welcome first service";
  }

  @GetMapping("message")
  public String message(@RequestHeader("first-request") String header) {
    log.info(header);
    return "hello world first-request-service";
  }

  @GetMapping("check")
  public String check(HttpServletRequest request) {
    log.info("server port : {}", request.getServerPort());
    return String.format("Hi, there, This is a message from first-service on server port %s",
        env.getProperty("local.server.port"));
  }
}
