package pl.limescode.gkhibernate;

import pl.limescode.gkhibernate.dao.ProductDaoImpl;
import pl.limescode.gkhibernate.factory.SessionFactoryService;
import pl.limescode.gkhibernate.model.Product;

import java.util.Comparator;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        SessionFactoryService sessionFactoryService = new SessionFactoryService();
        sessionFactoryService.init();
        try {
            ProductDaoImpl productDao = new ProductDaoImpl(sessionFactoryService);

            System.out.println("===== CREATE =====");
            productDao.saveOrUpdate(new Product("Orange", 5));
            productDao.findAll().forEach(Product::print);

            System.out.println("===== READ =====");
            Product firstProduct = productDao.findById(1L);
            firstProduct.print();

            System.out.println("===== UPDATE =====");
            firstProduct.setTitle("Optical mouse");
            productDao.saveOrUpdate(firstProduct);
            List<Product> products = productDao.findAll();
            products.forEach(Product::print);

            System.out.println("===== DELETE =====");
            Long justAdded = products.stream().max(Comparator.comparing(product -> product.getId())).get().getId();
            productDao.deleteById(justAdded);
            productDao.findAll().forEach(Product::print);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryService.shutdown();
        }

    }
}
