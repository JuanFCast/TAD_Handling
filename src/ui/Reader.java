package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    
    private BufferedReader br;

    public Reader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readALine() throws IOException{
        return br.readLine();
    }

}