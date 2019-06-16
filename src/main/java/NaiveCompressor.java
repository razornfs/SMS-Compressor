import java.util.ArrayList;
import java.util.List;

public class NaiveCompressor implements Compressor {
    public String compress(String text) {
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                words[i] = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            }
        }
        return String.join("", words);
    }

    public String decompress(String text) {
        char[] chars = text.toCharArray();
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        for (char c : chars) {
            if (Character.isUpperCase(c) && currentWord.length() > 0) {
                words.add(currentWord.toString());
                currentWord = new StringBuilder();
            }
            currentWord.append(c);
        }
        words.add(currentWord.toString());
        return String.join(" ", words);
    }
}
