package peaksoft.repository;

import peaksoft.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();

    void addStudent(Student student);

    Student getStudentById(Long id);

    void updateStudent(Long id,Student student);

    void deleteStudent(Student student);

    void addCourse(Long courseId,Student student);


}
