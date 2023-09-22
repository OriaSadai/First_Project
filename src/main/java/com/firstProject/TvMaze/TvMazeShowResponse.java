package com.firstProject.TvMaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvMazeShowResponse {
    @JsonProperty(value = "id")
    private Long tvMazeId;
    @JsonProperty(value = "url")
    private String tvMazeUrl;
    @JsonProperty(value = "name")
    private String tvMazeName;
    public TvMazeShowResponse(){}
    public TvMazeShowResponse(Long tvMazeId, String tvMazeUrl, String tvMazeName) {
        this.tvMazeId = tvMazeId;
        this.tvMazeUrl = tvMazeUrl;
        this.tvMazeName = tvMazeName;
    }
    public Long getTvMazeId() {
        return tvMazeId;
    }
    public String getTvMazeUrl() {
        return tvMazeUrl;
    }
    public String getTvMazeName() {
        return tvMazeName;
    }
    public void setTvMazeId(Long tvMazeId) {
        this.tvMazeId = tvMazeId;
    }
    public void setTvMazeUrl(String tvMazeUrl) {
        this.tvMazeUrl = tvMazeUrl;
    }
    public void setTvMazeName(String tvMazeName) {
        this.tvMazeName = tvMazeName;
    }
}
