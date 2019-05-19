package graphql.demo.application.web.rest;

import graphql.demo.application.web.model.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${graphql-demo-application.api-base-path}")
public class ArticleController {

  @GetMapping("/article")
  public List<Article> getAllArticles() {
    return new ArrayList<>();
  }

  @GetMapping("/article/{id}")
  public Article getArticle(String id) {
    return new Article();
  }
}
