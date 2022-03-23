import java.util.Arrays;

public class Lab4 {
    public static void main(String[] args) {
        //C11 = 1314 % 11 = 5 => клас одяг, який складається з 5+ полів.

        //Створюємо масив об'єктів за завданням
        Clothes[] taskArray = {
                new Clothes("jacket", "Moncler", "grey", 10.5, 25),
                new Clothes("pants2", "Calvin Klein", "brown", 12, 75),
                new Clothes("jeans", "Levi's", "blue", 16, 100),
                new Clothes("shirt", "Tommy Hilfiger", "white", 14, 150),
                new Clothes("shorts", "Nike", "black", 12.5, 50),
                new Clothes("pants1", "Calvin Klein", "brown", 12, 75),
                new Clothes("jean2", "Levi's", "blue", 16, 100),
                new Clothes("pants3", "Calvin Klein", "brown", 12, 75)
        };
        int len = taskArray.length; //Допоміжна змінна

        //Виводимо вхідний масив
        System.out.println("-----Unsorted Array:-----");
        int i;
        for(i = 0; i < len; i++){
            taskArray[i].showInfo();
        }

        //Створюємо та наповнюємо масиви двох полів об'єктів(за завданням) та наповнюємо їх
        double[]  sizes = new double[len];
        int[] quantities = new int[len];
        for (i = 0; i < len; i++){
            sizes[i] = taskArray[i].size;
            quantities[i] = taskArray[i].quantity;
        }

        //Створюємо масив об'єктів, відсортованих за полем "size" за зростанням, наповнюємо його та виводимо.
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
        System.out.println("-----Sorted Array(sizes />):-----");
        for(i = 0; i < len; i++) {
            sortedBySizes[i].showInfo();
        }

        //Створюємо масив об'єктів, відсортованих за полем "quantity" за спаданням, наповнюємо його та виводимо.
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
        System.out.println("-----Sorted Array(quantities \\>):-----");
        for(i = 0; i < len; i++){
            sortedByQuantities[i].showInfo();
        }
    }
}

//Створюємо клас за завданням
class Clothes {
    String maker;
    String color;
    String category;
    double size;
    int quantity;

    Clothes(String category, String maker, String color, double size, int quantity){
        this.category = category;
        this.maker = maker;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }
    void showInfo(){
        System.out.printf("There are %d %s %s by %s. Size: %s\n", quantity, color, category, maker, size);
        //System.out.printf("Category: %s \tMaker: %s\tColor: %s\tSize: %f\tQuantity: %d\n", category, maker, color, size, quantity);
    }
}
