package org.example.demo_search_paging_sort_api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;
    @Column(length = 70)
    private String fullName;
    private Boolean gender;
    private Date birthday;
    @Column(length = 200)
    private String address;
    @Column(length = 100)
    private String className;
}
