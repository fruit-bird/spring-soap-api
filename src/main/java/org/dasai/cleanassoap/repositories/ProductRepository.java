package org.dasai.cleanassoap.repositories;

import org.dasai.cleanassoap.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
