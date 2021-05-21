package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class DetailsCRUD {

    private static Session session;

    public static void create(String idOrder, String idInstock, String qtty){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_ORDER_ITEM("+idOrder+", "+idInstock+", "+qtty+");").executeUpdate();
        session.close();
    }

    public static List<String[]> read(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> details = session.createSQLQuery("call parts.GET_ORDER_DETAILS("+id+");").getResultList();
        session.close();
        return details;
    }

    public static void update(String id,
                              String qtty){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_ORDER_ITEM("+id+", "+qtty+");").executeUpdate();
        session.close();
    }

    public static void delete(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_ORDER_ITEM("+id+");").executeUpdate();
        session.close();
    }

}
