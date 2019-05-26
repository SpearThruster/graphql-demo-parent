package graphql.demo.application.config;

import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLContextBuilder;
import lombok.AllArgsConstructor;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

@Configuration
@AllArgsConstructor
public class GraphQLConfiguration implements GraphQLContextBuilder {

  private DataLoaderRegistry dataLoaderRegistry;

  @Override
  public GraphQLContext build(HttpServletRequest req, HttpServletResponse res) {
    GraphQLContext context = new GraphQLContext(req, res);
    context.setDataLoaderRegistry(dataLoaderRegistry);
    return context;
  }

  @Override
  public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
    GraphQLContext context = new GraphQLContext();
    context.setDataLoaderRegistry(dataLoaderRegistry);
    return context;
  }

  @Override
  public GraphQLContext build() {
    GraphQLContext context = new GraphQLContext();
    context.setDataLoaderRegistry(dataLoaderRegistry);
    return context;
  }
}
