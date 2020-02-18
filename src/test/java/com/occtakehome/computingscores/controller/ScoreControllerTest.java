package com.occtakehome.computingscores.controller;

import com.occtakehome.computingscores.service.ScoreService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ScoreControllerTest {

    @Mock
    private ScoreService scoreService;

    @InjectMocks
    private ScoreController scoreController;

    private String fileName;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        fileName = "demo.txt";
    }

    @Test
    public void computeScoresTest() {
        ByteArrayInputStream in = new ByteArrayInputStream(fileName.getBytes());
        System.setIn(in);

        String listOfNames = "\"MARIA\",\"LINDA\",\"SARAH\"";
        Mockito.when(scoreService.calculateTotalScore(listOfNames)).thenReturn(265);

        int totalScore = scoreController.computeScores();
        assertEquals(0, totalScore);
        System.setIn(System.in);
    }
}
