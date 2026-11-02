import java.time.*;
public class Datecheck123 {

    public static boolean isPalindrome(String date) {

        try {
            String digits;
            LocalDate validDate;

            if (date.contains("/")) {
                String[] parts = date.split("/");
                if (parts.length != 3)
                    return false;
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                year += 2000;
                validDate = LocalDate.of(year, month, day);
                digits = day + "" + month + "" + (year % 100);

            } 
            else if (date.contains("-")) 
                {
                String[] parts = date.split("-");

                if (parts.length != 3)
                    return false;
                int month = Integer.parseInt(parts[0]);
                int day = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                year += 2000;

                validDate = LocalDate.of(year, month, day);

                digits = month + "" + day + "" + (year % 100);

            } else if (date.contains("|")) {
                String[] parts = date.split("\\|");

                if (parts.length != 3)
                    return false;

                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);

                validDate = LocalDate.of(year, month, day);

                digits = year + "" + month + "" + day;

                // Challenge says ignore zeros
                digits = digits.replace("0", "");

            } else {
                return false;
            }

            String reversed = new StringBuilder(digits)
                    .reverse()
                    .toString();

            return digits.equals(reversed);

        } catch (NumberFormatException | DateTimeException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("25/5/25"));
        System.out.println(isPalindrome("5-25-25"));
        System.out.println(isPalindrome("3333|03|03"));
        System.out.println(isPalindrome("31-11-13"));
    }
}