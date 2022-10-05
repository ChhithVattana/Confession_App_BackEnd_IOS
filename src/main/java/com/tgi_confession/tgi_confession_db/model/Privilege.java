package com.tgi_confession.tgi_confession_db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Privilege {
  @Id
  @GeneratedValue
  private long privilegeId;

  private String name;

  private String description;

  public Privilege(long privilegeId, String name, String description) {
    this.privilegeId = privilegeId;
    this.name = name;
    this.description = description;
  }

  public Privilege() {
  }
}
