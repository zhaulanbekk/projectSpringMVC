package peaksoft.repository;

import peaksoft.model.Lesson;

import java.util.List;

public interface LessonDao {
    List<Lesson> getAllLessons();

    void addLesson(Lesson lesson);

    Lesson getLessonById(Long id);

    void updateLesson(Long id,Lesson lesson);

    void deleteLesson(Lesson lesson);
}
