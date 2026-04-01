

public class OOPSBannerApp {

    static class CharacterPatternMap {
        private Character character;
        private String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() { return character; }
        public String[] getPattern() { return pattern; }
    }

    /**
     * Loads patterns from an external text file
     */
    public static List<CharacterPatternMap> loadPatternsFromFile(String filename) {
        List<CharacterPatternMap> charMaps = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    char character = parts[0].charAt(0);
                    String[] pattern = parts[1].split(",");
                    charMaps.add(new CharacterPatternMap(character, pattern));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading pattern file: " + e.getMessage());
        }
        return charMaps;
    }

    public static String[] getCharacterPattern(char ch, List<CharacterPatternMap> charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (Character.toUpperCase(map.getCharacter()) == Character.toUpperCase(ch)) {
                return map.getPattern();
            }
        }
        // Return blank spaces if not found
        return new String[]{"       ", "       ", "       ", "       ", "       "};
    }

    public static void printMessage(String message, List<CharacterPatternMap> charMaps) {
        for (int i = 0; i < 5; i++) { // Assuming pattern height is 5
            StringBuilder displayLine = new StringBuilder();
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                displayLine.append(pattern[i]).append("  ");
            }
            System.out.println(displayLine.toString());
        }
    }

    public static void main(String[] args) {
        // Load mappings from the external file
        List<CharacterPatternMap> charMaps = loadPatternsFromFile("banner_patterns.txt");

        if (charMaps.isEmpty()) {
            System.out.println("No patterns loaded. Check banner_patterns.txt");
            return;
        }

        String message = "OOPS";
        printMessage(message, charMaps);
    }
}