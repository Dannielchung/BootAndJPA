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
    private Group group;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "u_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne()
    @JoinColumn(name = "g_id", referencedColumnName = "id")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
