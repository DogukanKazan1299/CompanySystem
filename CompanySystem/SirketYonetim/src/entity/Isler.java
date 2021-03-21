
package entity;

import java.util.ArrayList;


public class Isler {
    
    private int id;
    private String isadi;
    private String isalani;
    private String isyapilanfirma;
    private float sozlesmesuresi;
    private int isgeliri;
    private int digergelirler;
    private int sirketid;

    public Isler(int id, String isadi, String isalani, String isyapilanfirma, float sozlesmesuresi, int isgeliri, int digergelirler, int sirketid) {
        this.id = id;
        this.isadi = isadi;
        this.isalani = isalani;
        this.isyapilanfirma = isyapilanfirma;
        this.sozlesmesuresi = sozlesmesuresi;
        this.isgeliri = isgeliri;
        this.digergelirler = digergelirler;
        this.sirketid = sirketid;
    }

    Isler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsadi() {
        return isadi;
    }

    public void setIsadi(String isadi) {
        this.isadi = isadi;
    }

    public String getIsalani() {
        return isalani;
    }

    public void setIsalani(String isalani) {
        this.isalani = isalani;
    }

    public String getIsyapilanfirma() {
        return isyapilanfirma;
    }

    public void setIsyapilanfirma(String isyapilanfirma) {
        this.isyapilanfirma = isyapilanfirma;
    }

    public float getSozlesmesuresi() {
        return sozlesmesuresi;
    }

    public void setSozlesmesuresi(float sozlesmesuresi) {
        this.sozlesmesuresi = sozlesmesuresi;
    }

    public int getIsgeliri() {
        return isgeliri;
    }

    public void setIsgeliri(int isgeliri) {
        this.isgeliri = isgeliri;
    }

    public int getDigergelirler() {
        return digergelirler;
    }

    public void setDigergelirler(int digergelirler) {
        this.digergelirler = digergelirler;
    }

    public int getSirketid() {
        return sirketid;
    }

    public void setSirketid(int sirketid) {
        this.sirketid = sirketid;
    }
   
 
}
