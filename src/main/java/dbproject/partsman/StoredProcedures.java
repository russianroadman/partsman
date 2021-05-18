package dbproject.partsman;

import org.hibernate.Session;
import java.util.List;

public class StoredProcedures {

    private static Session session;

    public static List<String> getBrands(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String> brands = session.createSQLQuery("call parts.GET_BRANDS();").getResultList();
        session.close();
        return brands;
    }

    public static List<String[]> getCustomers(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> customers = session.createSQLQuery("call parts.GET_CUSTOMERS();").getResultList();
        session.close();
        return customers;
    }

    public static List<String[]> getItems(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> items = session.createSQLQuery("call parts.GET_ITEMS();").getResultList();
        session.close();
        return items;
    }

    public static List<String[]> getInstock(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> instock = session.createSQLQuery("call parts.GET_INSTOCK();").getResultList();
        session.close();
        return instock;
    }

    public static List<String[]> getOrders(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> orders = session.createSQLQuery("call parts.GET_ORDERS();").getResultList();
        session.close();
        return orders;
    }

    public static List<String[]> getSuppliers(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> suppliers = session.createSQLQuery("call parts.GET_SUPPLIERS();").getResultList();
        session.close();
        return suppliers;
    }

    public static List<String[]> getWorkers(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> workers = session.createSQLQuery("call parts.GET_WORKERS();").getResultList();
        session.close();
        return workers;
    }

    public static void addItem(String title, String snum, String qtty, String price){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_ITEM_TO_INSTOCK(\""+title+"\", \""+snum+"\", "+qtty+", "+price+");").executeUpdate();
        session.close();
    }


}
