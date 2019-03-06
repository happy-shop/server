package com.hs.data.entity;

import javax.persistence.*;

/**
 * Created by admin on 2019/3/6.
 */
@Entity
public class Account {

    private Integer id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
