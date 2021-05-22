package net.jp.vss;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Sql;
import org.seasar.doma.jdbc.Result;

@Dao
public interface FruitDao {

  @Select
  @Sql("SELECT * FROM known_fruits")
  List<Fruit> selectAll();

  @Insert
  Result<Fruit> insert(Fruit fruit);
}
