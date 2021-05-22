package net.jp.vss;

import java.util.UUID;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello-resteasy")
@ApplicationScoped
@Transactional
public class GreetingResource {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Inject FruitDao fruitDao;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    log.info("create fruit: {}", fruitDao.insert(new Fruit(UUID.randomUUID().toString(), "なまえ")));
    log.info(
        "fruits: {}", fruitDao.selectAll().stream().map(Fruit::getId).collect(Collectors.toList()));
    return "Hello RESTEasy";
  }
}
