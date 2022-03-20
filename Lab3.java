import java.util.ArrayList;
import java.util.Collections;

public class Lab3 {
    public static void main(String[] args) {
        final int C3 = 1314 % 3;   // 0 => StringBuilder
        final int C17 = 1314 & 17;   // 5 => Слова без повторень в алфавітному порядку за першою літерою.

        //Вхідний текст
        StringBuilder text = new StringBuilder(("Всім привіт! Мене звати Рома.      \n Я з групи ІО-13, ФІОТ. " +
                "Ц1і2к3а4в5е6 с7л8о9в0о").trim().toLowerCase());

        //Створюємо список спеціальних символів, які не потрібно виводити у кінці і видаляємо їх з тексту
        char[] exeptions = {'!', '.', ',', ',', '"', '\'', '?', ':', ';', '-', '_', '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '/', '\\', '\n', '%'};
        int i, j;
        for(i=0; i<text.length(); i++){
            for (j = 0; j < exeptions.length; j++){
                if(text.charAt(i) == exeptions[j]){
                    text.deleteCharAt(i);
                }
            }
        }
        //Додаємо в кінець пробіл задля того, щоб наступна система спрацювала
        text.append(" ");
        //Створюємо ArrayList та наповнюємо його словами
        int start = 0, end;
        ArrayList<String> strArr = new ArrayList<>();
        for(i=0; i<text.length(); i++){
            if (text.charAt(i) == ' '){
                end = i;
                strArr.add(text.substring(start, end));
                start = i+1;
            }
        }
        //Видаляємо пусті елементи масиву
        for (i = 0; i<strArr.size(); i++){
            System.out.println(strArr.get(i));
            strArr.set(i, strArr.get(i).trim());
            if ("".equals(strArr.get(i))){
                strArr.remove(i);
                i--;
            }
            System.out.println(strArr.get(i));
        }
        // Сортуємо слова за алфавітом
        Collections.sort(strArr);
        //Виводимо результат
        for (i = 0; i<strArr.size(); i++){
            System.out.print(strArr.get(i) + " ");
        }
    }
}
