package peaksoft.repository;

import peaksoft.model.Video;

import java.util.List;

public interface VideoDao {
    List<Video> getAllVideos();

    void addVideo(Long taskId,Video video);

    Video getVideoById(Long id);

    void updateVideo(Long id,Video video);

    void deleteVideo(Video video);
}
