package com.kaisikk.java.springdatabase.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String description;

    @Lob
    @Column(length = 20971520)
    private Byte[] image;


}
