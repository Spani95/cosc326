import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//import org.apache.commons.lang.StringUtils;


public class AnagramProgram {
  
  private static ArrayList<String> anagramList = new ArrayList<String>();
  private static ArrayList<Character> validLetters;
  private static int wordCount;
  /**
   * @param args
   */
  public static void main(String[] args) {
    wordCount = 2;
    if(args.length == 2) {
      
      AnagramProgram.findAnagrams(args[0], new File(args[1]));
    }
    else {
      
      System.out.println("Invalid number of arguments!");
    }
  }
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
  
  public static void findAnagrams(String word, File wordsFile) {
    
    try {
      System.out.println("Reading file");
      
      BufferedReader reader = new BufferedReader(new FileReader(wordsFile));
      for(int i = 0; i < word.length(); i++) {
        validLetters.add(word.charAt(i));
      }
      
      System.out.println("Searching anagrams");
      
      String line;
      while((line = reader.readLine()) != null) {
        if(isAnagram(line, validLetters)) {
          System.out.println("Anagram found: " + line);
          anagramList.add(line);
        }
        sortAnagrams();
      }
    } 
    catch (FileNotFoundException e) {
      System.out.println("Could not find file!");    
    } 
    catch (IOException e) {
      // TODO Auto-generated catch block
      System.out.println("Could not process file!");
    }
  }
  
  public static void sortAnagrams() {
//   String str = "";
//   int spaceCount = 0;
//   for (int i = 0; i < anagramList.size(); i++) {
//     if ((str.length() - spaceCount) == validLetters.length && isAnagram(str, validLetters)) {
//       
//     }
//     if (str.length() + anagramList.get(i).length() < validLetters.length) {
//       String hold = anagramList.get(i);
//       if (str.length() > 0) {
//         str += " " + hold;
//       } else {
//         str += hold;
//       }
//       spaceCount++;
//     }
//   }
//   System.out.println("Anagram found: " + str);
    
  }
  
}