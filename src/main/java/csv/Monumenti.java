package csv;

import java.io.*;
import java.security.Permission;

public class Monumenti {

    public void aggiungiValori(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/csv/lazzaroni.csv"));
            PrintWriter pw = new PrintWriter(new FileWriter("src/main/java/csv/test.txt"))){
            String line = "";
            while ((line = br.readLine())!=null){
                line = line.substring(0,line.length()-1);
                pw.print(line+";"+(int)(Math.random()*10+10)+";"+"false\n");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public int recordLength(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/csv/test.txt"))){
            int cont = 0;
            String line = br.readLine();
            for (int i = 0; i<line.length();i++){
                if(line.charAt(i)==';'){
                    cont++;
                }
            }
            return cont+1;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }


}
