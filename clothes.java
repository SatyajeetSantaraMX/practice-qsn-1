import java.util.ArrayList;
public class clothes {

    public static ArrayList<String> removeTags(String results) {
        ArrayList<String> list = new ArrayList<>();

        int start = 0;

        while (true) {
            int open = results.indexOf("<li", start);
            if (open == -1) {
                break;
            }
            int contentStart = results.indexOf(">", open) + 1;
            int close = results.indexOf("</li>", contentStart);
            String text = results.substring(contentStart, close);
            text = text.replaceAll("<[^>]*>", "");

            if (!text.isEmpty()) {
                list.add(text);
            }
            start = close + 5;
        }
        return list;
    }
    public static void main(String[] args) {

        String results = """
                <li>100% Cotton</li>
                <li class="highlight-gray">Imported</li>
                <li></li>
                <li><p>Machine Wash in Cold Water</p></li>
                <li><p>dry wash</p></li>

                """;

        System.out.println(removeTags(results));
    }
}