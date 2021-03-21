
package entity;


public class Raporlar {
    
    private int id;
    private int toplamcalisan;
    private int toplamis;
    private int toplammaas;
    private int toplamgelir;
    private int digergiderler;
    private int netkarzarar;
    private int sirketid;

    public Raporlar(int id, int toplamcalisan, int toplamis, int toplammaas, int toplamgelir, int digergiderler, int netkarzarar, int sirketid) {
        this.id = id;
        this.toplamcalisan = toplamcalisan;
        this.toplamis = toplamis;
        this.toplammaas = toplammaas;
        this.toplamgelir = toplamgelir;
        this.digergiderler = digergiderler;
        this.netkarzarar = netkarzarar;
        this.sirketid = sirketid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToplamcalisan() {
        return toplamcalisan;
    }

    public void setToplamcalisan(int toplamcalisan) {
        this.toplamcalisan = toplamcalisan;
    }

    public int getToplamis() {
        return toplamis;
    }

    public void setToplamis(int toplamis) {
        this.toplamis = toplamis;
    }

    public int getToplammaas() {
        return toplammaas;
    }

    public void setToplammaas(int toplammaas) {
        this.toplammaas = toplammaas;
    }

    public int getToplamgelir() {
        return toplamgelir;
    }

    public void setToplamgelir(int toplamgelir) {
        this.toplamgelir = toplamgelir;
    }

    public int getDigergiderler() {
        return digergiderler;
    }

    public void setDigergiderler(int digergiderler) {
        this.digergiderler = digergiderler;
    }

    public int getNetkarzarar() {
        return netkarzarar;
    }

    public void setNetkarzarar(int netkarzarar) {
        this.netkarzarar = netkarzarar;
    }

    public int getSirketid() {
        return sirketid;
    }

    public void setSirketid(int sirketid) {
        this.sirketid = sirketid;
    }
     
    
}
