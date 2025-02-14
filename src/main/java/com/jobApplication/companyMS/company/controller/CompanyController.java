package com.jobApplication.companyMS.company.controller;


import com.jobApplication.companyMS.company.model.Company;
import com.jobApplication.companyMS.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return ResponseEntity.ok("Company Created Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean flag = companyService.deleteCompany(id);
        if(!flag) {
            return new ResponseEntity<>("Company is not available to Delete!", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Company is Deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        boolean flag = companyService.updateCompany(id,company);
        if(!flag) {
            return new ResponseEntity<>("Company is not available to Update!", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Company is Updated!");
    }
}
