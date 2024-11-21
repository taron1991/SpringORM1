package hiber.dao;

import hiber.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoIpml implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveCarList(List<Car> carList) {
        Session session = sessionFactory.getCurrentSession();

        for (Car car:carList){
            session.save(car);
        }
    }

    @Override
    public List<Car> cars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

}
