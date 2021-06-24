package com.example.microservices.service_user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long userId;

    @Column(name="PERSONALNUMBER")
    private Long personalNumber;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="MIDLENAME")
    private String middleName;

    @Column(name="LOGIN")
    private String login;

    @Column(name="POSITION_E")
    private String positionEng;

    @Column(name="POSITION_R")
    private String positionRus;

    @Column(name="ACCESSLEVEL")
    private String accessLevel;
}

