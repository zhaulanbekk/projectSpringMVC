package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.repository.CourseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CourseRepositoryImpl implements CourseDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Course> getAllCourses(Long id) {
        return manager.createQuery("SELECT c FROM Course c where c.company.id=:id", Course.class).setParameter("id", id).getResultList();
    }

    @Override
    public Course addCourse(Long id, Course course) {
        Company company = manager.find(Company.class, id);
        company.addCourse(course);
        course.setCompany(company);
        return manager.merge(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return manager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        manager.merge(course);
    }

    @Override
    public void deleteCourse(Long id) {
        manager.remove(manager.find(Course.class,id));
    }
}
