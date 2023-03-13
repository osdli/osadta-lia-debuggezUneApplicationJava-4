package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();

        
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);
       
         // Get the list of symptoms from the symptom reader
        List<String> symptoms = analyticsCounter.getSymptoms();

        // Count the occurrences of each symptom
        Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);

        // Sort the symptoms alphabetically
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);

        // Write the sorted symptoms to a file using the symptom writer
        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}
