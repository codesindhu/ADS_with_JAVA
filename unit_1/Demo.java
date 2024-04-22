// autoboxing & unboxing 
public class Demo 
{
    public static void main(String args[])
    {

        int a=10;
        System.out.println(a);
        Integer data=new Integer(a);// Autoboxing
        System.out.println(data);//

        int b=data.intValue();//unboxing
        System.out.println(b);

    }
}