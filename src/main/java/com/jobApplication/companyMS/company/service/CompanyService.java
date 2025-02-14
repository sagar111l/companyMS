package com.jobApplication.companyMS.company.service;



import com.jobApplication.companyMS.company.model.Company;

import java.util.List;


public interface CompanyService {
    public List<Company> getAll();

    public Company getById(Long id);

    public void createCompany(Company company);

    public boolean deleteCompany(Long id);

    public boolean updateCompany(Long id, Company company);
}
