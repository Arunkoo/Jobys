package com.arun.jobys.service.impl;

import com.arun.jobys.entity.Company;
import com.arun.jobys.repository.CompanyRepository;
import com.arun.jobys.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
