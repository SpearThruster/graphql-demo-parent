package graphql.demo.application.web.graphql.dataloader;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;

public abstract class AbstractDataLoader<K, V> extends DataLoader<K, V> {
  public AbstractDataLoader(BatchLoader<K, V> batchLoadFunction) {
    super(batchLoadFunction);
  }

  public abstract String getKey();

}
