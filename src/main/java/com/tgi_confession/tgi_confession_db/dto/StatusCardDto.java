package com.tgi_confession.tgi_confession_db.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusCardDto {

    private String description;
    private String comment;
    private int likes;
    private int haha;
    private int love;
    private int wow;
    private int sad;
    private int angry;

    StatusCardDto() {

    }

    public StatusCardDto(String description, String comment, int likes, int haha, int love, int wow, int sad,
            int angry) {
        this.description = description;
        this.comment = comment;
        this.likes = likes;
        this.haha = haha;
        this.love = love;
        this.wow = wow;
        this.sad = sad;
        this.angry = angry;
    }

}
