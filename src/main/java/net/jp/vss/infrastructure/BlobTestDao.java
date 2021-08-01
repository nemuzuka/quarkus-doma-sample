package net.jp.vss.infrastructure;

import java.sql.Blob;
import java.util.Optional;
import org.seasar.doma.BlobFactory;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Sql;
import org.seasar.doma.jdbc.Result;

@Dao
public interface BlobTestDao {

  @Insert
  Result<BlobTestEntity> insert(BlobTestEntity target);

  @Select
  @Sql("SELECT * FROM blob_test WHERE id = /*id*/'id-001'")
  Optional<BlobTestEntity> selectById(String id);

  @BlobFactory
  Blob createBlob();
}
