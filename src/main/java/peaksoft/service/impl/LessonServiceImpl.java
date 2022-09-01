package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Lesson;
import peaksoft.repository.CourseDao;
import peaksoft.repository.LessonDao;
import peaksoft.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonDao lessonDao;

    @Autowired
    public LessonServiceImpl(LessonDao lessonDao) {

        this.lessonDao = lessonDao;
    }

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return lessonDao.getAllLessons(id);
    }

    @Override
    public Lesson addLesson(Long id, Lesson lesson) {
        return lessonDao.addLesson(id, lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        return lessonDao.updateLesson(id, lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonDao.deleteLesson(id);
    }
}
