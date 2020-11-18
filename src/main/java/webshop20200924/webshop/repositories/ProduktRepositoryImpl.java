package webshop20200924.webshop.repositories;

import webshop20200924.webshop.models.Product;
import webshop20200924.webshop.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProduktRepositoryImpl implements IProductRepositoryImpl {
    private Connection conn; //database?


    private static final String CREATE_PRODUKT_SQL = "INSERT INTO produkter" + "(produktID, vara_navn, vara_pris, vara_beskrivelse) VALUES" + "(?,?,?,?);";
    //private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customer WHERE cus_id =?";
    private static final String EDIT_PRODUKT_SQL = "UPDATE produkter SET vara_navn =?, vara_pris =?, vara_beskrivelse =? WHERE produktID=?;";
    private static final String DELETE_PRODUKT_SQL = "DELETE FROM produkter WHERE produktID=?";
   // private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customer WHERE cus_id =?";
    


    public ProduktRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    /*

    */

    @Override
    public void create(Product product) {
        System.out.println("Vi er i ProduktRepositoryImpl");
        try {
            PreparedStatement prep = conn.prepareStatement(CREATE_PRODUKT_SQL);
            {
                prep.setInt(1, product.getProduktID());
                prep.setString(2, product.getNavn());
                double pris = product.getpris();
                System.out.println("Produktbeskrivelsen er = " + product.getBeskrivelse());
                //int prisint = pris;
                //prep.setDouble(3,product.getpris());
                prep.setDouble(3,product.getpris());
                prep.setString(4,product.getBeskrivelse());
                prep.executeUpdate();
               // prep.
               //prep.s

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }





    @Override
    public List<Product> readAll() {
        List<Product> allProdukter = new ArrayList<Product>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produkter");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product tempProdukt = new Product();
               // tempProdukt.setproduktID(rs.getInt(1));
                tempProdukt.setproduktID(rs.getInt(1));
                tempProdukt.setNavn(rs.getString(2));
                tempProdukt.setPris(rs.getDouble(3));
                tempProdukt.setBeskrivelse(rs.getString(4));
                allProdukter.add(tempProdukt);
                System.out.println("Felterne hentes i readAll = "  );
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProdukter;
        //return null;
    }

    //Jeg er kommet her til
    @Override
    public Product read(int produktid) {
        Product productToReturn = new Product();
        try {
            PreparedStatement getSingleProdukt = conn.prepareStatement("SELECT * FROM produkter WHERE produktID=?");
            getSingleProdukt.setInt(1, produktid);
            System.out.println("Vi er i read i linie 115");
            ResultSet rs = getSingleProdukt.executeQuery();
            while (rs.next()) {
                productToReturn = new Product();
                productToReturn.setproduktID(rs.getInt("produktID"));
                productToReturn.setNavn(rs.getString(2));
                productToReturn.setPris(rs.getDouble(3));
                productToReturn.setBeskrivelse(rs.getString(4));
            }
            } catch (SQLException e) {
               e.printStackTrace();
            }
        return productToReturn;
        //return null;
    }
    /*


     */



    /*------------------------------readAll slut----------------------------------------*/

    @Override
    public void edit(Product product) {
        try {

            PreparedStatement prep = conn.prepareStatement(EDIT_PRODUKT_SQL);
            System.out.println("Vi er i edit produkter linie 205");
            prep.setString(1, product.getNavn());
            //prep.setDouble(3,product.getpris());
            prep.setDouble(2,product.getpris());
            prep.setString(3,product.getBeskrivelse());
            prep.setInt(4,product.getProduktID());
            prep.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




  @Override
    public void delete(int produktid) {
        try {

            PreparedStatement prep = conn.prepareStatement(DELETE_PRODUKT_SQL);
            System.out.println("Vi er i delete produkter linie 229  produktid = " + produktid);
            //prep.setString(1, product.getNavn());
            prep.setInt(1, produktid);

            //prep.setDouble(2,product.getpris());
            //prep.setString(3,product.getBeskrivelse());
            //prep.setInt(4,product.getProduktID());
            prep.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /*




     */






}
