import java.util.Arrays;

public class Lab5 {
    // main майже не змінювався - лишень оновив створення масиву та тексти підписів
    public static void main(String[] args) {
        //Оновив створення масиву об'єктів
        Clothes[] taskArray = {
                new Clothes(new UserText("jacket"), new UserText("Moncler"), new UserText("grey"), 10.5, 25),
                new Clothes(new UserText("pants2"), new UserText("Calvin Klein"), new UserText("brown"), 12, 75),
                new Clothes(new UserText("jeans"), new UserText("Levi's"), new UserText("blue"), 16, 100),
                new Clothes(new UserText("shirt"), new UserText("Tommy Hilfiger"), new UserText("white"), 14, 150),
                new Clothes(new UserText("shorts"), new UserText("Nike"), new UserText("black"), 12.5, 50),
                new Clothes(new UserText("pants1"), new UserText("Calvin Klein"), new UserText("brown"), 12, 75),
                new Clothes(new UserText("jean2"), new UserText("Levi's"), new UserText("blue"), 16, 100),
                new Clothes(new UserText("pants3"), new UserText("Calvin Klein"), new UserText("brown"), 12, 75)
        };
        int len = taskArray.length;
        System.out.println(new UserText("-----Unsorted Array:-----").getStringData());
        int i;
        for(i = 0; i < len; i++){
            taskArray[i].showInfo();
        }
        double[]  sizes = new double[len];
        int[] quantities = new int[len];
        for (i = 0; i < len; i++){
            sizes[i] = taskArray[i].size;
            quantities[i] = taskArray[i].quantity;
        }
        Clothes[] sortedBySizes = new Clothes[len];
        Arrays.sort(sizes);
        int j = 0;
        while(j < len){
            for(i = 0; i < len; i++){
                if(j < len && sizes[j] == taskArray[i].size) {
                    sortedBySizes[j] = taskArray[i];
                    j++;
                }
            }
        }
        System.out.println(new UserText("-----Sorted Array(sizes />):-----").getStringData());
        for(i = 0; i < len; i++) {
            sortedBySizes[i].showInfo();
        }
        Clothes[] sortedByQuantities = new Clothes[len];
        Arrays.sort(quantities);
        j = len;
        while(j > 0){
            for (i = 0; i < len; i++){
                if(j > 0 && quantities[j-1] == taskArray[i].quantity){
                    sortedByQuantities[len-j] = taskArray[i];
                    j--;
                }
            }
        }
        System.out.println(new UserText("-----Sorted Array(quantities \\>):-----").getStringData());
        for(i = 0; i < len; i++){
            sortedByQuantities[i].showInfo();
        }
    }
}

//Clothes змінився у двох місцях. Де саме - вказав коментарями.
class Clothes {
    //Оновлено типи даних текстових змінних
    UserText maker;
    UserText color;
    UserText category;
    double size;
    int quantity;

    Clothes(UserText category, UserText maker, UserText color, double size, int quantity){
        this.category = category;
        this.maker = maker;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }
    void showInfo(){
        //Оновив вивід результату
        System.out.println(new UserSentence("There are").getStringData() + new UserWord(" ").getStringData() +
            quantity + new UserWord(" ").getStringData() + color.getStringData() + new UserWord(" ").getStringData() +
            category.getStringData() + new UserWord(" ").getStringData() + new UserText("by").getStringData() +
            new UserWord(" ").getStringData() + maker.getStringData() + new UserText(". Size: ").getStringData() +
            new UserWord(" ").getStringData() + size);
    }
}

/*
Новий код

У кожного класу є:
    data - змінна для збереження контенту
    getStringData - метод для отримання data у вигляді рядка String

Інші особливості описав у коментарях
*/

//Клас символів
class UserChar{
    char data;
    UserChar(char ch){
        this.data = ch;
    }
    String getStringData(){
        return Character.toString(this.data);
    }
}
//Клас розділових знаків
class UserPunctuation{
    char data;
    UserPunctuation(char ch){
        this.data = ch;
    }
    String getStringData(){
        return Character.toString(this.data);
    }
}
//Клас слів
class UserWord{
    char[] punctuation = {'!', '.', ',', ':', ';', '"', '`', '#'};    //Масив символів розділових знаків
    int type = 0;                                               //Змінна типу слова(розділовий знак - 1 чи символьне слово - 0
    UserPunctuation[] data1;
    UserChar[] data0;
    UserWord(String word){
        //Перевірка на те, чи це слово - знак пунктуаціі, чи слово з букв, збереженя результату, запис data
        if (word.length() == 1){
            //Сама перевірка
            for (char c : this.punctuation) {
                if (word.equals(Character.toString(c))) {
                    this.type = 1;
                    break;
                }
            }
            //Запис результату
            if (this.type == 1){
                this.data1 = new UserPunctuation[]{new UserPunctuation(word.charAt(0))};
            }
            else {
                this.data0 = new UserChar[]{new UserChar(word.charAt(0))};
            }
        }
        else {
            this.data0 = new UserChar[word.length()];
            for (int i = 0; i < word.length(); i++){
                this.data0[i] = new UserChar(word.charAt(i));
            }
        }
    }
    String getStringData(){
        // Залежно від типу слова - виводимо потрібне data
        String res = "";
        if (type == 0){
            for (UserChar userChar : data0) {
                res = res.concat(userChar.getStringData());
            }
        }
        else {
            res = data1[0].getStringData();
        }
        return res;
    }
    int getType(){
        return this.type;
    }
}
class UserSentence{
    char[] punctuation = {'!', '.', ',', ':', ';', '"', '`', '#'};  ////Масив символів розділових знаків
    UserWord[] data;
    UserSentence(String sentence){
        //Відділяємо розділові знаки від слів пробілом
        StringBuilder newSentence = new StringBuilder(sentence);
        for (int i = 0; i < newSentence.length(); i++){
            for (char c : this.punctuation) {
                if (newSentence.charAt(i) == c) {
                    newSentence.insert(i, (" ".concat(Character.toString(c))));
                    newSentence.deleteCharAt(i + 2);
                    i++;
                }
            }
        }
        //Сплітимо дані на масив та записуємо у data
        sentence = newSentence.toString();
        String[] sentenceArr = sentence.split(" ");
        this.data = new UserWord[sentenceArr.length];
        for (int i = 0; i < sentenceArr.length; i++){
            this.data[i] = new UserWord(sentenceArr[i]);
        }
    }
    String getStringData(){
        //Якщо збережено знак пунктуації - додаємо без пробілу, якщо слово - з пробілом
        String res = "";
        for (int i = 0; i < this.data.length; i++) {
            if (data[i].getType() == 1 || i == 0){
                res = res.concat(data[i].getStringData());
            }
            else {
                res = res.concat(" ").concat(data[i].getStringData());
            }
        }
        return res;
    }
}
class UserText{
    char[] punctuation = {'!', '.', '?'}; //Масив розділових знаків речень
    UserSentence[] data;
    UserText(String text){
        StringBuilder newText = new StringBuilder(text);
        //Вставляємо спеціальний символ-роздільник
        for (char pp : this.punctuation){
            for (int i = 0; i < newText.length(); i++){
                if (pp == newText.charAt(i) && (i+1)<newText.length() && pp != newText.charAt(i+1)) {
                    newText.insert((i+1), 'Ⓓ');
                    i++;
                }
            }
        }
        //Ділимо завдяки спецсимволу текст на речення та зберігаємо у data
        String[] textArr = newText.toString().split("Ⓓ");
        this.data = new UserSentence[textArr.length];
        for (int i = 0; i < textArr.length; i++){//Ⓓ
            this.data[i] = new UserSentence(textArr[i]);
        }
    }
    String getStringData(){
        String res = "";
        for (UserSentence datum : this.data) {
            res = res.concat(datum.getStringData());
        }
        return res;
    }
}