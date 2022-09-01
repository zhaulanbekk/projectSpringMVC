package peaksoft.service;

import peaksoft.model.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAllVideos(Long id);

    Video addVideo(Long id, Video video);

    Video getVideoById(Long id);

    void updateVideo(Long id,Video video);

    void deleteVideo(Long id);
}
