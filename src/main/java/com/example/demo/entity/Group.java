package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cvter on 2017/6/1.
 */
@Entity
@Table(name = "team")
public class Group {
    private int id;
    private String name;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "g_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
