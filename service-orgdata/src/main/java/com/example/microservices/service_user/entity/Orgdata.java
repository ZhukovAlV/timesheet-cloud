package com.example.microservices.service_user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ORGDATA")
public class Orgdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="ORGNAME")
    private String orgName;

    @Column(name="DEPNAME")
    private String depName;

    @Column(name="DEPBOSS")
    private String depBoss;

    @Column(name="RESPONDER")
    private String responder;

    @Column(name="BEGINDATE")
    private LocalDate dateBegin;

    @Column(name="ENDDATE")
    private LocalDate dateEnd;
}
