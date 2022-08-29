package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Company;

import java.util.List;
@Service
public interface CompanyService {
    List<Company> getAllCompany();

    void addCompany(Company company);

    Company getCompanyById(Long id);

    void updateCompany(Long id,Company company);

    void deleteCompany(Long id);
}
