package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Video;
import peaksoft.repository.VideoDao;
import peaksoft.service.VideoService;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoDao videoDao;

    @Autowired
    public VideoServiceImpl(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public List<Video> getAllVideos(Long id) {
        return videoDao.getAllVideos(id);
    }

    @Override
    public Video addVideo(Long id, Video video) {
        return videoDao.addVideo(id,video);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoDao.getVideoById(id);
    }

    @Override
    public void updateVideo(Long id, Video video) {
        videoDao.updateVideo(id, video);
    }

    @Override
    public void deleteVideo(Long id) {
        videoDao.deleteVideo(id);
    }
}
