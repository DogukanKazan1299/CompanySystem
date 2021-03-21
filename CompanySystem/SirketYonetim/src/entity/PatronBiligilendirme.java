
package entity;


public class PatronBiligilendirme {
    
    private int id;
    private String bilgi;

    public PatronBiligilendirme(int id,String bilgi) {
        this.id = id;
        this.bilgi = bilgi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }
    
    

   
    
    
    
}
