package csv;

public class Main {
    public static void main(String[] args){
        Monumenti m = new Monumenti();
        m.aggiungiValori();
        System.out.println("numero di campi di un record: "+m.recordLength());
        System.out.println("lunghezza massima record: "+m.maxLength());
        m.addSpazi();
        System.out.println("lunghezza massima record: "+m.maxLength());
    }
}
