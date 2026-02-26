/**
 * BannerAppUC7.java
 *
 * UC7 - Store Character Pattern in a Class (using inner static class)
 *
 * Compile: javac BannerAppUC7.java
 * Run:     java BannerAppUC7
 */
public class OOPS {

    /**
     * Inner static class to encapsulate a character and its 7-line banner pattern.
     */
    public static class CharacterPatternMap {
        private final char character;
        private final String[] pattern; // 7-line ASCII art pattern

        /**
         * Constructor
         *
         * @param character the character this pattern represents
         * @param pattern   7-line string array representing the banner
         */
        public CharacterPatternMap(char character, String[] pattern) {
            if (pattern == null || pattern.length != 7) {
                throw new IllegalArgumentException("Pattern must be a 7-line array.");
            }
            this.character = character;
            this.pattern = pattern.clone();
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern.clone();
        }
    }

    /**
     * Initialize an array of CharacterPatternMap objects (linear container).
     * In UC7 we simulate the manual creation and linear search retrieval.
     */
    private static CharacterPatternMap[] initCharacterPatternArray() {
        CharacterPatternMap[] arr = new CharacterPatternMap[3];

        // 'O' pattern (7 lines, fixed width)
        String[] oPattern = new String[] {
            " ***** ",
            "*     *",
            "*     *",
            "*     *",
            "*     *",
            "*     *",
            " ***** "
        };

        // 'P' pattern
        String[] pPattern = new String[] {
            "****** ",
            "*     *",
            "*     *",
            "****** ",
            "*      ",
            "*      ",
            "*      "
        };

        // 'S' pattern
        String[] sPattern = new String[] {
            " ***** ",
            "*      ",
            "*      ",
            " ***** ",
            "      *",
            "      *",
            " ***** "
        };

        arr[0] = new CharacterPatternMap('O', oPattern);
        arr[1] = new CharacterPatternMap('P', pPattern);
        arr[2] = new CharacterPatternMap('S', sPattern);

        return arr;
    }

    /**
     * Linear search to retrieve pattern for a given character from the array.
     *
     * @param arr array of CharacterPatternMap
     * @param ch  character to find
     * @return 7-line pattern or a blank 7-line pattern if not found
     */
    private static String[] lookupPattern(CharacterPatternMap[] arr, char ch) {
        for (CharacterPatternMap entry : arr) {
            if (entry.getCharacter() == ch) {
                return entry.getPattern();
            }
        }
        // return blank 7-line pattern if not found
        String[] blank = new String[7];
        for (int i = 0; i < 7; i++) blank[i] = "       ";
        return blank;
    }

    /**
     * Display the banner for a message (like "OOPS") using the array and linear lookup.
     *
     * @param message string message to display in banner
     * @param arr     array of CharacterPatternMap
     */
    private static void displayBanner(String message, CharacterPatternMap[] arr) {
        message = message.toUpperCase();
        // For each of the 7 rows
        for (int row = 0; row < 7; row++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                String[] pat = lookupPattern(arr, ch);
                sb.append(pat[row]);
                if (i < message.length() - 1) sb.append("  "); // spacing between letters
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] patterns = initCharacterPatternArray();
        displayBanner("OOPS", patterns);
    }
}
