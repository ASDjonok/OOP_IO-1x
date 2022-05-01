package laba3;

/*
    C3 = 0 (StringBuilder)
    C17 = 14 (В кожному слові заданого тексту, видалити всі наступні входження першої літери цього слова.)
 */

public class Lab3 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Цікаве словосполучення -віра в людину, адже прийнято вірити в Бога. " +
                "Ну, або у власні сили. А тут -вірити в іншого. " +
                "Як же в нього вірити, адже він просто людина? Ніхто ж не ідеальний. " +
                "До голови ж йому не залізеш, може, він щось там собі думає погане, " +
                "щось проти тебе замишляє.");

        text = new StringBuilder(text.toString().replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", ""));
        System.out.println("Текст без розділових знаків та пробілів:\n" + text);
        String[] splittext = text.toString().split(" ");

        for (String word : splittext) {
            System.out.println("до: " + word);
            char c = word.charAt(0);
            StringBuilder s = new StringBuilder(String.valueOf(c));
            String word1 = word.replace(s, "");
            StringBuilder word2 = new StringBuilder(word1);
            word2.insert(0, s);
            System.out.println("після: " + word2);
        }
    }
}