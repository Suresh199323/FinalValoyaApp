package com.valoya.login.login.Entity;


import com.valoya.login.login.domain.type.State;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

//import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "user")

public class User extends Perpetual {

    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    @Access(AccessType.FIELD)
    //@NaturalId
    private String name;
    @Column(nullable = false)
    @Access(AccessType.FIELD)
    private String email;
    @Column(nullable = false)
    @Access(AccessType.FIELD)
    private String password;

    @Column(nullable = false)
    @Access(AccessType.FIELD)
   // @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Role.class)
    private String role;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return Objects.toString(new Object[]{email, getId(), name});
    }
}