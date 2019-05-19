package graphql.demo.application.core;

import graphql.demo.application.web.model.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.lang.String.valueOf;

@Service
public class ManufacturerService {

  private final List<Manufacturer> manufacturers = new ArrayList<>();

  private ManufacturerService(ArticleService articleService) {
    List<Manufacturer> demoProducts =
        IntStream.range(0, 250)
            .mapToObj(
                x ->
                    Manufacturer.builder()
                        .name(format("Manufacturer-%d", x))
                        .articles(articleService.findAll())
                        .id(valueOf(x))
                        .build())
            .collect(Collectors.toList());
    manufacturers.addAll(demoProducts);
  }

  public Manufacturer findById() {
    return manufacturers.get(1);
  }

  public List<Manufacturer> findAll() {
    return manufacturers;
  }
}
