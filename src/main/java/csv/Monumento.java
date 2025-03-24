package csv;

public class Monumento {
    private String comune;
    private String provincia;
    private String regione;
    private String nome;
    private String tipo;
    private String anno_inserimento;
    private String data_ora_inserimento;
    private String identificatore_OSM;
    private double longitudine;
    private double latitudine;
    private int mio_valore;
    private boolean cancellato;

    @Override
    public String toString() {
        return comune+";"+provincia+";"+regione+";"+nome+";"+tipo+";"+anno_inserimento+";"+data_ora_inserimento+";"+identificatore_OSM+";"+longitudine+";"+latitudine+";"+mio_valore+";"+cancellato;
    }

    public Monumento(String comune, String provincia, String regione, String nome, String tipo, String anno_inserimento, String data_ora_inserimento, String identificatore_OSM, double longitudine, double latitudine, int mio_valore, boolean cancellato) {
        this.comune = comune;
        this.provincia = provincia;
        this.regione = regione;
        this.nome = nome;
        this.tipo = tipo;
        this.anno_inserimento = anno_inserimento;
        this.data_ora_inserimento = data_ora_inserimento;
        this.identificatore_OSM = identificatore_OSM;
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.mio_valore = mio_valore;
        this.cancellato = cancellato;
    }

    public int getMio_valore() {
        return mio_valore;
    }

    public boolean isCancellato() {
        return cancellato;
    }

    public void setMio_valore(int mio_valore) {
        this.mio_valore = mio_valore;
    }

    public void setCancellato(boolean cancellato) {
        this.cancellato = cancellato;
    }

    public String getComune() {
        return comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getRegione() {
        return regione;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAnno_inserimento() {
        return anno_inserimento;
    }

    public String getData_ora_inserimento() {
        return data_ora_inserimento;
    }

    public String getIdentificatore_OSM() {
        return identificatore_OSM;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAnno_inserimento(String anno_inserimento) {
        this.anno_inserimento = anno_inserimento;
    }

    public void setData_ora_inserimento(String data_ora_inserimento) {
        this.data_ora_inserimento = data_ora_inserimento;
    }

    public void setIdentificatore_OSM(String identificatore_OSM) {
        this.identificatore_OSM = identificatore_OSM;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }
}

