package com.customerarchive.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String customerName;

    @Column(name = "lastName")
    private String customerLastName;

    @Column(name = "email")
    private String customerEmail;

    @OneToMany(mappedBy ="customer",fetch =FetchType.LAZY)
    private List<File> fileList;


}
