import java.io.*;
import java.util.*;

class Dialouges {

    private List<String> lines = new ArrayList<String>();
    String[] stopWords = { "the", "is", "for", "are", "of", "on", "to", "your", "we", "our", "can", "even", "a", "who",
            "be", "two", "there", "me", "as", "being", "i", "into", "and", "no", "out", "not", "good", "which", "been",
            "means" };

    public String[] readOriginalFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public void replaceWords() {
        ArrayList<String> lns = new ArrayList<String>();
        ArrayList<String> trimmed = new ArrayList<String>();
        for (String ln : lines) {
            String punc = ln.replaceAll("\\p{Punct}", "");
            ln = punc.toLowerCase();
            for (int i = 0; i < stopWords.length; i++) {
                String uw = stopWords[i];
                String b = "\\b" + uw + "\\b";
                String x = ln.replaceAll(b, "");
                ln = x;
            }
            String t = ln.trim();
            lns.add(t.replaceAll("\\s+", " "));
        }
        lines.clear();
        lines = lns;
        System.out.println(lines);
    }

    public void writeToNewFile() throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        ArrayList<String> keys = new ArrayList<String>();
        Hashtable<String, ArrayList<String>> ht = new Hashtable<>();
        String f;
        Scanner sc = new Scanner(System.in);
        for (String str : lines) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
        for (String str : lines) {
            for (String word : str.split("\\s+")) {
                keys.add(word);
            }
        }
        for (int j = 0; j < keys.size(); j++) {
            ArrayList<String> friends = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    System.out.println("Enter meaning of " + keys.get(j) + ":");
                    f = sc.nextLine();
                    friends.add(f);
                } else {
                    System.out.println("Enter synonym " + i);
                    f = sc.nextLine();
                    friends.add(f);
                }
            }

            ht.put(keys.get(j), friends);
        }

        System.out.println(ht);
    }

}

public class four {
    public static void main(String[] args) {
        Dialouges Dialougesobject = new Dialouges();

        String filename = "dialogs2.txt";

        try {
            String[] lines = Dialougesobject.readOriginalFile("dialogs.txt");
            System.out.println("______ORIGINAL DOCUMENT______\n");
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println("\n\n");
            Dialougesobject.replaceWords();
            Dialougesobject.writeToNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create " + filename + ": " + e.getMessage());
        }
    }
}