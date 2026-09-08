package com.arun.jobys.service.impl;

import com.arun.jobys.entity.Company;
import com.arun.jobys.repository.CompanyRepository;
import com.arun.jobys.service.ICompanyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
