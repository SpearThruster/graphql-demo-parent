package graphql.demo.application.web.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import graphql.demo.application.core.ManufacturerService;
import graphql.demo.application.web.model.Article;
import graphql.demo.application.web.model.Manufacturer;
import lombok.AllArgsConstructor;
import graphql.demo.application.core.ArticleService;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

  private ArticleService articleService;
  private ManufacturerService manufacturerService;

  public List<Article> getArticle(String id) {

    if (id == null) {
      return articleService.findAll();
    } else {
      return newArrayList(articleService.findAll().get(0));
    }
  }

  public List<Manufacturer> getManufacturer(String id) {
    if (id == null) {
      return manufacturerService.findAll();
    } else {
      return newArrayList(manufacturerService.findAll().get(0));
    }
  }
}
