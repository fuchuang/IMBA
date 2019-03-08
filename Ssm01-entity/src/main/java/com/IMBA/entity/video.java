package com.IMBA.entity;

public class video extends videoKey {
    private String videoPath;

    private String videoTitle;
    private String video_screenshots_path;

    public String getVideo_screenshots_path() {
        return video_screenshots_path;
    }

    public void setVideo_screenshots_path(String video_screenshots_path) {
        this.video_screenshots_path = video_screenshots_path;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }
}