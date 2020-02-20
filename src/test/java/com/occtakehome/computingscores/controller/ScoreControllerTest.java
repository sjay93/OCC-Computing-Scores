package com.occtakehome.computingscores.controller;

import com.occtakehome.computingscores.service.ScoreService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class ScoreControllerTest {

    @Mock
    private ScoreService scoreService;

    @InjectMocks
    private ScoreController scoreController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void computeScoresTest() {

        String listOfNames = "\"MARIA\",\"LINDA\",\"SARAH\"";
        Mockito.when(scoreService.calculateTotalScore(listOfNames)).thenReturn(265);

        int totalScore = scoreController.computeScores(listOfNames);
        assertEquals(265, totalScore);
    }
}
