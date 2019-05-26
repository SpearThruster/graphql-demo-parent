package graphql.demo.application.config;

import graphql.demo.application.web.graphql.dataloader.AbstractDataLoader;
import lombok.AllArgsConstructor;
import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@AllArgsConstructor
public class AppDataLoaderRegistry  {

  @Resource
  private List<AbstractDataLoader> dataLoaders;

  @Bean
  public DataLoaderRegistry dataLoaderRegistry() {
    DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();
    dataLoaders.forEach(x -> dataLoaderRegistry.register(x.getKey(), x));
    return dataLoaderRegistry;
  }
}
