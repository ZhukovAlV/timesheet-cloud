package com.example.microservices.service_sample.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long userId;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
}

