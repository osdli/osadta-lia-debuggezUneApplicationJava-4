package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
  FileWriter writer;

  public WriteSymptomDataToFile () {
		
	}

	public void writeSymptoms(Map<String, Integer> symptoms){
    try{    
        FileWriter writer = new FileWriter ("result.out");
          for (Map.Entry<String, Integer> entry : symptoms.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            writer.write(key + " : " + value + "\n");    
            }
        writer.close();
      } catch (Exception e) {
          System.out.println("Something went wrong.");
      }  
  }
     
}