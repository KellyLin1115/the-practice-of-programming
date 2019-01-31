package chapter3.item3;

import java.io.*;
import java.util.*;

public class Chain {
    private static final int NPREF = 2;
    private static final String NONWORD = "\n";

    private Prefix<String> prefix = new Prefix<>(NPREF, NONWORD);
    private Map<Prefix, List<String>> map = new HashMap<>();

    private Random rand = new Random();

    public void build(File file) throws IOException {

        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = br.readLine();
        while(line != null ) {
            for (String suff : line.split(" "))
                add(suff);
            line = br.readLine();
        }
        add(NONWORD);
    }

    public void generate(int nWords){
        List<String> suffix;
        String word;
        prefix = new Prefix<>(NPREF, NONWORD);
        for (int i = 0; i < nWords; i++) {
            suffix = map.get(prefix);
            word = suffix.get(Math.abs(rand.nextInt()) % suffix.size());
            if(word.equals(NONWORD)) break;
            System.out.print(word + " ");
            if(i % 10 == 0) System.out.println();
            prefix.pref.remove(0);
            prefix.pref.add(word);
        }
    }

    private void add(String suff) {
        List<String> suffix = map.get(prefix);
        if(suffix == null) {
            suffix = new ArrayList<>();
            map.put(new Prefix(prefix), suffix);
        }
        suffix.add(suff);
        prefix.pref.remove(0);
        prefix.pref.add(suff);
    }

}
