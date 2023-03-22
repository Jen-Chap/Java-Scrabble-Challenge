import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Scrabble {
    protected String word;
    protected int score = 0;
    protected  Map<Character, Integer> letterScores = new HashMap<>(26);

    protected boolean doubleWord;
    protected boolean tripleWord;

    protected String doubleLetter = "";
    protected String tripleLetter = "";
    protected boolean doubleLetterChecked = false;
    protected boolean tripleLetterChecked = false;

    public Scrabble(String word){
        this.word = word;
    }

    public Scrabble(String word, Character[] doubleLetter, Character[] tripleLetter, boolean doubleWord, boolean tripleWord){
        this.word = word;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        this.doubleLetter = Arrays.toString(doubleLetter).substring(1,2);
        this.tripleLetter = Arrays.toString(tripleLetter).substring(1,2);
    }

    public int score(){
        assignScores();
        if (word != null){
            word = word.toLowerCase();
            addToScore();
        }return doubleOrTripleWord();
    }
    public void addToScore(){
        for (int i =0; i< word.length(); i++){
            if ((doubleLetter.equalsIgnoreCase(String.valueOf(word.charAt(i)))) && (!doubleLetterChecked)){
                doubleLetterChecker(i);
            } else if ((tripleLetter.equalsIgnoreCase(String.valueOf(word.charAt(i)))) && (!tripleLetterChecked)){
                tripleLetterChecker(i);
            }else{score += (letterScores.get(word.charAt(i)));}
        }
    }

    public void doubleLetterChecker(int i){
        score += ((letterScores.get(word.charAt(i))*2));
        doubleLetterChecked = true;
    }
    public void tripleLetterChecker(int i){
        score += ((letterScores.get(word.charAt(i))*3));
        tripleLetterChecked = true;
    }
    public int doubleOrTripleWord(){
        if (doubleWord){return (score*2);
        } else if (tripleWord) {return (score*3);
        } else {return score;}
    }
    public void assignScores(){
        letterScores.put('a', 1);
        letterScores.put('e', 1);
        letterScores.put('i', 1);
        letterScores.put('o', 1);
        letterScores.put('u', 1);
        letterScores.put('l', 1);
        letterScores.put('n', 1);
        letterScores.put('r', 1);
        letterScores.put('s', 1);
        letterScores.put('t', 1);
        letterScores.put('d', 2);
        letterScores.put('g', 2);
        letterScores.put('b', 3);
        letterScores.put('c', 3);
        letterScores.put('m', 3);
        letterScores.put('p', 3);
        letterScores.put('f', 4);
        letterScores.put('h', 4);
        letterScores.put('v', 4);
        letterScores.put('w', 4);
        letterScores.put('y', 4);
        letterScores.put('k', 5);
        letterScores.put('j', 8);
        letterScores.put('x', 8);
        letterScores.put('q', 10);
        letterScores.put('z', 10);
    }

}
