import java.io.*;
import java.util.*;

public class Anagram {
  
  private static ArrayList<Character> target = new ArrayList<Character>();
  private static int wordCount;
  private static BufferedReader reader;
  private static ArrayList<String> anagramList = new ArrayList<String>();
  private static ArrayList<String> validAnagrams = new ArrayList<String>();
  
  public static void validAnagrams() {
    for (int i = 0; i < anagramList.size(); i++) {
      if (anagramList.get(i).length() < target.size()) {
        String temp = anagramList.get(i);
        int spaces = 0;
        for (int ii = 0; ii < anagramList.size(); ii++) {
          temp += " " + anagramList.get(ii);
          System.out.println(temp);
          if ((target.size() == temp.replace(" ", "").length()) && isAnagram(temp, target)) {
            
            validAnagrams.add(temp);
          }
        }
        
      } else {
        
      }
    }
  }
  
  public static void main(String [] args) {
    if(args.length == 2) {
      for (int i = 0; i < args[0].length(); i++){
        target.add(args[0].charAt(i));
      }
      wordCount = Integer.parseInt(args[1]);
    }
    else {
      System.out.println("Invalid number of arguments!");
    }
    
    try {
      System.out.println("Reading file");
      
      reader = new BufferedReader(new FileReader("dictionary.txt"));
      String line;
      while((line = reader.readLine()) != null) {
        if(isAnagram(line, target)) {
          anagramList.add(line);
          System.out.println(line);
        }
      }
      System.out.println("\n");
      validAnagrams();
    } 
    catch (FileNotFoundException e) {
      System.out.println("Could not find file!");    
    } 
    catch (IOException e) {
      // TODO Auto-generated catch block
      System.out.println("Could not process file!");
    }
  }
  
//  public static boolean isAnagram(String firstWord, String secondWord) {
//     char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
//     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
//     Arrays.sort(word1);
//     Arrays.sort(word2);
//     return Arrays.equals(word1, word2);
//  }

  public static boolean isAnagram(String word, ArrayList<Character> validLetters) {
    
    ArrayList<String> currentChars = new ArrayList<String>();
    char[] wordChars = word.toCharArray();
    
    for(char _char : wordChars)
      currentChars.add(String.valueOf(_char));
    
    int validLetterCount = 0;
    
    for(char _char : validLetters) {
      String value = String.valueOf(_char);
      
      if(currentChars.contains(value))
        validLetterCount++;
      
      currentChars.remove(value);
    }
    
    return validLetterCount == word.length();
  }
  
}