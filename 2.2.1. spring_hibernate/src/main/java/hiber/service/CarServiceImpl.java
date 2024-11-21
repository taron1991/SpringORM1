package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {
    @Autowired
    private  CarDao carDao;

    @Override
    public List<Car> cars() {
        return carDao.cars();
    }

    @Transactional
    public void saveCarList(List<Car> carList) {
        carDao.saveCarList(carList);
    }
}
