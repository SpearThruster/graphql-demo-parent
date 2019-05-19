package graphql.demo.application.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

  private String id;
  private String title;
  private String image;
  private int quantity;
  private Season season;
  private String year;

}
