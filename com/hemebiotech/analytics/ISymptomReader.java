package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source.
 * 
 * <p>The important part is the return value from the operation, which is a list of strings
 * that may contain many duplications.
 * 
 * <p>The implementation does not need to order the list.
 */
public interface ISymptomReader {
  
  /**
   * If no data is available, return an empty List.
   * 
   * @return a raw listing of all Symptoms obtained from a data source
   */
  List<String> getSymptoms();
}

