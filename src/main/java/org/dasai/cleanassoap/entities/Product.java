package org.dasai.cleanassoap.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer code;
    private String name;
    private Double price;
    private Date createdAt;
}
