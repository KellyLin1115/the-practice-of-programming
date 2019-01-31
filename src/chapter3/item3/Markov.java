package chapter3.item3;

import java.io.File;
import java.io.IOException;

public class Markov {
    public static final int MAXGEN = 10000;
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/donger/Documents/workspace/the-practice-of-programming/" + "source/test.txt");
        Chain chain = new Chain();
        chain.build(file);
        chain.generate(MAXGEN);
    }
}
