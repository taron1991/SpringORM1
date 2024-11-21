package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);


        userService.saveUserList(Arrays.asList(new User("namex","lastz","email"),new User("nameq","last2","email2")));
        carService.saveCarList(Arrays.asList(new Car("modelx",1),new Car("modely",3)));

        List<User> users = userService.listUsers();
        List<Car> cars = carService.cars();
        for (int i = 0; i <users.size() ; i++) {
            User user = users.get(i);
            Car car = cars.get(i);
            user.setCar(car);
            car.setUser(user);
            userService.add(user);
        }




        context.close();
    }
}
