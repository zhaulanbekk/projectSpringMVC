package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.repository.CourseDao;
import peaksoft.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses(Long id) {
        return courseDao.getAllCourses(id);
    }

    @Override
    public Course addCourse(Long id, Course course) {

        return courseDao.addCourse(id,course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseDao.updateCourse(id, course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDao.deleteCourse(id );
    }

    @Override
    public Course courseService(Course course) {
        Course newCourse = new Course();
        newCourse.setCourseName(course.getCourseName());
        newCourse.setDuration(course.getDuration());
        newCourse.setDateOfStart(course.getDateOfStart());
        newCourse.setDescription(course.getDescription());
        newCourse.setImage(course.getImage());
        return newCourse;
    }
}
