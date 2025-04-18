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

    //calcolare la lunghezza massima dei record presenti
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

    //Visualizzare dei dati mostrando tre campi significativi a scelta
    public String getCampi(int campo1,int campo2, int campo3){
        String out="";
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/csv/test.txt"))){
            String line;
            while((line=br.readLine())!=null){
                String[] split = new String[12];
                split = line.split(";");
                out+= split[campo1]+";"+split[campo2]+";"+split[campo3]+"\n";
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return out;
    }

    //Ricercare un record per campo chiave a scelta (se esiste, utilizzare il campo che contiene dati univoci)
    public String getFromId(String OSMid){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/csv/test.txt"))){
            String line=br.readLine(); //il primo è il nome del campo
            while((line=br.readLine())!=null){
                if(line.split(";")[7].equals(OSMid)){
                    return line;
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return "not found";
    }

    //Modificare  un record;
    public void editRecord(String id, String newRecord){
        String out="";
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/csv/test.txt"))){
            String line=br.readLine(); //il primo è il nome del campo
            out += line+"\n";
            while((line=br.readLine())!=null){
                if(line.split(";")[7].equals(id)){
                    out+=newRecord+"\n";
                }else{
                    out+=line+"\n";
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(PrintWriter pw = new PrintWriter(new FileWriter("src/main/java/csv/test.txt"))){
            pw.print(out);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Cancellare logicamente un record
    public void logicalDeleteRecord(String OSMid) {
        String out="";
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/csv/test.txt"))){
            String line=br.readLine(); //il primo è il nome del campo
            out += line+"\n";
            while((line=br.readLine())!=null){
                if(line.split(";")[7].equals(OSMid)){
                    out+=line.substring(0, line.length() - 4);
                    out+="false\n";
                }else{
                    out+=line+"\n";
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(PrintWriter pw = new PrintWriter(new FileWriter("src/main/java/csv/test.txt"))){
            pw.print(out);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // crea html
    public void creaHTML(){
        try(BufferedReader in = new BufferedReader(new FileReader("src/main/java/csv/lazzaroni.csv"));
            PrintWriter out = new PrintWriter(new FileWriter("src/main/java/csv/test.html"))){
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<style>\n" +
                    "table, th, td {\n" +
                    "  border:1px solid black;\n" +
                    "}\n" +
                    "</style>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Monumenti OSM</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "   <table style=\"width:100%\">");
            String line = in.readLine();
            String[] valori = line.split(";");

            out.print("<tr>\n");
            for(int i= 0; i<valori.length;i++){
                out.print("<th>"+valori[i]+"</th>");
            }
            out.print("</tr>\n");

            while ((line = in.readLine())!=null){
                valori = line.split(";");
                out.print("<tr>\n");
                for(int i= 0; i<valori.length;i++){
                    out.print("<td>"+valori[i]+"</td>");
                }
                out.print("</tr>\n");
            }
            out.print("</table>\n" +
                    "</body>\n" +
                    "</html>");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
