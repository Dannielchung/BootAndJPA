package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@Entity
@Table(name = "user")
public class User {
    private int id;
    private String name;
    private int groupId;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "g_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
