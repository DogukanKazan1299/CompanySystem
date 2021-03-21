
package entity;

import java.sql.Date;


public class CalisanlarIsYapar {
    
    private int yoneticiid;
    private int personelid;
    private Date yapildigitarih;
    private int isid;

    public CalisanlarIsYapar(int yoneticiid, int personelid, Date yapildigitarih, int isid) {
        this.yoneticiid = yoneticiid;
        this.personelid = personelid;
        this.yapildigitarih = yapildigitarih;
        this.isid = isid;
    }
    
    

    public int getYoneticiid() {
        return yoneticiid;
    }

    public void setYoneticiid(int yoneticiid) {
        this.yoneticiid = yoneticiid;
    }

    public int getPersonelid() {
        return personelid;
    }

    public void setPersonelid(int personelid) {
        this.personelid = personelid;
    }

    public Date getYapildigitarih() {
        return yapildigitarih;
    }

    public void setYapildigitarih(Date yapildigitarih) {
        this.yapildigitarih = yapildigitarih;
    }

    public int getIsid() {
        return isid;
    }

    public void setIsid(int isid) {
        this.isid = isid;
    }

   
    
    
    
    
}
