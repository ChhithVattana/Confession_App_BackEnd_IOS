package com.tgi_confession.tgi_confession_db.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Role {
  @Id
  @GeneratedValue
  private Long roleId;
  private String name;
  private String description;
  @ManyToMany(fetch = LAZY)
  private Set<Privilege> privileges = new HashSet<>(0);

  public Role(Long roleId, String name, String description, Set<Privilege> privileges) {
    this.roleId = roleId;
    this.name = name;
    this.description = description;
    this.privileges = privileges;
  }

  public Role() {
  }
}
