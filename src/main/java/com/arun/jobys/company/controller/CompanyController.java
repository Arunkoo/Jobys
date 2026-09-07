package com.arun.jobys.company.controller;

import com.arun.jobys.entity.Company;
import com.arun.jobys.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final ICompanyService companyService;

    @Autowired
    public CompanyController(ICompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping(version = "1.0")
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companyList = companyService.getAllCompanies();
        return ResponseEntity.ok().body(companyList);
    }
}
