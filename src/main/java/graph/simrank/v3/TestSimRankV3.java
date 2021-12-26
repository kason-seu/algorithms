package graph.simrank.v3;


import graph.simrank.v2.SimCalculator;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestSimRankV3 {


    private static SimRank simRank;
    public static void main(String[] args) throws Exception {
        FileReader file= new FileReader("graph.txt");
        BufferedReader b= new BufferedReader(file);
        String s=b.readLine();

        simRank = new SimRank();

        while(s!=null) {
            simRank.initNomi(s);
            s=b.readLine();
        }
        /*calculator.initScore(c);
        int sizeCol=calculator.getNomi().size();*/
    }


}
