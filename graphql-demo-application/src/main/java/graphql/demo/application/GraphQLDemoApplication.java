package graphql.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class GraphQLDemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(GraphQLDemoApplication.class, args);
  }
}
