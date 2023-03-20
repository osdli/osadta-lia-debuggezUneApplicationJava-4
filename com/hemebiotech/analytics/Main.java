package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Main {
  /**
  * This is the main method that reads a list of symptoms,counts occurrences of each symptom,
  * sorts the symptoms alphabetically and writes the sorted symptoms to a file.
  * @param args An array of String objects representing any command line arguments passed to app.
  * @throws Exception If any errors occur while processing the symptoms.
  */
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
