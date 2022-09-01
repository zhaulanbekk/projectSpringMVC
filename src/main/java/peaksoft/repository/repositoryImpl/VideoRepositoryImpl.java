package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Lesson;
import peaksoft.model.Video;
import peaksoft.repository.VideoDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class VideoRepositoryImpl implements VideoDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Video> getAllVideos(Long id) {
        return manager.createQuery("select v from Video v where v.lesson.id=:id",Video.class).setParameter("id",id).getResultList();
    }

    @Override
    public Video addVideo(Long id, Video video) {
        Lesson lesson = manager.find(Lesson.class, id);
        lesson.setVideo(video);
        video.setLesson(lesson);
        return manager.merge(video);
    }

    @Override
    public Video getVideoById(Long id) {
        return manager.find(Video.class,id);
    }

    @Override
    public void updateVideo(Long id, Video video) {
        Video video1 = manager.find(Video.class, id);
        video1.setVideoName(video.getVideoName());
        video1.setLink(video.getLink());
        manager.merge(video1);
    }

    @Override
    public void deleteVideo(Long id) {
        Video video = manager.find(Video.class, id);
        video.setLesson(null);
        manager.remove(video);
    }
}
