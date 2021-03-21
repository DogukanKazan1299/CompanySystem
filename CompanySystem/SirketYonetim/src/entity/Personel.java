
package entity;

import java.sql.Date;


public class Personel extends Calisanlar {
    
    private int p_maas;

    public Personel(int id, String ad_soyad, String departman, Date giristarihi, float sozlesmesuresi, int sirketid,int p_maas) {
        super(id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid);
        this.p_maas = p_maas;
    }

    public int getP_maas() {
        return p_maas;
    }

    public void setP_maas(int p_maas) {
        this.p_maas = p_maas;
    }
    
}
