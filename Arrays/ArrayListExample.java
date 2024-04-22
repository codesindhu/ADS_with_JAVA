package unit_1;
import java.util.ArrayList;
public class ArrayListExample {
public static void main(String[] args) {
        
ArrayList<String>cse= new ArrayList<>();

cse.add("Apple");
cse.add("Banana");
cse.add("Orange");
System.out.println("Element at index 0: " + cse.get(0)); 
System.out.println("Elements in the ArrayList:");
        for (String fruit: cse) {
System.out.println(fruit);
        }

System.out.println("replace item");
cse.set(2,"berry");
for (String fruit: cse) {
        System.out.println(fruit);
                }

                
System.out.println(cse.isEmpty());
System.out.println(cse.size());
cse.remove("Banana");
System.out.println("Size of ArrayList after removal: " + cse.size()); 
    }
}
