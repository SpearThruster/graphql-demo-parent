package graphql.demo.application.web.graphql.dataloader;

import graphql.demo.application.core.ManufacturerService;
import graphql.demo.application.web.model.Manufacturer;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CompletableFuture;

@Configuration
@AllArgsConstructor
public class ManufacturerDataLoaderFactory {

  private ManufacturerService manufacturerService;

  /**
   * We reference this bad boy by this string. RIP types.
   */
  public static final String MANUFACTURER_DATA_LOADER = "manufacturers";

  @Bean
  public AbstractDataLoader<Integer, Manufacturer> manufacturerDataLoader() {
    return new AbstractDataLoader<Integer, Manufacturer>(manufacturerIds ->
      CompletableFuture.supplyAsync(() ->
        manufacturerService.findAllById(manufacturerIds))) {
      @Override
      public String getKey() {
        return MANUFACTURER_DATA_LOADER;
      }
    };
  }
}
