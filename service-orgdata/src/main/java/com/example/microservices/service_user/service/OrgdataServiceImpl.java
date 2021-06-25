package com.example.microservices.service_user.service;

import com.example.microservices.service_user.entity.Orgdata;
import com.example.microservices.service_user.repository.OrgdataRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrgdataServiceImpl implements OrgdataService {

    private final OrgdataRepository orgdataRepository;

    @Override
    public Iterable<Orgdata> findAll() {
        return orgdataRepository.findAll();
    }

    @Override
    public Optional<Orgdata> findById(Long theId) {
        return orgdataRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(Orgdata theOrgdata) {
        orgdataRepository.save(theOrgdata);
    }

    @Override
    @Transactional
    public void deleteById(Long theId) {
        orgdataRepository.deleteById(theId);
    }
}