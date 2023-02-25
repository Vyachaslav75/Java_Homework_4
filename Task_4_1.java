import java.util.LinkedList;
import java.util.Random;

public class Task_4_1 {
    private static void change(LinkedList<Integer> mylist){
        for (int i = 0; i < mylist.size()/2; i++) {
            int pos=mylist.size()-2-i;
            int tmp=mylist.remove(i);
            mylist.add(i, mylist.remove(pos));
            mylist.add(pos+1, tmp);
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            myList.add(rand.nextInt(20));
        }
        System.out.println(myList);
        change(myList);
        System.out.println(myList);
    }
}
