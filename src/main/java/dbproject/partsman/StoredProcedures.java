package dbproject.partsman;
import org.hibernate.Session;

import java.util.List;

public class StoredProcedures {

    private static Session session;

    public static List<String[]> getDocLiquids(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> doc = session.createSQLQuery("call parts.DOC_LIQUIDS();").getResultList();
        session.close();
        return doc;
    }

    public static List<String[]> getDocTools(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> doc = session.createSQLQuery("call parts.DOC_TOOLS();").getResultList();
        session.close();
        return doc;
    }

    public static List<String[]> getDocClients(String city){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> doc = session.createSQLQuery("call parts.DOC_CLIENTS('"+city+"');").getResultList();
        session.close();
        return doc;
    }

    public static List<String[]> getDocOrder(String orderId){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> doc =
                session.createSQLQuery("call parts.DOC_ORDER_FROM_SPECIFIC_CLIENT("+orderId+");").getResultList();
        session.close();
        return doc;
    }

    public static List<String[]> getOrderInfo(String orderId){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> info =
                session.createSQLQuery("call parts.GET_ORDER_INFO("+orderId+");").getResultList();
        session.close();
        return info;
    }

}
