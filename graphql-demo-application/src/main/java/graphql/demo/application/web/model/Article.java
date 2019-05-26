package graphql.demo.application.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

  private Integer id;
  private String title;
  private String image;
  private int quantity;
  private Season season;
  private String year;
  private List<Manufacturer> manufacturers;

}
