
 

public class OOPSBannerApp {

    /**
     * CharacterPatternMap - Inner class for storing character-to-pattern mappings
     * Encapsulates a single character and its corresponding ASCII art pattern.
     */
    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;

        // Constructor
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        // Getters
        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Static Method to Create and initialize CharacterPatternMap array
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] charMaps = new CharacterPatternMap[4];

        charMaps[0] = new CharacterPatternMap('O', new String[]{
            "  *** ", " * * ", " * * ", " * * ", "  *** "
        });
        charMaps[1] = new CharacterPatternMap('P', new String[]{
            " ***** ", " * * ", " ***** ", " * ", " * "
        });
        charMaps[2] = new CharacterPatternMap('S', new String[]{
            "  **** ", " * ", "  *** ", "     * ", " **** "
        });
        charMaps[3] = new CharacterPatternMap(' ', new String[]{
            "       ", "       ", "       ", "       ", "       "
        });

        return charMaps;
    }

    /**
     * Retrieves the ASCII pattern for a given character from the map array
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        // Return space pattern if character not found
        return charMaps[3].getPattern(); 
    }

    /**
     * Prints a message as a banner by assembling character patterns line by line
     */
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        int height = 5; // Height of our ASCII letters
        for (int i = 0; i < height; i++) {
            StringBuilder line = new StringBuilder();
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(Character.toUpperCase(ch), charMaps);
                line.append(pattern[i]).append("  ");
            }
            System.out.println(line.toString());
        }
    }

    public static void main(String[] args) {
        // Initialize the character mappings
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        
        // Define the message to be displayed
        String message = "OOPS";
        
        // Print the banner message
        printMessage(message, charMaps);
    }
}