
package entity;

import java.awt.List;
import java.sql.Date;



public class Calisanlar {
    
    private int id;
    private String ad_soyad;
    private String departman;
    private Date giristarihi;
    private float sozlesmesuresi;
    private int sirketid;

    public Calisanlar(int id, String ad_soyad, String departman, Date giristarihi, float sozlesmesuresi, int sirketid) {
        this.id = id;
        this.ad_soyad = ad_soyad;
        this.departman = departman;
        this.giristarihi = giristarihi;
        this.sozlesmesuresi = sozlesmesuresi;
        this.sirketid = sirketid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public Date getGiristarihi() {
        return giristarihi;
    }

    public void setGiristarihi(Date giristarihi) {
        this.giristarihi = giristarihi;
    }

    public float getSozlesmesuresi() {
        return sozlesmesuresi;
    }

    public void setSozlesmesuresi(float sozlesmesuresi) {
        this.sozlesmesuresi = sozlesmesuresi;
    }

    public int getSirketid() {
        return sirketid;
    }

    public void setSirketd(int sirketid) {
        this.sirketid = sirketid;
    }
    
      
    
   
}
