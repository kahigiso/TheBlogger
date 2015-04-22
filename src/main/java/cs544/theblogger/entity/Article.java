/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jeankahigiso
 */
@Entity(name="blog_article")
public class Article {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
    @NotBlank
    @Column(nullable = false)
    private String title;
    private Boolean daft = true;
    @Lob
    @Type(type="text")
    @NotBlank
    @Column(nullable = false)
    private String content; 
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<Comment>();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public Boolean getDraft(){
    	return daft;
    }
    public void setDraft(Boolean bool){
    	this.daft= bool;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        if(!comments.contains(comment)){
            this.comments.add(comment);
            comment.setArticle(this);
        }
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }

    private void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    private void setUpdatedDate(Date updatedDate) {
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
        Date now  = new Date();
        this.setUpdatedDate(now); 
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", title=" + title + '}';
    }
}
