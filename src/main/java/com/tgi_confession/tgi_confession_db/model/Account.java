package com.tgi_confession.tgi_confession_db.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    private boolean enabled = true;

    public Account() {

    }

    public Account(Long id, String username, String password, Set<Role> roles, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
    }
}
