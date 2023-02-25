import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Task_4_2 {
    private static void enqueue(LinkedList<Integer> myList, int num){
        myList.add(num);
    }
    private static int dequeue(LinkedList<Integer> myList){
        return myList.remove();
    }
    private static int first(LinkedList<Integer> myList){
        return myList.getFirst();
    }
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            myList.add(rand.nextInt(20));
        }
        System.out.println("Дана очередь");
        System.out.println(myList);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите элемент для добавления");
        int userElt=Integer.parseInt(sc.nextLine());
        sc.close();
        enqueue(myList, userElt);
        System.out.println("Элемент добавлен");
        System.out.println(myList);
        System.out.println("Первый из очереди с удалением");
        System.out.println(dequeue(myList));
        System.out.println(myList);
        System.out.println("Первый из очереди без удалением");
        System.out.println(first(myList));
        System.out.println(myList);
    }
}
