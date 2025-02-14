package com.jobApplication.companyMS.company.service;


import com.jobApplication.companyMS.company.model.Company;
import com.jobApplication.companyMS.company.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;



    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {

        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> companyOpt = companyRepository.findById(id);
        if(companyOpt.isPresent()){
            Company companyUpdate = companyOpt.get();
            companyUpdate.setDescription(company.getDescription());

            companyUpdate.setName(company.getName());
            companyRepository.save(companyUpdate);
            return true;
        }
        return false;

    }
}
