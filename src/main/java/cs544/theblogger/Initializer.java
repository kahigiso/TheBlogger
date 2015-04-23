/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger;


import cs544.theblogger.entity.Article;
import cs544.theblogger.entity.Category;
import cs544.theblogger.entity.Comment;
import cs544.theblogger.entity.Role;
import cs544.theblogger.entity.User;
import cs544.theblogger.service.ArticleService;
import cs544.theblogger.service.CategoryService;
import cs544.theblogger.service.CommentService;
import cs544.theblogger.service.PictureService;
import cs544.theblogger.service.RoleService;
import cs544.theblogger.service.UserService;
import cs544.theblogger.service.VideoService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeankahigiso
 */
@Transactional
@Component
public class Initializer {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService  userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private VideoService videoService;
 
    @PostConstruct
    public void init(){
        System.out.println("Got here!");
        Map<String,Role> roles =  createRole();
        Map<String,User> users = createUser(roles);
        Map<String, Category> cMap = createCategiry(users.get("ADMIN"));
        Map<String, Article> aMap = createArticle(cMap);
        createComment(aMap);
        System.out.println("End here! number of user"+users.size());
    }
    
    
    private void createComment(Map<String, Article> aMap){
    	for(String str: aMap.keySet()){
    		Article art = aMap.get(str);
    		newComment(art,"email"+str+"@gmail.com","Jean"+""+str,CONTENT,null);
    	}
    }
    
    private Map<String, Article> createArticle(Map<String,Category> catMap){
    	Map<String, Article> aMap = new HashMap<String, Article>();
    	aMap.put("1", newArticle(catMap.get("Java"), "Java Article One", CONTENT+" Java "+CONTENT+" Java "+CONTENT));
    	aMap.put("2", newArticle(catMap.get("Java"), "Java Article Two", CONTENT+" Java "+CONTENT+" Java "+CONTENT+" Java "+CONTENT));
    	aMap.put("3", newArticle(catMap.get("Java"), "Java Article Three", CONTENT+" Java "+CONTENT+" Java "+CONTENT));
    	aMap.put("4", newArticle(catMap.get("Java"), "Java Article Four", CONTENT+" Java "+CONTENT+" Java "+CONTENT));
    	
    	aMap.put("5", newArticle(catMap.get("C#"), "C# Article One", CONTENT+" C# "+CONTENT+" C# "+CONTENT));
    	aMap.put("6", newArticle(catMap.get("C#"), "C# Article Two", CONTENT+" C# "+CONTENT+" C# "+CONTENT+" C#"+CONTENT));
    	aMap.put("7", newArticle(catMap.get("C#"), "C# Article Three", CONTENT+" C# "+CONTENT+" C# "+CONTENT));
    	aMap.put("8", newArticle(catMap.get("C#"), "C# Article Four", CONTENT+" C# "+CONTENT+" C# "+CONTENT));
    	aMap.put("9", newArticle(catMap.get("C#"), "C# Article Five", CONTENT+" C# "+CONTENT+" C# "+CONTENT));
    	
    	aMap.put("10", newArticle(catMap.get("PHP"), "PHP Article One", CONTENT+" PHP "+CONTENT+" PHP"+CONTENT+" PHP"+CONTENT));
    	aMap.put("11", newArticle(catMap.get("PHP"), "PHP Article Two", CONTENT+" PHP "+CONTENT+" PHP "+CONTENT));
    	aMap.put("12", newArticle(catMap.get("PHP"), "PHP Article Three", CONTENT+" PHP "+CONTENT+" PHP "+CONTENT+" PHP"+CONTENT));
    	aMap.put("13", newArticle(catMap.get("PHP"), "PHP Article Four", CONTENT+" PHP "+CONTENT+" PHP"+CONTENT));
    	
    	aMap.put("14", newArticle(catMap.get("Python"), "Python Article One", CONTENT+" Python "+CONTENT+" Python"+CONTENT+" Python"+CONTENT));
    	aMap.put("15", newArticle(catMap.get("Python"), "Python Article Two", CONTENT+" Python "+CONTENT+" Python "+CONTENT));
    	
    	
    	aMap.put("16", newArticle(catMap.get("Swift"), "Swift Article One", CONTENT+" Swift "+CONTENT+" Swift"+CONTENT+" PHP"+CONTENT));
    	aMap.put("17", newArticle(catMap.get("Swift"), "Swift Article Two", CONTENT+" Swift "+CONTENT+" Swift "+CONTENT));
    	aMap.put("18", newArticle(catMap.get("Swift"), "Swift Article Three", CONTENT+" Swift "+CONTENT+" Swift"+CONTENT+" PHP"+CONTENT));
    	aMap.put("19", newArticle(catMap.get("Swift"), "Swift Article Four", CONTENT+" Swift "+CONTENT+" Swift "+CONTENT));
    	
    	aMap.put("20", newArticle(catMap.get("MySql"), "MySql Article One", CONTENT+" MySql "+CONTENT+" MySql"+CONTENT+" MySql"+CONTENT));
    	aMap.put("21", newArticle(catMap.get("MySql"), "MySql Article Two", CONTENT+" MySql "+CONTENT+" MySql "+CONTENT));
    	
    	aMap.put("22", newArticle(catMap.get("HSQLDB"), "HSQLDB Article One", CONTENT+" HSQLDB "+CONTENT+" HSQLDB"+CONTENT+" HSQLDB "+CONTENT));
    	aMap.put("23", newArticle(catMap.get("HSQLDB"), "HSQLDB Article Two", CONTENT+" HSQLDB "+CONTENT+" HSQLDB "+CONTENT));
    	aMap.put("24", newArticle(catMap.get("HSQLDB"), "HSQLDB Article Three", CONTENT+" HSQLDB "+CONTENT+" HSQLDB"+CONTENT+" HSQLDB "+CONTENT));
    		
    	return aMap;
    }
    
    
    private Map<String,Category> createCategiry(User admin){
    	Map<String,Category> catMap = new HashMap<String, Category>();
    	catMap.put("Java", newCategory("Java"));
    	catMap.put("C#", newCategory("C#"));
    	catMap.put("PHP", newCategory("PHP"));
    	catMap.put("Python", newCategory("Python"));
    	catMap.put("Swift", newCategory("Swift"));
    	catMap.put("MySql", newCategory("MySql"));
    	catMap.put("HSQLDB", newCategory("HSQLDB"));
    	return catMap;
    }

    private Map<String,User> createUser(Map<String,Role> roles){
         Map<String,User> users = new HashMap<String,User>();
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         users.put("admin", newUser("admin", encoder.encode("admin"), "admin@mail.com", createDate(3, 2, 1980), roles.get("ADMIN")));
         users.put("contributer", newUser("contributer", "contributer", "contributer@mail.com", createDate(12,8,1990), roles.get("CONTRIBUTOR")));
         return users;
    }

    private Map<String,Role> createRole(){
        Map<String,Role> roles = new HashMap<String,Role>();
        roles.put("ADMIN", newRole("ROLE_ADMIN"));
        roles.put("CONTRIBUTOR", newRole("ROLE_USER"));
        return roles;
    }
		 
    public Comment newComment(Article article,String email,String name,String message,Comment parent){
        Comment comment = new Comment();
        comment.setArticle(article);
        comment.setEmail(email);
        comment.setName(name);
        comment.setMessage(message);
        if(parent!=null) parent.addChildren(comment);
        return commentService.create(comment);
    }
    
    public Article newArticle(Category category, String title, String content){
       Article article = new Article();
       article.setCategory(category);
       article.setTitle(title);
       article.setContent(content);
       article.setDraft(false);
       return articleService.create(article);
    }
    
    public Category newCategory(String name){
        Category category = new Category();
        category.setName(name);
        return categoryService.create(category);
    }
    
    private User newUser(String usrn, String psswrd, String email, Date dob, Role role){
        User user = new User();
        user.setUsername(usrn);
        user.setPassword(psswrd);
        user.setEmail(email);
        user.setDob(dob);
        user.setActived(true);
        user.addRoles(role);
        return userService.create(user);
    }
    
    private Role newRole(String name){
       Role role = new Role();
       role.setName(name);
       return roleService.create(role); 
    }
    private Date createDate(int day, int month, int year){
    	Calendar cal = Calendar.getInstance();
    	cal.set(year, month-1, day);
    	return cal.getTime();
    }
    
    private final String CONTENT = "Novum volumus eu vis, vim primis iuvaret eu. Cu mundi efficiantur pro, sed in dicta persius intellegam. "+" "
    		+ ""+"Per ut alia mazim, odio homero sententiae sea an, ex ius error omnium explicari. Mei ex ullum elaboraret. Vis facer everti "+""
    		+"apeirian ut, tempor rationibus at eam, duo delenit mediocritatem te. Id quo clita nostrud accusamus, impetus definitiones qui cu."+" "
    				+ ""+"Autem movet mundi vis ei, et rebum oratio maiorum mea. Ius magna consequat voluptatibus no, no diam offendit convenire "+ ""
    						+ ""+"quo. Cum posse laboramus signiferumque et, scripta vivendum ut nam. Ex est nonumes suscipit.";
    
}
