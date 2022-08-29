package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;

import java.util.List;

@Repository
public interface CompanyDao {

    List<Company> getAllCompany();

    void addCompany(Company company);

    Company getCompanyById(Long id);

    void updateCompany(Long id,Company company);

    void deleteCompany(Long id);
}
