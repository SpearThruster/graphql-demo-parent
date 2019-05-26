package graphql.demo.application.web;

import graphql.demo.application.config.ApplicationConfiguration;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@AllArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

  private final ApplicationConfiguration configuration;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // All resources go to where they should go
    registry
        .addResourceHandler(
            "/**/*.css",
            "/**/*.html",
            "/**/*.js",
            "/**/*.svg",
            "/**/*.map",
            "/**/*.jsx",
            "/**/*.png",
            "/**/*.ttf",
            "/**/*.woff",
            "/**/*.woff2")
        .setCachePeriod(0)
        .addResourceLocations("classpath:/static/");

    registry
        .addResourceHandler("/manifest.json")
        .addResourceLocations("classpath:/static/manifest.json");

    registry
        .addResourceHandler("/", "/**")
        .setCachePeriod(0)
        .addResourceLocations("classpath:/static/index.html")
        .resourceChain(true)
        .addResolver(
            new PathResourceResolver() {
              @Override
              protected Resource getResource(@NotNull String resourcePath, Resource location) {
                if (resourcePath.startsWith(configuration.getApiBasePath())
                    || resourcePath.startsWith(configuration.getApiBasePath().substring(1))) {
                  return null;
                }

                return location.exists() && location.isReadable() ? location : null;
              }
            });
  }
}
