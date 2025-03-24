package csv;

public class Main {
    public static void main(String[] args){
        Monumenti m = new Monumenti();
        m.aggiungiValori();
        System.out.println("numero di campi di un record: "+m.recordLength());
        System.out.println("lunghezza massima record: "+m.maxLength());
        //m.addSpazi();
        //System.out.println("lunghezza massima record: "+m.maxLength());
        m.addRecod(new Monumento("Bracca","Bergamo","Lombardia","Monumento degli Alpini","Commemorativo","2025","13:26",5381359,13.4,24.5,12,false));
        System.out.println(m.getCampi(0,3,6));
    }
}
