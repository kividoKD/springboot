package com.example.springboot.dao;


import com.example.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getListUsers() {
      TypedQuery<User> query= (TypedQuery<User>) entityManager.createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUser(Long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void updateUser(Long id, User user) {

      User userToBeUpdated = entityManager.find(User.class, id);

      userToBeUpdated.setFirstName(user.getFirstName());
      userToBeUpdated.setLastName(user.getLastName());
      userToBeUpdated.setEmail(user.getEmail());
   }

   @Override
   public void deleteUser(Long id) {
      User userToDelete = entityManager.find(User.class, id);
      entityManager.remove(userToDelete);
   }
}
