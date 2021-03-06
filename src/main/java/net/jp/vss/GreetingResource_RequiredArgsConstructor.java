package net.jp.vss;

import java.util.UUID;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Path("/hello-resteasy-required-args-constructor")
@ApplicationScoped
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GreetingResource_RequiredArgsConstructor {

  private final FruitDao fruitDao;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    log.info("create fruit: {}", fruitDao.insert(new Fruit(UUID.randomUUID().toString(), "なまえ")));
    log.info(
        "fruits: {}", fruitDao.selectAll().stream().map(Fruit::getId).collect(Collectors.toList()));
    var vo = new ValueObject("a", "b");
    log.info("vo:{}, data1={}, data2={}", vo, vo.getData1(), vo.getData2());
    return "Hello RESTEasy";
  }
}
