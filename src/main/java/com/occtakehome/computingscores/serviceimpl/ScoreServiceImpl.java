package com.occtakehome.computingscores.serviceimpl;

import com.occtakehome.computingscores.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jay Shah
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    /**
     * The method converts the list of names separated by a comma into an array of strings. For each of the element of
     * the array, it calculates the total score by adding the number of each character and then stores it in the treeMap.
     * Finally, traversing through the treeMap it multiplies each score with the position in treeMap and returns the sum
     *
     * @param listOfNames the list of names separated by a comma
     * @return The total score for all the names.
     */
    @Override
    public int calculateTotalScore(String listOfNames) {
        if (listOfNames == null)
            return 0;

        //Using TreeMap to alphabetically sort the names and store the sum of the names.
        Map<String, Integer> map = new TreeMap<>();

        int sumOfChars, position = 1, totalSum = 0;
        for (String name : listOfNames.split(",")) {
            //Initializing for every name in the list
            sumOfChars = 0;

            //Replacing all the characters other than alphabets by empty string.
            name = name.replaceAll("[^a-zA-Z]+", "");

            //If any name has any lowercase characters, then converting them to uppercase characters.
            for (char letter : name.toUpperCase().toCharArray()) {
                sumOfChars += (letter - 'A' + 1);
            }
            map.put(name, sumOfChars);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            totalSum = totalSum + (position++ * entry.getValue());
        }

        return totalSum;
    }
}
