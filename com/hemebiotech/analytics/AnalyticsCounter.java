package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.ArrayList;

public class AnalyticsCounter {

    ISymptomReader readerInstance;
    ISymptomWriter writerInstance;

    
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
        this.readerInstance = reader;
        this.writerInstance = writer;
    }

    /**
     * Returns a list of symptoms read from the configured ISymptomReader.
     */
    public List<String> getSymptoms() { 
        return readerInstance.getSymptoms();
    }

    /**
     * Counts the occurrences of each symptom in the given list of symptoms.
     */
    public Map<String, Integer> countSymptoms (List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            if (symptomCounts.containsKey(symptom)) {
                symptomCounts.put(symptom, symptomCounts.get(symptom) + 1);
            } else {
                symptomCounts.put(symptom, 1);
            }
        }
        return symptomCounts;
    }

    /**
     * Sorts the given map of symptoms and their counts by the symptom names in alphabetical order.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
        return sortedSymptoms;
    }

    /**
     * Writes the given map of symptom names and their counts to the configured ISymptomWriter.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writerInstance.writeSymptoms(symptoms);
    }

    public static void main(String args[]) throws Exception {

    }
}
