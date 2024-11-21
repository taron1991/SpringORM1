package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<Car> cars();
    User findCarBySeriesAndModel(int series,String model);
    void saveUserList(List<User> userList);
    void saveCarList(List<Car> carList);
}
