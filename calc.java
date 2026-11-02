import java.util.*;

//interfaceeeeeeee
interface calculator{
    double add(double a,double b);
    double substract(double a ,double b);
    double multiply(double a,double b);
    double divide(double a ,double b);
}

//abstract classsss

abstract class abstractCalc implements calculator
{
    //normal methoddddd
    public void res(String operation,double result)
    {
        System.out.println(operation+" = "+result)
    }

    //abstract methodddddd

    public abstract void calculatorType();
    
}
//child class1
 
class BasicCalculator extends abstractCalc{
    @Override 
    public double add(double a , double b){
        return a+b;
    }

    @Override 
    public double substract(double a,double b)
    {
        return a-b;
    }
    @Override
    public double multiply(double a,double b)
    {
        return a*b;
    }
    @Override 
    public double divide(double a ,double b)
    {
        if(b==0)
        {
            throw new ArithmeticException("cant divide by zero");
        }
        return a/b;
    }
     @Override
    public void calculatorType() {
        System.out.println("basic calculator");
    }
}

//child class 2


