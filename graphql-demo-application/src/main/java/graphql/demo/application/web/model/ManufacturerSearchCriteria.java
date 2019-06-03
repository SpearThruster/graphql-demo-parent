package graphql.demo.application.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManufacturerSearchCriteria {

  private String articleId;
  private String country;
}
