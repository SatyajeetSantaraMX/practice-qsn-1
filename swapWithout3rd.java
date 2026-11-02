import java.util.*;
class sw{


public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter 2 numbers");
    int a,b;
    a=sc.nextInt();
    b=sc.nextInt();
        System.out.println("before swapping");
            System.out.println("a="+a);
                        System.out.println("b="+b);



    a=a+b;
    b=a-b;
    a=a-b;
System.out.println("after swapping");
            System.out.println("a="+a);
                        System.out.println("b="+b);
    
}}
