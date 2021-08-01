package net.jp.vss.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import io.quarkus.test.junit.QuarkusTest;
import java.util.UUID;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
@QuarkusTest
class BlobTestDaoTest {

  @Inject BlobTestDao sut;

  @Test
  @Transactional
  void testInsert() {
    // setup
    var blob = sut.createBlob();
    BlobTestEntity.setBlobImage(blob, new byte[] {0x01, 0x02, 0x03});
    var fileImage = new BlobTestEntity(UUID.randomUUID().toString(), blob);

    // exercise
    var actual = sut.insert(fileImage);

    // verify
    assertThat(actual.getCount()).isEqualTo(1);
    var onRdbms = sut.selectById(fileImage.getId());
    assertThat(onRdbms).isPresent().get().isEqualTo(fileImage);
  }
}
