package com.occtakehome.computingscores.controller;

import com.occtakehome.computingscores.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jay Shah
 */
@Controller
public class ScoreController {

    private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Autowired
    private ScoreService scoreService;

    @Value("${file.name}")
    private String fileName;

    /**
     * This method gets the content from the file passed as a command line argument
     *
     * @return The total score for all the names in the list
     */
    @RequestMapping("/computeScores")
    @ResponseBody
    public int computeScores() {

        logger.info("ScoreController's computeScores() method called");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        //since a single line of input will be given
        String listOfNames = null;
        if (scanner != null) {
            listOfNames = scanner.nextLine();
        }

        return scoreService.calculateTotalScore(listOfNames);
    }
}
