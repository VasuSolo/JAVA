
import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine().trim();
        String keyword = sc.nextLine();

        String[] words = sentence.split("\\s+");

        StringBuilder formatted = new StringBuilder();
        StringBuilder acronym = new StringBuilder();

        String longest = "";
        int count = 0;
        int keywordCount = 0;

        for (String word : words) {
            String titleWord = word.substring(0, 1).toUpperCase()
                    + word.substring(1).toLowerCase();

            if (formatted.length() > 0) {
                formatted.append(" ");
            }

            formatted.append(titleWord);
            acronym.append(Character.toUpperCase(word.charAt(0)));

            count++;

            if (word.length() > longest.length()) {
                longest = titleWord;
            }

            if (word.equalsIgnoreCase(keyword)) {
                keywordCount++;
            }
        }

        System.out.println("Formatted: " + formatted);
        System.out.println("Words: " + count);
        System.out.println("Longest word: " + longest);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Acronym: " + acronym);

        sc.close();
    }
}
