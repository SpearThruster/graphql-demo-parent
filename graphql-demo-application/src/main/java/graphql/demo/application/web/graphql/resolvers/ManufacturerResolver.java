package graphql.demo.application.web.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.demo.application.web.graphql.dataloader.ManufacturerDataLoaderFactory;
import graphql.demo.application.web.model.Article;
import graphql.demo.application.web.model.Manufacturer;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class ManufacturerResolver implements GraphQLResolver<Article> {

  public CompletableFuture<Manufacturer> getManufacturers(Article article, DataFetchingEnvironment dfe) {
    final DataLoader<Integer, Manufacturer> dataLoader = ((GraphQLContext) dfe.getContext())
      .getDataLoaderRegistry().orElseThrow(RuntimeException::new)
      .getDataLoader(ManufacturerDataLoaderFactory.MANUFACTURER_DATA_LOADER);
    return dataLoader.load(article.getId());
  }
}
