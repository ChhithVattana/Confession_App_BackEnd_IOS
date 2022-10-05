package com.tgi_confession.tgi_confession_db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    public Category() {
    }

    public Category(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
