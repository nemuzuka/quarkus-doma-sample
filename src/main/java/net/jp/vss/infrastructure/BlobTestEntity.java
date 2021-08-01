package net.jp.vss.infrastructure;

import java.sql.Blob;
import java.sql.SQLException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Slf4j
@Entity(immutable = true)
@Table(name = "blob_test")
@Getter
@EqualsAndHashCode(exclude = "blobData")
@ToString(exclude = "blobData")
public class BlobTestEntity {

  @Id
  @Column(name = "id")
  private final String id;

  @Column(name = "blob_data")
  private final Blob blobData;

  public BlobTestEntity(String id, Blob blobData) {
    this.id = id;
    this.blobData = blobData;
  }

  public static void setBlobImage(Blob blob, byte[] bytes) {
    try {
      blob.setBytes(1, bytes);
    } catch (SQLException e) {
      log.error("SQLException :", e);
      throw new AssertionError(e.getMessage(), e);
    }
  }
}
