package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.repository.CompanyDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CompanyRepositoryImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Company> getAllCompany() {
        return manager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public void addCompany(Company company) {
        manager.persist(company);
    }

    @Override
    @Transactional
    public Company getCompanyById(Long id) {
        return manager.find(Company.class,id);
    }

    @Override
    public void updateCompany(Long id,Company company) {
        Company newCompany = getCompanyById(id);
        newCompany.setCompanyName(company.getCompanyName());
        newCompany.setLocatedCountry(company.getLocatedCountry());
        manager.merge(newCompany);
    }

    @Override
    @Transactional
    public void deleteCompany(Long id) {
    manager.remove(getCompanyById(id));
    }
}
