package peaksoft.repository;

import peaksoft.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourses(Long id);

    Course addCourse(Long id,Course course);

    Course getCourseById(Long id);

    void updateCourse(Long id,Course course);

    void deleteCourse(Long id);


}
