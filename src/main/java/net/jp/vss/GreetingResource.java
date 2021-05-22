package net.jp.vss;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
@ApplicationScoped
@Transactional
public class GreetingResource {

  private final FruitDao fruitDao;

  public GreetingResource(FruitDao fruitDao) {
    this.fruitDao = fruitDao;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    fruitDao.insert(new Fruit(UUID.randomUUID().toString(), "なまえ"));
    fruitDao.selectAll();
    return "Hello RESTEasy";
  }
}
