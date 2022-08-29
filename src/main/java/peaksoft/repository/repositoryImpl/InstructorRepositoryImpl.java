package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
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
    public List<Instructor> getAllInstructors() {
        return manager.createQuery("select i from Instructor i", Instructor.class).getResultList();
    }

    @Override
    public void addInstructor(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return manager.find(Instructor.class,id);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
    manager.merge(instructor);
    }

    @Override
    public void deleteInstructor(Instructor instructor) {
    manager.remove(manager.contains(instructor)? instructor: manager.merge(instructor));
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long instructorId) {

    }
}
