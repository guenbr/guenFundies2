package student;

import edu.willamette.cs1.spellingbee.SpellingBeeGraphics;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class SpellingBee {
    private static final String ENGLISH_DICTIONARY = "res/EnglishWords.txt";

    private SpellingBeeGraphics sbg;

    public void run() {
        sbg = new SpellingBeeGraphics();
        sbg.addField("Puzzle", (s) -> puzzleAction(s));
        sbg.addButton("Solve", (s) -> solveAction());
    }


    public boolean isLetters(String s) {
        char[] placeHolderArray = s.toLowerCase().toCharArray();

        for (int i = 0; i < s.length() ; i++) {
            if (!Character.isLetter(placeHolderArray[i])) {
                return false;
            }
        }
        return true;
    }
    public boolean isLetterRepeated(String s) {
        HashSet<Character> placeHolderHashSet = new HashSet<>();
                for (int i = 0; i < 7; i++) {
                    placeHolderHashSet.add(s.charAt(i));
                }
        return s.length() == placeHolderHashSet.size();
            }

    private void puzzleAction(String s) {
//        sbg.showMessage("puzzleAction is not yet implemented", Color.RED);
        if(s.length() != 7) {
            sbg.showMessage("length of letters is not 7", Color.RED);
            return;
        }

        if (!isLetters(s)) {
            sbg.showMessage("There is a non letter present", Color.RED);
            return;
        }

        if (!isLetterRepeated(s)) {
            sbg.showMessage("There is a repeated letter", Color.RED);
            return;
        }
         sbg.setBeehiveLetters(s);

    }


    public Set<String> fileToHashSet(String filePath) {
        Set<String> wordsSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                wordsSet.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsSet;
    }
//
    //make sure that at least 2 helper methods are made for solveAction()


    private void solveAction(String word) {
//        sbg.showMessage("solveAction is not yet implemented", Color.RED);
    Set<String> words = fileToHashSet(ENGLISH_DICTIONARY);
    for (int i = 0; i < words.size();) {
        if (words.size() >= 4 && )
    }

    }

    public static void main(String[] args) {
        new SpellingBee().run();
    }
}
