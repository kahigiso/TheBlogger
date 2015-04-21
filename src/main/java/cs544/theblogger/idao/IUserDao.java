/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.idao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.User;


@Transactional(propagation=Propagation.MANDATORY)
public interface IUserDao {
    public  User create(User user);
    public  void update(User user);
    public  User get(Long id);
    public  List<User> getAll();
    public  void delete(Long id);
}
