package com.arun.jobys.service.impl;

import com.arun.jobys.entity.Company;
import com.arun.jobys.service.ICompanyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {
    @Override
    public List<Company> getAllCompanies() {
        return List.of();
    }
}
