package webshop20200924.webshop.repositories;

import webshop20200924.webshop.models.Product;

import java.util.List;

public interface IProductRepositoryImpl {

    public void create(Product product);

    public Product read(int produktid);

    public List<Product> readAll();

    public void edit(Product product);

    public void delete(int produktid);


    //public void delete(Product product);
}
