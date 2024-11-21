package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findCarBySeriesAndModel(int series, String model) {
        String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("model", model);
        query.setParameter("series", series);



        return (User) query.getSingleResult();
    }

    @Override
    public void saveUserList(List<User> userList) {

        Session session = sessionFactory.getCurrentSession();

        for (User user:userList){
            session.save(user);
        }
    }

    @Override
    public void saveCarList(List<Car> carList) {
        Session session = sessionFactory.getCurrentSession();

        for (Car car:carList){
            session.save(car);
        }
    }

    @Override
    public List<Car> getcars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }


}
