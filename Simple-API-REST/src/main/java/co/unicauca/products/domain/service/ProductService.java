/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.products.domain.service;

import co.unicauca.products.access.IProductRepository;
import co.unicauca.products.domain.entity.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import java.util.List;

/**
 * Fachada de acceso al negocio por parte de la presentación. Usa el repositorio
 * por defecto. Si no se pone @Default tambien funciona, pues inyecta la
 * implementaició por defecto
 *
 * @author Libardo, Julio
 */
@RequestScoped
public class ProductService {

    /**
     * Inyecta una implementación del repositorio
     */
    @Inject
    @Default
    IProductRepository repo;

    public ProductService() {
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(int id) {
        return repo.findById(id);
    }

    public boolean create(Product prod) {
        return repo.create(prod);
    }

    public boolean update(Product prod) {
        return repo.update(prod);
    }

    public boolean delete(int id) {
        return repo.delete(id);
    }
}
