package com.example.microservices.service_user.controller;

import com.example.microservices.service_user.entity.Orgdata;
import com.example.microservices.service_user.service.OrgdataService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orgdata")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@AllArgsConstructor
@Log4j2
public class OrgdataController {
    private final OrgdataService orgdataService;

    @GetMapping("/{orgId}")
    public Optional<Orgdata> findById(@PathVariable Long orgId) {
        log.info("Find orgdata by ID");
        return orgdataService.findById(orgId);
    }

   @GetMapping("")
   public Iterable<Orgdata> findAll() {
       log.info("Find all orgdata request");
       return orgdataService.findAll();
   }

    @PutMapping("")
    public Orgdata updateOrgdata(@RequestBody Orgdata orgdata) {
        log.info("Update orgdata by " + orgdata.getId());
        return orgdataService.save(orgdata);
    }

    @PostMapping("")
    public Orgdata addOrgdata(@RequestBody Orgdata orgdata) {
        log.info("Add orgdata");
        return orgdataService.save(orgdata);
    }

    @DeleteMapping("/{orgId}")
    public ResponseEntity<?> deleteOrgdata(@PathVariable Long orgId) {
        log.info("Delete orgdata by ID");
        if (orgdataService.findById(orgId).isPresent()) {
            orgdataService.deleteById(orgId);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }
}
