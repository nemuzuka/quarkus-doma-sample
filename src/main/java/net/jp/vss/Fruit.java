package net.jp.vss;

import lombok.Value;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(immutable = true)
@Table(name = "known_fruits")
@Value
public class Fruit {

  @Id final String id;

  @Column final String name;

  public Fruit(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
