package com.aptech.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable{
    @Id
    @Column(name = "Code", columnDefinition = "varchar(10)")
    private String code;
    @Column(name = "Name")
    private String name;
    @Column(name = "Phone", columnDefinition = "varchar(50)")
    @NaturalId
    private String phone;

    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Orders> orders = new ArrayList<>();
}
