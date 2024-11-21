package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   //не будет изменений в БД
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }


   @Override
   public User findCarBySeriesAndModel(int series, String model) {
      return userDao.findCarBySeriesAndModel(series,model);
   }


   @Transactional
   public void saveUserList(List<User> userList) {
     userDao.saveUserList(userList);
   }




}
