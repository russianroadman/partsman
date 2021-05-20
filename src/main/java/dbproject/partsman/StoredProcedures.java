package dbproject.partsman;

import org.hibernate.Session;
import java.util.List;

public class StoredProcedures {

    private static Session session;

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


    public static void addItem(String title, String snum, String qtty, String price){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_ITEM_TO_INSTOCK(\""+title+"\", \""+snum+"\", "+qtty+", "+price+");").executeUpdate();
        session.close();
    }


}
