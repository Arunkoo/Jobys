package com.arun.jobys.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "Companies")
@Getter @Setter
public class Company extends baseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Logo", length = 500)
    private String logo;

    @Column(name = "Industry",nullable = false, length = 100)
    private String industry;

    @Column(name = "Size", nullable = false, length = 50)
    private String size;

    @Column(name = "Rating", nullable = false, precision = 3, scale = 2)
    private BigDecimal rating;

    @Column(name = "Locations", length = 1000)
    private String locations;

    @Column(name = "Founded", nullable = false)
    private Integer founded;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "Employees")
    private Integer employees;

    @Column(name = "Website", length = 500)
    private String website;
}
