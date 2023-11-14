package org.example.controller;

import org.example.model.Company;
import org.example.repo.IRepository;

import java.util.List;

public class CompanyController {
    private IRepository<Company> companyIRepository;
    private int companyIdCounter;

    public CompanyController(IRepository<Company> companyIRepository) {

        this.companyIRepository = companyIRepository;
        this.companyIdCounter = companyIRepository.getObjects().size();
    }

    public boolean addCompany(String name, long capitalization){
        if(!this.searchCompanyBool(name)) {
            companyIRepository.save(new Company(companyIdCounter++, name, capitalization));
            return true;
        }
        return false;
    }

    public boolean removeCompany(String name){
        Company search = this.searchCompany(name);
        if(search != null) {
            companyIRepository.delete(search);
            return true;
        }
        else{
            return false;
        }
    }

    public List<Company> getAll(){
        return companyIRepository.getObjects();
    }

    public boolean searchCompanyBool(String name){
        List<Company> companies = companyIRepository.getObjects();
        for (Company company: companies) {
            if(company.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public Company searchCompany(String name){
        List<Company> companies = companyIRepository.getObjects();
        for (Company company: companies) {
            if(company.getName().equals(name)){
                return company;
            }
        }
        return null;
    }
}
