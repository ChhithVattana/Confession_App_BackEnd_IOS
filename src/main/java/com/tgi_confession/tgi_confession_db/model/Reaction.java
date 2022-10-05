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
@Table(name = "tbl_reaction")
public class Reaction {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "likes")
    private int likes;

    @Column(name = "love")
    private int love;

    @Column(name = "haha")
    private int haha;

    @Column(name = "wow")
    private int wow;

    @Column(name = "sad")
    private int sad;

    @Column(name = "angry")
    private int angry;

    public Reaction() {
    }

    public Reaction(String id, int likes, int haha, int love, int wow, int sad, int angry) {
        this.id = id;
        this.likes = likes;
        this.haha = haha;
        this.love = love;
        this.wow = wow;
        this.sad = sad;
        this.angry = angry;
    }
}
