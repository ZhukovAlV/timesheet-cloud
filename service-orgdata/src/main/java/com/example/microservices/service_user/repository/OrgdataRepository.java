package com.example.microservices.service_user.repository;

import com.example.microservices.service_user.entity.Orgdata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgdataRepository extends CrudRepository<Orgdata, Long> {
}
