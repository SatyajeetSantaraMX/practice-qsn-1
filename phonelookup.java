import java.util.*;
class phoenlookup
{
    public static ArrayList<String>phonelookup(String number)
    {
        HashMap<Character,String>map=new HashMap<>();
        map.put('2',"ABC");
        map.put('3',"DEF");
        map.put('4',"GHI");
        map.put('5',"JKL");
        map.put('6',"MNO");
        map.put('7',"PQRS");
        map.put('8',"TUV");
        map.put('9',"WXYZ");
        
        ArrayList<String>result=new ArrayList<>();
        for(char digit:number.toCharArray())
        {
            if(map.containsKey(digit))
            {
                result.add(map.get(digit));
            }
        }
        return result;

    }
    public static void main(String args[])
    {
        String number="43556";
        System.out.println(phonelookup(number));
    }
}