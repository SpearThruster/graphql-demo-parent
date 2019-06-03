package graphql.demo.application.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {

  private Integer id;
  private String name;
  private List<Article> articles;
  private String country;
}
