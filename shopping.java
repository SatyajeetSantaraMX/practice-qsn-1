import java.util.*;
class InvalidPriceException extends Exception
{
    public InvalidPriceException(String msg)
    {
        super (msg);
    }
}

class OutOfStockException extends Exception
{
    public OutOfStockException(String msg)
    {
        super (msg);
    }
}

class PaymentFailedException extends Exception
{
    public PaymentFailedException(String msg)
    {
        super(msg);
    }
}


public class shopping{
    static void logPriceError(String msg)
    {
        System.out.println("price error "+msg);
    }

    static void logStockError(String msg)
    {
        System.out.println("stock error "+msg);
       }
    static void logPaymentError(String msg)
    {
        System.out.println("Payment error "+msg);
    }




    static void makepayment(double amt)throws PaymentFailedException{
        System.out.println("connecting to payment gateway>>>>>>>>>>");

        Random random =new Random();

        if(random.nextBoolean())
        {
            throw new PaymentFailedException("payment failed xxxxxxx");
        }
        System.out.println("payment successful !!!!! of RS "+amt);
    }

    public static void main(String args[])
    {
        double price=10000;
        int stock=20;
        int quantity=10;

        boolean gatewayconnected=false;

        try{
            if (price<0)
            {
                throw new InvalidPriceException("product price cant be -ve ");
            }
            if(stock<quantity)
            {
                throw new OutOfStockException("insufficient stock");
            }
            System.out.println("product validation successful");

            gatewayconnected=true;
            System.out.println("payment gateway connected");

            double total =price*quantity;

            System.out.println("total amt= "+total);

            makepayment(total);
            stock=stock-quantity;
            System.out.println("order placed successfully");
            System.out.println("remaing stock = "+stock);
        }

        catch(InvalidPriceException e){
            logPriceError(e.getMessage());

        }

        catch(OutOfStockException e){
            logStockError(e.getMessage());
        }
        catch(PaymentFailedException e){
            logPaymentError(e.getMessage());
        }

        catch (Exception e)
        {
            System.out.println("genereal error "+e.getMessage());
        }

        finally{
            if(gatewayconnected){
                System.out.println("closing gateway commection");  

                gatewayconnected=false;
                System.out.println("payment gateawy connection closed");


                      }

                      System.out.println("checkout process completed");


        }
    }
}


