/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementación del repositorio alternativa. Se puede cambiar las annotaciones
 *
 * @Default y @Alternative al gusto.
 *
 * @author Libardo, Julio
 */
@RequestScoped
@Alternative
public class IProductRepositoryImplArrays2 implements IProductRepository {

    public static List<Product> products;

    public IProductRepositoryImplArrays2() {
        if (products == null) {
            products = new ArrayList<>();
            initialize();
        }
    }

    private void initialize() {
        products.add(new Product(1, "Cama duplex", 300000d));
        products.add(new Product(2, "Sofa cama", 300000d));
        products.add(new Product(1, "Nochero", 400000d));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            //Ya existe
            return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product product) {
        Product prod = this.findById(product.getId());
        if (prod != null) {
            prod.setName(product.getName());
            prod.setPrice(product.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int i = 0;
        for (Product prod : products) {
            if (prod.getId() == id) {
                products.remove(i++);
                return true;
            }
        }
        return false;
    }
}
