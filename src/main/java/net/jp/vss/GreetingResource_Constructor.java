package net.jp.vss;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello-resteasy-constructor")
@ApplicationScoped
@Transactional
public class GreetingResource_Constructor {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final FruitDao fruitDao;

  public GreetingResource_Constructor(FruitDao fruitDao) {
    this.fruitDao = fruitDao;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    log.info("create fruit: {}", fruitDao.insert(new Fruit(UUID.randomUUID().toString(), "なまえ")));
    log.info("fruits: {}", fruitDao.selectAll());
    return "Hello RESTEasy";
  }
}
