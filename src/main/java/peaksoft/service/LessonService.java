package peaksoft.service;

import peaksoft.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons(Long id);

    Lesson addLesson(Long id,Lesson lesson);

    Lesson getLessonById(Long id);

    Lesson updateLesson(Long id,Lesson lesson);

    void deleteLesson(Long id);
}
