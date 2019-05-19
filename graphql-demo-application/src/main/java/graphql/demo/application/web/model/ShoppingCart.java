package graphql.demo.application.web.model;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCart {
  private List<Order> orders;
}
