package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class InstockCRUD {

    private static Session session;

    public static void create(String title, String snum, String qtty, String price){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_ITEM_TO_INSTOCK(\""+title+"\", \""+snum+"\", "+qtty+", "+price+");").executeUpdate();
        session.close();
    }

    public static List<String[]> read(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> instock = session.createSQLQuery("call parts.GET_INSTOCK();").getResultList();
        session.close();
        return instock;
    }

    public static void delete(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_INSTOCK(" + id + ");").executeUpdate();
        session.close();
    }

    public static void update(String id, String qtty, String price){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_INSTOCK("+id+", "+qtty+", "+price+");").executeUpdate();
        session.close();
    }

}
