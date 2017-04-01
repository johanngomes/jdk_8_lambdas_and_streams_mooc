/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 1 homework
 */
package lessons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Speakjava (Simon Ritter)
 */
class Lesson1 {
  /**
   * Run the exercises to ensure we got the right answers
   */
  public void runExercises() {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
  }

  /**
   * All exercises should be completed using Lambda expressions and the new
   * methods added to JDK 8 where appropriate. There is no need to use an
   * explicit loop in any of the code. Use method references rather than full
   * lambda expressions wherever possible.
   */
  /**
   * Exercise 1
   *
   * Create a string that consists of the first letter of each word in the list
   * of Strings provided.
   */
  private void exercise1() {
      List<String> list = Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

      StringBuilder stringBuilder = new StringBuilder();

      list.forEach(string -> stringBuilder.append(string.charAt(0)));
      String result = stringBuilder.toString();

      System.out.println("Exercise 1 result = " + result);;
  }

  /**
   * Exercise 2
   *
   * Remove the words that have odd lengths from the list.
   */
  private void exercise2() {
      List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

      List<String> listWithoutWordsWithOddLength =
              list.stream().filter(word -> word.length() % 2 != 0).collect(Collectors.toList());

      System.out.println("Exercise 2 result = " + listWithoutWordsWithOddLength);
  }

  /**
   * Exercise 3
   *
   * Replace every word in the list with its upper case equivalent.
   */
  private void exercise3() {
      List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

      List<String> listWithUpperCaseWords =
            list.stream().map(String::toUpperCase).collect(Collectors.toList());

      System.out.println("Exercise 3 result = " + listWithUpperCaseWords);
  }

  /**
   * Exercise 4
   *
   * Convert every key-value pair of the map into a string and append them all
   * into a single string, in iteration order.
   */
  private void exercise4() {
      Map<String, Integer> map = new TreeMap<>();
      map.put("c", 3);
      map.put("b", 2);
      map.put("a", 1);

      StringBuilder stringBuilder = new StringBuilder();

      List<String> listWithKeyPlusValueStrings =
              map.entrySet().stream()
                      .map(this::buildStringWithKeyPlusValue)
                      .collect(Collectors.toList());

      listWithKeyPlusValueStrings.forEach(stringBuilder::append);

      System.out.println("Exercice 4 result = " + stringBuilder);
  }

    private String buildStringWithKeyPlusValue(Map.Entry<String, Integer> stringWithKeyPlusValue) {
        return stringWithKeyPlusValue.getKey() + stringWithKeyPlusValue.getValue();
    }

    /**
   * Exercise 5
   *
   * Return the sum of all numbers in the list.
   */
  private void exercise5() {
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

      Integer maxNumber = list.stream().mapToInt(Integer::intValue).max().getAsInt();

      System.out.println("Exercise 5 result = " + maxNumber);
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Lesson1 lesson = new Lesson1();
    lesson.runExercises();
  }
}
