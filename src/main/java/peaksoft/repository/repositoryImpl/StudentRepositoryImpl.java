package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Student;
import peaksoft.repository.StudentDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Student> getAllStudents(Long id) {
        return manager.createQuery("SELECT i FROM Student i where i.company.id=:id", Student.class).setParameter("id", id).getResultList();
    }

    @Override
    public void addStudent(Long id, Student student) {
        Company company = manager.find(Company.class, id);
        company.addStudent(student);
        student.setCompany(company);
        manager.merge(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return manager.find(Student.class, id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        manager.merge(student);
    }

    @Override
    public void deleteStudent(Long id) {
        manager.remove(manager.find(Student.class, id));
    }

    @Override
    public void assignCourse(Long courseId, Student student) {
    }
}
