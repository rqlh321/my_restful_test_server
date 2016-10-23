package main;

import main.HibernateUtil;
import model.Product;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProductDao  {

    public static void addProduct(Product product) throws SQLException {
        Session session = null;
        product.setDate(new Date());
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);           
            session.getTransaction()
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static void updateProduct(Product product) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();      
            product.setDate(new Date());
            session.update(product);
            session.getTransaction()
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Product getProduct(long id) throws SQLException {
        Session session = null;
        Product product = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            product = session.load(Product.class, id);         
            Hibernate.initialize(product);
            session.getTransaction()
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    public static void deleteProduct(long id) throws SQLException {
        Session session = null;       
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Product product = session.load(Product.class, id);         
            session.delete(product);
            session.getTransaction()
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }       
    }

    public static List<Product> getProducts() throws SQLException {
        List<Product> products = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            products = session.createCriteria(Product.class).list();
            session.getTransaction()
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return products;
    }

}
