package graphql.demo.application.core;

import graphql.demo.application.web.model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.*;

@Service
public class ArticleService {

  private final List<Article> products = new ArrayList<>();

  private ArticleService() {
    List<Article> demoProducts =
        IntStream.range(0, 250)
            .mapToObj(
                x ->
                    Article.builder()
                        .image("12312321321")
                        .title(format("Article%d", x))
                        .id(valueOf(x))
                        .quantity((int) (Math.random() * 100))
                        .build())
            .collect(Collectors.toList());
    products.addAll(demoProducts);
  }

  public Article findById() {
    return products.get(1);
  }

  public List<Article> findAll() {
    return products;
  }
}
