package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> cars();
    void saveCarList(List<Car> carList);
}
