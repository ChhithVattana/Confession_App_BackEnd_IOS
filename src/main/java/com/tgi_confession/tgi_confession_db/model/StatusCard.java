package com.tgi_confession.tgi_confession_db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_status_card")
public class StatusCard {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Reaction reaction;

    public StatusCard() {

    }

    public StatusCard(String id, Date date, String description, String status) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.status = status;
    }

}
