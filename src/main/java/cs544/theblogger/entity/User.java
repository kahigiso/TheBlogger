/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jeankahigiso
 */
@Entity(name="blog_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @NotBlank (message="Username cannot be blank")
    @Size(min = 3,message="Username has to be at least 2 character long")
    private String username;
    @Size(min = 5, message="Password has to be at least 5 character long")
    @NotBlank (message="Password cannot be blank")
    private String password;
    @Email(message="Is not a valid email!")
    @Column(unique = true, nullable= false)
    private String email;
    @Past(message="Data has to be in the past")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    private Boolean actived = false;
    @ManyToMany(cascade = CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinTable(name = "user_roles",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<Role>();
    
    public User(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }
    
    public Set<Role> getRoles() {
        return roles;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    @PrePersist
    public void prePersist(){
        Date now  = new Date();
        this.setCreatedDate(now);
        this.setUpdatedDate(now); 
    }
    
    @PreUpdate
    public void preUpdate(){
        this.setUpdatedDate(new Date()); 
    }
    
    @Transient
    public void addRoles(Role role) {
    	roles.add(role);
    	role.getUsers().add(this); 
    }
    
    @Transient
    public String getFullName(){
        return firstName+" "+lastName;
    }

    @Override
    public String toString() {
        return "User{" + "id= " + id + ", firstName= " + firstName + ", lastName= " + lastName + ", actived= " + actived + '}';
    } 
}
