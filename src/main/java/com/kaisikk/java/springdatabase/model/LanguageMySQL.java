package com.kaisikk.java.springdatabase.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "language")
public class LanguageMySQL {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String creator;

    private String feature;

    public LanguageMySQL() {
    }

    public LanguageMySQL(String name, String creator, String feature) {
        this.name = name;
        this.creator = creator;
        this.feature = feature;
    }
}
