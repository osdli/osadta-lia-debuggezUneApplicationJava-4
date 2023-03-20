package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Writes symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
  FileWriter writer;

  public WriteSymptomDataToFile() {

  }

  /**
    * Write the symptoms to a file.
    *
    * @param symptoms The map containing the symptoms and their count.
  */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      FileWriter writer = new FileWriter("result.out");
      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        String key = entry.getKey();
        Integer value = entry.getValue();
        writer.write(key + " : " + value + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Something went wrong.");
    }
  }

}


