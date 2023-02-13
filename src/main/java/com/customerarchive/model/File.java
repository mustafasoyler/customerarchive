package com.customerarchive.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "file")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String fileName;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;

}
