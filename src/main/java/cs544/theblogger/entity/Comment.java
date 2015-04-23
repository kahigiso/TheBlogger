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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jeankahigiso
 */
@Entity(name="blog_comment")
public class Comment { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Article article;
    @NotNull
    @Column(nullable = false)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Lob
    @Type(type="text")
    @Size(min = 10)
    @Column(nullable = false)
    private String message;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Comment parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> children = new ArrayList<Comment>();
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void addChildren(Comment child) {
        if(!children.contains(child)){
            children.add(child);
            child.setParent(this);
        }
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
        Date now  = new Date();
        this.setUpdatedDate(now); 
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", email=" + email + ", name=" + name + '}';
    }
    
}
