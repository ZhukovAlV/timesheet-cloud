package com.example.microservices.service_sample.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "TIMEDATA")
public class TimeData {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "HOUR")
    private Integer hour;
    @Column(name = "TYPE_D")
    private String type;
    @Column(name = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
