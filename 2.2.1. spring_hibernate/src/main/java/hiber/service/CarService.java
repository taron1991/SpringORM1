package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    List<Car> cars();
    void saveCarList(List<Car> carList);
}
