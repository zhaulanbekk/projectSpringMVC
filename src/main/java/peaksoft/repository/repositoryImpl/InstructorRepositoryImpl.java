package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.repository.InstructorDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class InstructorRepositoryImpl implements InstructorDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Instructor> getAllInstructors(Long id) {
        return manager.createQuery("SELECT i FROM Instructor i where i.company.id=:id", Instructor.class).setParameter("id", id).getResultList();
    }

    @Override
    public Instructor addInstructor(Long id, Instructor instructor) {
        Company company = manager.find(Company.class,id);
        company.addInst(instructor);
        instructor.setCompany(company);
        return manager.merge(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return manager.find(Instructor.class,id);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        Instructor newInstructor  = getInstructorById(id);
        newInstructor.setFirstName(instructor.getFirstName());
        newInstructor.setLastName(instructor.getLastName());
        newInstructor.setPhoneNumber(instructor.getPhoneNumber());
        newInstructor.setEmail(instructor.getEmail());
        newInstructor.setSpecialization(instructor.getSpecialization());
   return manager.merge(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        manager.remove(manager.find(Instructor.class,id));
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        Instructor instructor = manager.find(Instructor.class, instructorId);
        Course course = manager.find(Course.class, courseId);
        instructor.addCourse(course);
        course.addInst(instructor);
        manager.merge(instructor);
    }
}
