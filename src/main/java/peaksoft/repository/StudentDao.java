package peaksoft.repository;

import peaksoft.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents(Long id);

    void addStudent(Long id,Student student);

    Student getStudentById(Long id);

    void updateStudent(Long id,Student student);

    void deleteStudent(Long id);

    void assignCourse(Long courseId, Student student);


}
