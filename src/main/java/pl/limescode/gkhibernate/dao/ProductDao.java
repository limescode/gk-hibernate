package pl.limescode.gkhibernate.dao;

import pl.limescode.gkhibernate.model.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    Product saveOrUpdate(Product product);

    void deleteById(Long id);
}
