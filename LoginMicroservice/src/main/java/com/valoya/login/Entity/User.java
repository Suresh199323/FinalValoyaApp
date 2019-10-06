package com.valoya.login.Entity;


import javax.persistence.*;
import java.util.Objects;

//import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "user")

public class User {

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.FIELD)
    private Long id;
    @Column(nullable = false)

    //@NaturalId
    private String name;
    @Column(nullable = false)

    private String email;
    @Column(nullable = false)

    private String password;

    @Column(nullable = false)

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