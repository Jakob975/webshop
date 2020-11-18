package webshop20200924.webshop.models;

public class Product {
    public int produktID;
             //produktID
    public String navn;
    //private double pris;
    public double pris;
    public String beskrivelse;

    public Product() {

    }

    public Product(int produktID, String navn, double pris, String beskrivelse) {
        this.produktID = produktID;
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;

    }
    public int getProduktID() { return produktID;}

    public void setproduktID(int produktID) { this.produktID = produktID;}

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getpris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }



}
