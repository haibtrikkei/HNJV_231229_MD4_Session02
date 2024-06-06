package org.example.demo_api_crud.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;
    @Column(length = 100)
    private String proName;
    @Column(length = 100)
    private String producer;
    private Integer yearMaking;
    private Date expireDate;
    @Min(value = 0)
    private Integer quantity;
    @Min(value = 0)
    private Double price;
}
