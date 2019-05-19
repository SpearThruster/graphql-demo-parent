package graphql.demo.application.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ConfigurationProperties("graphql-demo-application")
@Component
@Data
@Validated
public class GraphQLConfiguration {

  @NotNull
  private String apiBasePath;
}
