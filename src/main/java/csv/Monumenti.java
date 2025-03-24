package csv;

import java.io.*;
import java.security.Permission;
import java.util.EnumSet;

public class Monumenti {


    //Aggiungere, in coda ad ogni record, un campo chiamato "miovalore", contenente un numero casuale compreso tra 10<=X<=20
    //ed un campo per marcare la cancellazione logica
    public void aggiungiValori(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/csv/lazzaroni.csv"));
            PrintWriter pw = new PrintWriter(new FileWriter("src/main/java/csv/test.txt"))){
            String line = "";
            while ((line = br.readLine())!=null){
                line = line.substring(0,line.length()-1);
                pw.print(line+";"+(int)(Math.random()*11+10)+";"+"false\n");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //contare il numero dei campi che compongono il record.
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

    //calcolare la lunghezza massima dei record presenti (avanzato: indicando anche la lunghezza massima di ogni campo);
    public int maxLength(){
        int maxLength=0;
        int cont=0;
        try(FileReader r = new FileReader("src/main/java/csv/test.txt")){
            int c;
            while((c=r.read())!=-1){
                if((char)c == '\n'){
                    if (cont>maxLength){
                        maxLength=cont;
                    }
                    cont=0;
                }else{
                    cont++;
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return maxLength;
    }

    //inserire in ogni record un numero di spazi necessari a rendere fissa la dimensione di tutti i record, senza perdere informazioni.
    public void addSpazi(){
        int lengthNeeded=maxLength();
        String result="";
        try(BufferedReader r = new BufferedReader(new FileReader("src/main/java/csv/test.txt"))){
            String line;
            while((line=r.readLine())!=null){
                result+=line;
                for (int i = line.length(); i<lengthNeeded; i++){
                    result+=" ";
                }
                result+="\n";
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(PrintWriter p = new PrintWriter(new FileWriter("src/main/java/csv/test.txt"))){
            p.print(result);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Aggiungere un record in coda
    public void addRecod(Monumento m){
        try(PrintWriter out = new PrintWriter(new FileWriter("src/main/java/csv/test.txt",true))){
            out.print(m.toString());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
