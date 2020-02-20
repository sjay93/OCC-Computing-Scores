package com.occtakehome.computingscores.controller;

import com.occtakehome.computingscores.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jay Shah
 */
@Controller
public class ScoreController {

    private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Autowired
    private ScoreService scoreService;

    /**
     * This method gets the content from the file passed as a command line argument
     *
     * @return The total score for all the names in the list
     */
    @ResponseBody
    public int computeScores(String listOfNames) {
        logger.info("ScoreController's computeScores() method called");
        int totalScore = scoreService.calculateTotalScore(listOfNames);
        logger.info("ScoreController's computeScores() method ended");
        return totalScore;
    }
}
