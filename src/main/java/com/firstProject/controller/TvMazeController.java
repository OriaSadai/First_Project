package com.firstProject.controller;

import com.firstProject.TvMaze.TvMazeService;
import com.firstProject.TvMaze.TvMazeShowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tvMaze")
public class TvMazeController {
    @Autowired
    private TvMazeService tvMazeService;
    @GetMapping("/show")
    public TvMazeShowResponse getCustomerById(@RequestHeader(value = "show") Long tvShowId) {
        System.out.println("Sending API request for show " + tvShowId);
        return tvMazeService.getTvShowById(tvShowId);
    }

}
