class ScrabbleRunner {

    public static void main(String[] args) {
        Scrabble scrabble = new Scrabble("");
        System.out.println(scrabble.score());   // => 0

        scrabble = new Scrabble(null);
        System.out.println(scrabble.score());   // => 0

        scrabble = new Scrabble("a");
        System.out.println(scrabble.score()); // => 1

        scrabble = new Scrabble("f");
        System.out.println(scrabble.score()); // => 4

        scrabble = new Scrabble("street");
        System.out.println(scrabble.score()); // =>, 6

        scrabble = new Scrabble("quirky");
        System.out.println(scrabble.score()); // => 22

        scrabble = new Scrabble("OXYPHENBUTAZONE");
        System.out.println(scrabble.score()); // => 41
    }
}