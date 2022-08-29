package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.CompanyDao;
import peaksoft.service.CompanyService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDao.getAllCompany();
    }

    @Override
    public void addCompany(Company company) {
    companyDao.addCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
       return companyDao.getCompanyById(id);
    }

    @Override
    public void updateCompany(Long id, Company company) {
    companyDao.updateCompany(id,company);
    }

    @Override
    @Transactional
    public void deleteCompany(Long id) {
        companyDao.deleteCompany(id);
    }
}
