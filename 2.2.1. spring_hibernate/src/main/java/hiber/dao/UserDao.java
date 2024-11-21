package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User findCarBySeriesAndModel(int series, String model);
   void saveUserList(List<User> userList);
   void saveCarList(List<Car> carList);

   List<Car> getcars();
}
