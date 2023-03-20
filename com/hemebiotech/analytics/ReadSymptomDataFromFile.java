package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads a list of symptoms from a file, with one symptom per line.
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

  private String filepath;

  /**
  * Constructs a ReadSymptomDataFromFile object with the specified file path.
  *
  * @param filepath the full or partial path to the file with symptom strings in it, one per line
  */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  /**
   * Returns a list of symptoms read from the file.
   *
   * @return a list of symptoms
   */
  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<String>();

    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();

        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return result;
  }

}
