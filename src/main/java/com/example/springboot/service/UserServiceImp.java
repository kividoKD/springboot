package com.example.springboot.service;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User showUser(Long id) {
      return userDao.showUser(id);
   }

   @Transactional
   @Override
   public void updateUser(Long id, User user) {
      userDao.updateUser(id, user);
   }

   @Transactional
   @Override
   public void deleteUser(Long id) {
      userDao.deleteUser(id);
   }
}
