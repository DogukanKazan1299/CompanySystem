
package entity;


public class Depo {
    
    private int id;
    private String urunadi;
    private String urunozelligi;
    private int adeti;
    private int sirketid;

    public Depo(int id, String urunadi, String urunozelligi, int adeti, int sirketid) {
        this.id = id;
        this.urunadi = urunadi;
        this.urunozelligi = urunozelligi;
        this.adeti = adeti;
        this.sirketid = sirketid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public String getUrunozelligi() {
        return urunozelligi;
    }

    public void setUrunozelligi(String urunozelligi) {
        this.urunozelligi = urunozelligi;
    }
    public int getAdeti() {
        return adeti;
    }

    public void setAdeti(int adeti) {
        this.adeti = adeti;
    }

    public int getSirketid() {
        return sirketid;
    }

    public void setSirketid(int sirketid) {
        this.sirketid = sirketid;
    }
    
    
}
