package webshop20200924.webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import webshop20200924.webshop.models.Product;
import webshop20200924.webshop.repositories.IProductRepositoryImpl;
import webshop20200924.webshop.repositories.ProduktRepositoryImpl;

@Controller
public class ProduktController {

    private IProductRepositoryImpl productrepository;

    @Autowired
    public ProduktController() {

        productrepository = new ProduktRepositoryImpl();

        //her skal skrives kode
    }
    @GetMapping("/Produktadministration")
    public String produktadministration() {
        return "product/jakobsProdukter";
    }
    //-----------------------------------opret produkt-------------------------------------------------------//
    @GetMapping("/createProdukt")
    public String createProdukt(Model model) {
        model.addAttribute("produkt", new Product());
        return "product/createProdukt";
    }
    @PostMapping("/createProdukt")
    public String saveProdukt(@ModelAttribute Product product){

        productrepository.create(product);
        return "redirect:/Produktadministration";
    }
    //-----------------------------------opret produkt-færdig------------------------------------------------------//

    //-----------------------------------læs alle produkter-------------------------------------------------------//

    @GetMapping("/allProdukt")
    public String allProdukter(Model model){
        model.addAttribute("produkter", productrepository.readAll());
        return "product/alleProdukter";
    }

    /*---------------------------------------- Edit Customer ----------------------------------------------*/




    @GetMapping("/editProdukt/{produktID}")
    public String editCustomer(@PathVariable("produktID") int produktID,Model model){
        System.out.println("Vi er i editProdukt i ProduktController produktID = " + produktID);
        //Product product = productrepository.read(produktID);
        model.addAttribute("produkt", productrepository.read(produktID));
        return "product/editProdukt";
    }

    @PostMapping("/updateproduktet")
    public String updateNow(@ModelAttribute Product model)
    {

        System.out.println(("Vi er i update produkt controller og er igang med at update"));
        productrepository.edit(model);
        return "redirect:/Produktadministration";
    }

     /*------------------------------------- Delete Customer ---------------------------------------------*/


    @GetMapping("/deleteProdukt/{produktID}")
    public String deleteProdukt(@PathVariable("produktID") int produktID,Model model){
        System.out.println("Vi er i deleteProdukt i ProduktController produktID = " + produktID);
        model.addAttribute("produkt", productrepository.read(produktID));

        return "product/deleteProdukt";

    }


    @PostMapping("/deleteproduktet")
    // public String deleteNow(@ModelAttribute Product model)
    public String deleteNow(@RequestParam int produktID)
    {

        System.out.println(("Vi er i deleteNow produkt controller og er igang med at delete"));
        productrepository.delete(produktID);
        return "redirect:/Produktadministration";
    }


}
