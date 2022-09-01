package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Instructor;
import peaksoft.repository.InstructorDao;
import peaksoft.service.InstructorService;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao;

    @Autowired
    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public List<Instructor> getAllInstructors(Long id) {
        return instructorDao.getAllInstructors(id);
    }

    @Override
    public Instructor addInstructor(Long id, Instructor instructor) {
      return   instructorDao.addInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        return instructorDao.updateInstructor(id, instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorDao.deleteInstructor(id);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
    instructorDao.assignInstructorToCourse(instructorId,courseId);
    }
}
