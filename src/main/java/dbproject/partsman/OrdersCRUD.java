package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class OrdersCRUD {

    private static Session session;

    public static void create(String customerId){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_ORDER_TO_CUSTOMER("+customerId+");").executeUpdate();
        session.close();
    }

    public static List<String[]> read(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> orders = session.createSQLQuery("call parts.GET_ORDERS();").getResultList();
        session.close();
        return orders;
    }

    public static void update(String id, String customerId, String workerId){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_ORDER("+id+", "+customerId+", "+workerId+");").executeUpdate();
        session.close();
    }

    public static void delete(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_ORDER("+id+");").executeUpdate();
        session.close();
    }

    public static void check(String id, String state){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.CHECK_ORDER("+id+", '"+state+"');").executeUpdate();
        session.close();
    }

}
