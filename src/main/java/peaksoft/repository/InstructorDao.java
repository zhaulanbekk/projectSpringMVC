package peaksoft.repository;

import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorDao {

    List<Instructor> getAllInstructors();

    void addInstructor(Instructor instructor);

    Instructor getInstructorById(Long id);

    void updateInstructor(Long id,Instructor instructor);

    void deleteInstructor(Instructor instructor);

    void assignInstructorToCourse(Long courseId, Long instructorId);
}
