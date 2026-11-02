import java.util.*;
class Swap
{
    public static void main(String args[])
    {
        System.out.println("enter 2 nums");
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        int temp;
        System.out.println("before swapping");

                System.out.println("a = "+a);
                        System.out.println("b = "+b);
        
        temp=b;
        b=a;
        a=temp;
        
        System.out.println("before swapping");

                System.out.println("a = "+a);
                        System.out.println("b = "+b);


    }
}