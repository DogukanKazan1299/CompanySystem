
package entity;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Yonetici extends Calisanlar {
    
    private int y_maas;

    public Yonetici(int id, String ad_soyad, String departman, Date giristarihi, float sozlesmesuresi, int sirketid,int y_maas) {
        super(id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid);
        this.y_maas = y_maas;
    }

    

    public int getY_maas() {
        return y_maas;
    }

    public void setY_maas(int y_maas) {
        this.y_maas = y_maas;
    }
    
}
