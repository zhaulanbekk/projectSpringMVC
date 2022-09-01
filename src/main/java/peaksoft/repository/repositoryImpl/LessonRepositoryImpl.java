package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.repository.LessonDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LessonRepositoryImpl implements LessonDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Lesson> getAllLessons(Long id) {
        return manager.createQuery("SELECT l FROM Lesson l where l.course.id=:id", Lesson.class).setParameter("id", id).getResultList();

    }

    @Override
    public Lesson addLesson(Long id, Lesson lesson) {
        Course course = manager.find(Course.class, id);
        course.addLesson(lesson);
        lesson.setCourse(course);
        return manager.merge(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return manager.find(Lesson.class, id);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        Lesson lesson1 = getLessonById(id);
        lesson1.setLessonName(lesson.getLessonName());
        return manager.merge(lesson1);
    }

    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = manager.find(Lesson.class, id);
        lesson.setCourse(null);
        manager.remove(lesson);
    }
}
