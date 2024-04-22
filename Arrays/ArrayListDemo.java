import java.util.ArrayList;
public class ArrayListDemo {
    public static void main(String args[])
    {
        ArrayList<String> al=new ArrayList();
        al.add("ram");//0
        al.add("krishna");//1
        al.add("phani");//2
        System.out.println(al.get(0));
        al.set(1,"Rama");


        System.out.println("Elements present in the list : ");
       
                for( String i : al)
                {
                    System.out.println(i);
                }
    }
}
