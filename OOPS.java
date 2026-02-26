import java.util.HashMap;
import java.util.Map;

/**
 * BannerAppUC8.java
 *
 * UC8 - Use Map for Character Patterns and Render via Function
 *
 * Compile: javac BannerAppUC8.java
 * Run:     java BannerAppUC8
 */
public class OOPS {

    /**
     * Build and return a HashMap of character -> 7-line pattern.
     */
    public static Map<Character, String[]> buildPatternMap() {
        Map<Character, String[]> map = new HashMap<>();

        String[] oPattern = new String[] {
            " ***** ",
            "*     *",
            "*     *",
            "*     *",
            "*     *",
            "*     *",
            " ***** "
        };

        String[] pPattern = new String[] {
            "****** ",
            "*     *",
            "*     *",
            "****** ",
            "*      ",
            "*      ",
            "*      "
        };

        String[] sPattern = new String[] {
            " ***** ",
            "*      ",
            "*      ",
            " ***** ",
            "      *",
            "      *",
            " ***** "
        };

        map.put('O', oPattern);
        map.put('P', pPattern);
        map.put('S', sPattern);

        return map;
    }

    /**
     * Display the message in banner form using the provided pattern map.
     *
     * @param message the message to render (e.g., "OOPS")
     * @param map     mapping from Character -> 7-line pattern
     */
    public static void displayBanner(String message, Map<Character, String[]> map) {
        message = message.toUpperCase();
        for (int row = 0; row < 7; row++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                String[] pat = map.get(ch);
                if (pat == null) {
                    // fallback: blank 7-char space if pattern not present
                    sb.append("       ");
                } else {
                    sb.append(pat[row]);
                }
                if (i < message.length() - 1) sb.append("  "); // spacing
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Map<Character, String[]> patternMap = buildPatternMap();
        displayBanner("OOPS", patternMap);
    }
}
