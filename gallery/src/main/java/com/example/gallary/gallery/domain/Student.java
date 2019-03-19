package com.example.gallary.gallery.domain;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name="StudentDetail")
public class Student extends Perpetual {

    @Column
    @Access(AccessType.FIELD)

    private  String name;

     @Column
     @Access(AccessType.FIELD)
     private String address;

     @Column
     @Access(AccessType.FIELD)
    private int age;

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailai) {
        this.email = email;
    }

    @Column
    @NaturalId
     @Access(AccessType.FIELD)
     private String email;



     @Column
     @Access(AccessType.FIELD)
     private int phone;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
