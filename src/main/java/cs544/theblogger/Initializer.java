/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger;

import cs544.theblogger.dao.RoleDao;
import cs544.theblogger.dao.UserDao;
import cs544.theblogger.entity.Article;
import cs544.theblogger.entity.Category;
import cs544.theblogger.entity.Comment;
import cs544.theblogger.entity.Role;
import cs544.theblogger.entity.User;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jeankahigiso
 */
@Transactional
@Service
public class Initializer {
	
	@Autowired
	RoleDao roleDao;
	@Autowired
	UserDao  userDao;
    
    @PostConstruct
    public void init(){
        System.out.println("Got here!");
        Map<String,Role> roles =  createRole();
        Map<String,User> users = createUser(roles);
        System.out.println("End here!");
    }

    private Map<String,User> createUser(Map<String,Role> roles){
         Map<String,User> users = new HashMap<String,User>();
         users.put("admin", newUser("admin", "admin", "admin@mail.com", createDate(3, 2, 1980), roles.get("ADMIN")));
         users.put("contributer", newUser("contributer", "contributer", "contributer@mail.com", createDate(12,8,1990), roles.get("CONTRIBUTOR")));
         return users;
    }

    private Map<String,Role> createRole(){
        Map<String,Role> roles = new HashMap<String,Role>();
        roles.put("ADMIN", newRole("ADMIN"));
        roles.put("CONTRIBUTOR", newRole("CONTRIBUTOR"));
        return roles;
    }
		 
    public Comment newComment(Article article,String email,String name,String message,Comment parent){
        Comment comment = new Comment();
        comment.setArticle(article);
        comment.setEmail(email);
        comment.setName(name);
        comment.setMessage(message);
        if(parent!=null) parent.addChildren(comment);
        return comment;
    }
    
    public Article newArticle(Category category, String title, String content){
       Article article = new Article();
       article.setCategory(category);
       article.setTitle(title);
       article.setContent(content);
       return article;
    }
    
    public Category newCategory(String name){
        Category category = new Category();
        category.setName(name);
        return category;
    }
    
    private User newUser(String usrn, String psswrd, String email, Date dob, Role role){
        User user = new User();
        user.setUsername(usrn);
        user.setPassword(psswrd);
        user.setEmail(email);
        user.setDob(dob);
        user.setActived(true);
        user.addRoles(role);
        return userDao.createUser(user);
    }
    
    private Role newRole(String name){
       Role role = new Role();
       role.setName(name);
       return roleDao.createRole(role); 
    }
    private Date createDate(int day, int month, int year){
    	Calendar cal = Calendar.getInstance();
    	cal.set(year, month-1, day);
    	return cal.getTime();
    }
}
