import java.util.ArrayList;

public class Main {
  
  public static void main(String[] args) {

    // Визначення варіанту
    final int C3 = 1310%3;   // 2 => String
    final int C13 = 1310%17;   // 1 => Вивести всі речення заданого тексту в порядку зростання кількості слів у них

    // Вхідні данні
    String text = "Lorem ipsum dolor sit amet,           consectetur adipiscing elit! In fermentum justo sit amet ultricies blandit? Nulla finibus nunc eu euismod pellentesque. Donec consectetur eros leo, sed consequat nisi commodo eget. Etiam at urna gravida, porta ipsum id, pretium mauris. Nam non commodo lorem. In sed nisi ac augue finibus eleifend. Ut vitae euismod nulla. Cras efficitur faucibus velit, ut pharetra velit lobortis ut. Donec quis tortor maximus ligula placerat convallis.";
    
    // Розбиваємо текст на масив речень, кожне речення є масивом слів
    String sentences[] = text.split("[.?!]");
    ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>(sentences.length);

    for (int i = 0; i < sentences.length; i++) {
      String sentenceWords[] = sentences[i].split("[, ]");
      ArrayList<String> filteredWords = new ArrayList<String>();

      for (int j = 0; j < sentenceWords.length; j++) {
        if (sentenceWords[j] != "") {
          filteredWords.add(sentenceWords[j].trim());
        }
      }

      words.add(filteredWords);
    } 

    // Сортуємо речення за кількістю слів
    for (int i = 0; i < words.size(); i++) {
      int minElementIndex = i;
      ArrayList<String> minElement = words.get(i);

      for (int j = i; j < words.size(); j++) {
        if (minElement.size() > words.get(j).size()) {
          minElement = words.get(j);
          minElementIndex = j;
        } 
      }

      ArrayList<String> save = words.get(i);
      words.set(i, minElement);
      words.set(minElementIndex, save);
    }

    // Виводимо результат
    System.out.println("\n");
    for (int i = 0; i < words.size(); i++) {
      String sentence = "";

      for (int j = 0; j < words.get(i).size(); j++) {
        sentence += words.get(i).get(j) + " ";
      }

      System.out.printf("(%s words) %s\n", String.valueOf(words.get(i).size()), sentence);
    }
    System.out.println("\n");
  }
}