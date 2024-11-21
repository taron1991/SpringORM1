package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User findCarBySeriesAndModel(int series,String model);
    void saveUserList(List<User> userList);

}
