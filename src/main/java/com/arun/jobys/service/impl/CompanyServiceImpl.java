package com.arun.jobys.service.impl;

import com.arun.jobys.dto.CompanyDto;
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
    public List<CompanyDto> getAllCompanies() {
        List<Company> companylist = companyRepository.findAll();
        return companylist.stream().map(this::transferCompanyDto).collect(Collectors.toList());
    }

    private CompanyDto transferCompanyDto(Company company){
        return new CompanyDto(
                company.getId(),
                company.getName(),
                company.getLogo(),
                company.getIndustry(),
                company.getSize(),
                company.getRating(),
                company.getLocations(),
                company.getFounded(),
                company.getDescription(),
                company.getEmployees(),
                company.getWebsite(),
                company.getCreatedAt()
        );
    }
}
