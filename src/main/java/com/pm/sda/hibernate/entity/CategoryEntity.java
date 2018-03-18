package com.pm.sda.hibernate.entity;


import javax.persistence.*;

@Entity
@Table(name = "category")

public class CategoryEntity {
    @Column(name = "name", nullable = false, length = 128)
    private String name;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
