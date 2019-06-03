package graphql.demo.application.core;

import graphql.demo.application.web.model.Manufacturer;
import graphql.demo.application.web.model.ManufacturerSearchCriteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;

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
              .id(x)
              .country(Math.random() * 100 > 50 ? "MK" : "CHE")
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

  public List<Manufacturer> findAllById(List<Integer> ids) {
    System.out.println("Are you called once?");
    return manufacturers;
  }

  public List<List<Manufacturer>> findAllBySearchCriteria(List<ManufacturerSearchCriteria> manufacturerSearchCriteria) {

    List<List<Manufacturer>> collect = manufacturerSearchCriteria.stream().map(x -> manufacturers).collect(Collectors.toList());
    System.out.println("How about you? Once?");
    return collect;
  }
}
