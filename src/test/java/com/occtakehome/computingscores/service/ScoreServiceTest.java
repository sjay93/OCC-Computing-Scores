package com.occtakehome.computingscores.service;

import com.occtakehome.computingscores.serviceimpl.ScoreServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class ScoreServiceTest {

    @InjectMocks
    private ScoreServiceImpl scoreService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateTotalScoreTest() {
        String listOfNames = "\"MARIA\",\"LINDA\",\"SARAH\"";
        int totalScore = scoreService.calculateTotalScore(listOfNames);
        assertEquals(265, totalScore);
    }
}
