
package entity;


import Connection.Veritabani;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Kullanici {
    
    private Connection con = null;

    private  Statement statement = null;
    private PreparedStatement preparedStatement = null;
     
        public ArrayList<Calisanlar> calisanlariGetir() {
        ArrayList<Calisanlar> cikti = new ArrayList<Calisanlar>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From calisanlar ORDER BY id ASC";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String ad_soyad = rs.getString("ad_soyad");
                String departman = rs.getString("departman");
                Date giristarihi = rs.getDate("giristarihi");
                int sozlesmesuresi = rs.getInt("sozlesmesuresi");
                int sirketid = rs.getInt("sirketid");
                
                cikti.add(new Calisanlar(id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
        
    public ArrayList<Yonetici> yoneticileriGetir() {
        ArrayList<Yonetici> cikti = new ArrayList<Yonetici>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From yonetici ORDER BY id ASC";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String ad_soyad = rs.getString("ad_soyad");
                String departman = rs.getString("departman");
                Date giristarihi = rs.getDate("giristarihi");
                int sozlesmesuresi = rs.getInt("sozlesmesuresi");
                int sirketid = rs.getInt("sirketid");
                int y_maas = rs.getInt("y_maas");
                
                cikti.add(new Yonetici(id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid, y_maas));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Personel> personelleriGetir() {
        ArrayList<Personel> cikti = new ArrayList<Personel>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From personel ORDER BY id ASC";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String ad_soyad = rs.getString("ad_soyad");
                String departman = rs.getString("departman");
                Date giristarihi = rs.getDate("giristarihi");
                int sozlesmesuresi = rs.getInt("sozlesmesuresi");
                int sirketid = rs.getInt("sirketid");
                int p_maas = rs.getInt("p_maas");
                
                cikti.add(new Personel(id, ad_soyad, departman, giristarihi, sozlesmesuresi, sirketid, p_maas));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Depo> urunleriGetir() {
        ArrayList<Depo> cikti = new ArrayList<Depo>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From depo";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String urunadi = rs.getString("urunadi");
                String urunozelligi = rs.getString("urunozelligi");
                int adeti = rs.getInt("adeti");
                int sirketid = rs.getInt("sirketid");
                
                cikti.add(new Depo(id, urunadi, urunozelligi,adeti, sirketid ));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Isler> isleriGetir() {
        ArrayList<Isler> cikti = new ArrayList<Isler>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From isler";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String isadi = rs.getString("isadi");
                String isalani = rs.getString("isalani");
                String isyapilanfirma = rs.getString("isyapilanfirma");
                float sozlesmesuresi = rs.getFloat("sozlesmesuresi");
                int isgeliri = rs.getInt("isgeliri");
                int digergelirler = rs.getInt("digergelirler");
                int sirketid = rs.getInt("sirketid");
                
                cikti.add(new Isler(id, isadi, isalani,isyapilanfirma, sozlesmesuresi,isgeliri,digergelirler, sirketid ));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Raporlar> raporGetir() {
        ArrayList<Raporlar> cikti = new ArrayList<Raporlar>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From raporlar";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                int toplamcalisan = rs.getInt("toplamcalisan");
                int toplamis = rs.getInt("toplamis");
                int toplammaas = rs.getInt("toplammaas");
                int toplamgelir = rs.getInt("toplamgelir");
                int digergiderler = rs.getInt("digergiderler");
                int netkarzarar = rs.getInt("netkarzarar");
                int sirketid = rs.getInt("sirketid");
                
                cikti.add(new Raporlar(id, toplamcalisan, toplamis,toplammaas, toplamgelir,digergiderler, netkarzarar, sirketid ));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<CalisanlarIsYapar> calisanlarIsYaparGetir() {
        ArrayList<CalisanlarIsYapar> cikti = new ArrayList<CalisanlarIsYapar>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From calisanlarisyapar";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int yoneticiid = rs.getInt("yoneticiid");
                int personelid = rs.getInt("personelid");
                Date yapildigitarih = rs.getDate("yapildigitarih");               
                int isid = rs.getInt("isid");
                
                cikti.add(new CalisanlarIsYapar(yoneticiid,personelid,yapildigitarih,isid));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<PatronBiligilendirme> patronBilgiGetir(){
        
        ArrayList<PatronBiligilendirme> cikti = new ArrayList<PatronBiligilendirme>();
        try {
            statement = con.createStatement();
            String sorgu = "Select * from patron";
            
            ResultSet rs = statement.executeQuery(sorgu);
            
              while(rs.next()){
                  int id=rs.getInt("id");
                String bilgi = rs.getString("bilgi");            
                
                cikti.add(new PatronBiligilendirme(id,bilgi));
                
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void personelEkle(int id, String ad_soyad, String departman, Date giristarihi, float sozlesmesuresi, int sirketid, int p_maas){
        
        String sorgu = "Insert into personel (id, ad_soyad,departman,giristarihi,sozlesmesuresi,sirketid,p_maas) VALUES(?,?,?,?,?,?,?)";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, ad_soyad);
            preparedStatement.setString(3, departman);
            preparedStatement.setDate(4, giristarihi);
            preparedStatement.setFloat(5, sozlesmesuresi);
            preparedStatement.setInt(6, sirketid);
            preparedStatement.setInt(7, p_maas);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void yoneticiGuncelle(int id,String yeni_ad_soyad,String yeni_departman,Date yeni_giristarihi,float yeni_sozlesmesuresi,int yeni_sirketid, int yeni_y_maas){
        
        String sorgu = "Update yonetici set ad_soyad = ? , departman = ? , giristarihi = ? , sozlesmesuresi = ? , sirketid = ? ,y_maas=? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_ad_soyad);
            preparedStatement.setString(2, yeni_departman);
            preparedStatement.setDate(3, yeni_giristarihi);
            preparedStatement.setFloat(4, yeni_sozlesmesuresi);
            preparedStatement.setInt(5, yeni_sirketid);
            preparedStatement.setInt(6, yeni_y_maas);
            
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void yoneticiEkle(int id, String ad_soyad, String departman, Date giristarihi, float sozlesmesuresi, int sirketid, int y_maas){
        
        String sorgu = "Insert into yonetici (id, ad_soyad,departman,giristarihi,sozlesmesuresi,sirketid,y_maas) VALUES(?,?,?,?,?,?,?)";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, ad_soyad);
            preparedStatement.setString(3, departman);
            preparedStatement.setDate(4, giristarihi);
            preparedStatement.setFloat(5, sozlesmesuresi);
            preparedStatement.setInt(6, sirketid);
            preparedStatement.setInt(7, y_maas);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void yoneticiSil(int id){
       String sorgu = "Delete from yonetici where id = ?";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void personelGuncelle(int id,String yeni_ad_soyad,String yeni_departman,Date yeni_giristarihi,float yeni_sozlesmesuresi,int yeni_sirketid, int yeni_p_maas){
        
        String sorgu = "Update personel set ad_soyad = ? , departman = ? , giristarihi = ? , sozlesmesuresi = ? , sirketid = ? ,p_maas=? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_ad_soyad);
            preparedStatement.setString(2, yeni_departman);
            preparedStatement.setDate(3, yeni_giristarihi);
            preparedStatement.setFloat(4, yeni_sozlesmesuresi);
            preparedStatement.setInt(5, yeni_sirketid);
            preparedStatement.setInt(6, yeni_p_maas);
            
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void personelSil(int id){
       String sorgu = "Delete from personel where id = ?";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void isEkle(int id, String isadi, String isalani, String isyapilanfirma, float sozlesmesuresi, int isgeliri,int digergelirler, int sirketid){
        
        String sorgu = "Insert into isler (id, isadi,isalani,isyapilanfirma,sozlesmesuresi,isgeliri,digergelirler,sirketid) VALUES(?,?,?,?,?,?,?,?)";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, isadi);
            preparedStatement.setString(3, isalani);
            preparedStatement.setString(4, isyapilanfirma);
            preparedStatement.setFloat(5, sozlesmesuresi);
            preparedStatement.setInt(6,isgeliri );
            preparedStatement.setInt(7, digergelirler);
            preparedStatement.setInt(8, sirketid);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void isGuncelle(int id,String yeni_isadi,String yeni_isalani,String yeni_firma,float yeni_sozlesmesuresi,int yeni_isgeliri,int yeni_digergelirler ,int yeni_sirketid){
        
        String sorgu = "Update isler set isadi = ? , isalani = ? , isyapilanfirma = ? , sozlesmesuresi = ? , isgeliri = ? , digergelirler = ? ,sirketid=? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_isadi);
            preparedStatement.setString(2, yeni_isalani);
            preparedStatement.setString(3, yeni_firma);
            preparedStatement.setFloat(4, yeni_sozlesmesuresi);
            preparedStatement.setInt(5, yeni_isgeliri);
            preparedStatement.setInt(6, yeni_digergelirler);
            preparedStatement.setInt(7, yeni_sirketid);
            
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void isSil(int id){
       String sorgu = "Delete from isler where id = ?";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    
     public void raporEkle(int id, int toplamcalisan, int toplamis, int toplammaas, int toplamgelir,int digergiderler, int netkarzarar, int sirketid){
        
        String sorgu = "Insert into raporlar (id, toplamcalisan,toplamis,toplammaas,toplamgelir,digergiderler,netkarzarar,sirketid) VALUES(?,?,?,?,?,?,?,?)";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, toplamcalisan);
            preparedStatement.setInt(3, toplamis);
            preparedStatement.setInt(4, toplammaas);
            preparedStatement.setInt(5, toplamgelir);
            preparedStatement.setInt(6,digergiderler );
            preparedStatement.setInt(7,netkarzarar );
            preparedStatement.setInt(8, sirketid);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public void raporGuncelle(int id,int yeni_tCalisan,int yeni_tIs,int yeni_tMaas,int yeni_tGelir,int yeni_dGiderler,int yeni_karzarar,int yeni_sirketid){
        
        String sorgu = "Update raporlar set toplamcalisan = ? , toplamis = ? , toplammaas = ? , toplamgelir = ?,digergiderler = ?,netkarzarar = ?,sirketid = ?  where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, yeni_tCalisan);
            preparedStatement.setInt(2, yeni_tIs);
            preparedStatement.setInt(3, yeni_tMaas);     
            preparedStatement.setInt(4, yeni_tGelir);
            preparedStatement.setInt(5, yeni_dGiderler);
            preparedStatement.setInt(6, yeni_karzarar);
            preparedStatement.setInt(7, yeni_sirketid);
            
            
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
     
    public void raporSil(int id){
       String sorgu = "Delete from raporlar where id = ?";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
      public void urunEkle(int id, String urunadi, String urunozelligi,int adeti ,int sirketid){
        
        String sorgu = "Insert into depo (id, urunadi,urunozelligi,adeti,sirketid) VALUES(?,?,?,?,?)";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, urunadi);
            preparedStatement.setString(3, urunozelligi);
            preparedStatement.setInt(4,adeti );
            preparedStatement.setInt(5, sirketid);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    public void depoGuncelle(int id,String yeni_urunadi,String yeni_urunozelligi,int yeni_adet,int yeni_sirketid){
        
        String sorgu = "Update depo set urunadi = ? , urunozelligi = ? , adeti = ? , sirketid = ?  where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_urunadi);
            preparedStatement.setString(2, yeni_urunozelligi);
            preparedStatement.setInt(3, yeni_adet);     
            preparedStatement.setInt(4, yeni_sirketid);
            
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void urunSil(int id){
       String sorgu = "Delete from depo where id = ?";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public void Ekle(int yoneticiid,int personelid, Date yapildigitarih, int isid){
        
        String sorgu = "Insert into calisanlarisyapar (yoneticiid,personelid, yapildigitarih,isid) VALUES(?,?,?,?)";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, yoneticiid);
            preparedStatement.setInt(2, personelid);
            preparedStatement.setDate(3, yapildigitarih);      
            preparedStatement.setInt(4, isid);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
    public void calisanisyaparGuncelle(int yoneticiid,int yeni_personelid, Date yeni_yapildigitarih, int yeni_isid){
        
        String sorgu = "Update calisanlarisyapar set personelid = ? , yapildigitarih = ? , isid = ?  where yoneticiid = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setInt(1, yeni_personelid);
            preparedStatement.setDate(2, yeni_yapildigitarih);
            preparedStatement.setInt(3, yeni_isid);
            
            
            preparedStatement.setInt(4, yoneticiid);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calisanisyaparSil(int yoneticiid){
       String sorgu = "Delete from calisanlarisyapar where yoneticiid = ?";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, yoneticiid);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void patronBilgiKaydet(String bilgi ){
        
        String sorgu = "Insert into patron (bilgi ) VALUES(?)";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
               
            
            preparedStatement.setString(1, bilgi);
                       
            preparedStatement.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void patronBilgiGuncelle(int id,String yeni_bilgi ){
        
        String sorgu = "Update patron set bilgi = ?  where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yeni_bilgi);
           
            
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     public void patronBilgiSil(int id){
       String sorgu = "Delete from patron where id = ?";
       
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public boolean girisYap(String kullaniciAdi,String parola){
        
        String sorgu = "Select * from kullanici where kullaniciadi = ? and parola = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kullanici.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
    }
    public Kullanici(){
        
         String url = "jdbc:postgresql://" + Veritabani.host + ":" + Veritabani.port +"/" + Veritabani.db_ismi;
        
          try {
            Class.forName("org.postgresql.Driver");
           
        } catch (Exception e) {
            System.out.println("Drive bulunamadi");
        }
          
        try {
            con = DriverManager.getConnection(url, Veritabani.kullanici_adi, Veritabani.parola);
            System.out.println("Baglanti başarılı");
                    
                    } catch (SQLException ex) {
            System.out.println("Baglanti başarısız");
        }
  
    }
       
    
}
