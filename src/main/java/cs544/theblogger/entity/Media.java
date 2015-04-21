/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jeankahigiso
 */
@Entity(name="blog_media")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Media  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String source;
    @ManyToMany
    @JoinTable
    private List<Article> linkedArticles = new ArrayList<Article>();
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }
    
    public List<Article> getLinkedArticles() {
		return linkedArticles;
	}
	public void setLinkedArticles(List<Article> linkedArticles) {
		this.linkedArticles = linkedArticles;
	}
	public void setSource(String source) {
        this.source = source;
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
    
}
