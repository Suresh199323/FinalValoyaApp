/*


package com.valoya.login.login.Entity;

import com.valoya.login.login.domain.type.State;
import com.valoya.login.login.Entity.User;
import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "company", uniqueConstraints = {
    @UniqueConstraint(columnNames = "name")
})
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Company extends Perpetual {

    public static final Integer SKIP = Integer.valueOf(1);
    public static final Integer DONT_SKIP = Integer.valueOf(0);

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true) @Access(AccessType.FIELD)
    @NaturalId
    private String name;

    @Column(nullable = true) @Access(AccessType.FIELD)
    private String address;

    @Column(nullable = true) @Access(AccessType.FIELD)

    private String city;

    @Column(nullable = true) @Access(AccessType.FIELD)
    private String country;

    @Column(nullable = true) @Access(AccessType.FIELD)
    private String zipcode;

    @Column(nullable = true) @Access(AccessType.FIELD)
    private String contactNumber;

    @Column(nullable = true) @Access(AccessType.FIELD)
    private String faxNumber;

    @Column(nullable = true) @Access(AccessType.FIELD)
    private Integer skip;

    @Column(nullable = false) @Access(AccessType.FIELD)
    private State state;

    @Column(nullable = false, name="registeredOn")
    @Access(AccessType.FIELD)
    private Date registeredOn;

    @Column(nullable = true) @Access(AccessType.FIELD)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private Set<User> users;

    @ManyToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(formula=@JoinFormula(value="(SELECT u.id FROM user u INNER JOIN company c ON u.company_id = c.id where (u.role_id = 1 and c.id = id))", referencedColumnName="id")),
    })
//    @OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    private User companyHead;

    public Company() {
        this.state = State.ACTIVE;
    }

    public void validate() {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Company name is mandatory");
        }
//        if (StringUtils.isBlank(address)) {
//            throw new IllegalArgumentException("Company address is mandatory");
//        }
//        if (StringUtils.isBlank(city)) {
//            throw new IllegalArgumentException("Company's city is mandatory");
//        }
//        if (StringUtils.isBlank(country)) {
//            throw new IllegalArgumentException("Company's country is mandatory");
//        }
//        if (StringUtils.isBlank(zipcode)) {
//            throw new IllegalArgumentException("Company's zipcode is mandatory");
//        }
        if (state == null) {
            throw new IllegalArgumentException("Company's state is mandatory");
        }
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isActive() {
        return state != null && State.ACTIVE.equals(state);
    }

    public void markActivated() {
        state = State.ACTIVE;
    }

    public User getCompanyHead() {
        return companyHead;
    }

    public void setCompanyHead(User companyHead) {
        this.companyHead = companyHead;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    @Override
    public String toString() {
        return name;
    }
}
*/
