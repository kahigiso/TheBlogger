/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cs544.theblogger.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
