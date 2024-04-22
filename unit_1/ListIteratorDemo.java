import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        
        ArrayList<Character> al=new ArrayList<>();
        char a ='a';
        for(int i=0;i<26;i++)
        {
            al.add(a);
            a++;
        }
        ListIterator<Character> ltr=al.listIterator();

        System.out.println("forward direction");
        while(ltr.hasNext())
        {
            System.out.println(ltr.next());
        }
        System.out.println("backward diraction");

        while(ltr.hasPrevious())
        {
            System.out.println(ltr.previous());
        }
    }
}
