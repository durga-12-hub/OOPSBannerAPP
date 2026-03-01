public class OOPSBannerApp {

    // Inner Class
    static class CharacterPatternMap {

        private char character;
        private String[] pattern;

        // Constructor
        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        // Getter for character
        public char getCharacter() {
            return character;
        }

        // Getter for pattern
        public String[] getPattern() {
            return pattern;
        }
    }

    // Create CharacterPatternMap Array
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        return new CharacterPatternMap[] {

            new CharacterPatternMap('O', new String[]{
                    " ***** ",
                    "*     *",
                    "*     *",
                    "*     *",
                    "*     *",
                    "*     *",
                    " ***** "
            }),

            new CharacterPatternMap('P', new String[]{
                    " ***** ",
                    "*     *",
                    "*     *",
                    " ***** ",
                    "*      ",
                    "*      ",
                    "*      "
            }),

            new CharacterPatternMap('S', new String[]{
                    " ***** ",
                    "*      ",
                    "*      ",
                    " ***** ",
                    "      *",
                    "      *",
                    " ***** "
            }),

            new CharacterPatternMap(' ', new String[]{
                    "       ",
                    "       ",
                    "       ",
                    "       ",
                    "       ",
                    "       ",
                    "       "
            })
        };
    }

    // Get pattern for character
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {

        for (CharacterPatternMap map : maps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return new String[7];
    }

    // Print Banner
    public static void printMessage(String message, CharacterPatternMap[] maps) {

        for (int row = 0; row < 7; row++) {

            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                String[] pattern = getCharacterPattern(ch, maps);
                System.out.print(pattern[row] + "  ");
            }

            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {

        CharacterPatternMap[] maps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, maps);
    }
}