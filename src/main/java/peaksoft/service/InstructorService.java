package peaksoft.service;

import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Long id);

    Instructor addInstructor(Long id,Instructor instructor);

    Instructor getInstructorById(Long id);

    Instructor updateInstructor(Long id,Instructor instructor);

    void deleteInstructor(Long id);

    void assignInstructorToCourse( Long instructorId,Long courseId);
}
