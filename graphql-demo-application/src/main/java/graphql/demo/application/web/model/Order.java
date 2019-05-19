package graphql.demo.application.web.model;

import lombok.Data;

@Data
public class Order {

  private String articleId;
  private int quantity;
}
