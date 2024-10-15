package org.dasai.cleanassoap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.dasai.cleanassoap.entities.Product;
import org.dasai.cleanassoap.repositories.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@WebService(name = "ProductWS")
@Component
//@Transactional
public class ProductWebService {
    private ProductRepository productRepository;

//    @WebMethod(operationName = "getSellingPrice")
//    public Double sellingPrice(@WebParam(name = "Price") Double price) {
//        return price * 1.5;
//    }

    @WebMethod
    public Product getProduct(Integer code) {
        return productRepository.findById(code).orElse(null);
    }

    @WebMethod
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @WebMethod
    public Product addProduct(@WebParam(name = "name") String name, @WebParam(name = "price") Double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCreatedAt(new Date());

        return productRepository.save(product);
    }

    @WebMethod
    public Product updateProduct(
        @WebParam(name = "code") Integer code,
        @WebParam(name = "name") String name,
        @WebParam(name = "price") Double price
    ) {
        Product product = productRepository.findById(code).orElse(null);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);

            return productRepository.save(product);
        }
        return null;
    }

    @WebMethod
    public boolean deleteProduct(Integer code) {
        Product product = productRepository.findById(code).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }
}
