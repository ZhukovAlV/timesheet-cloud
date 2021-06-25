package com.example.microservices.service_user.service;

import com.example.microservices.service_user.entity.Orgdata;

import java.util.Optional;

public interface OrgdataService {
    Iterable<Orgdata> findAll();

    Optional<Orgdata> findById(Long id);

    Orgdata save(Orgdata orgdata);

    void deleteById(Long id);
}
