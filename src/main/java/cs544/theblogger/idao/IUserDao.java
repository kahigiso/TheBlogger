/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.idao;

import cs544.theblogger.entity.User;
import java.util.List;

/**
 *
 * @author jeankahigiso
 */
public interface IUserDao {
    public abstract User createUser(User user);
    public abstract void updateUser(User user);
    public abstract User loadUser(Long userId);
    public abstract List<User> getUsers(Long userId);
}
