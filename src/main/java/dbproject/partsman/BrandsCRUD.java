package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class BrandsCRUD {

    private static Session session;

    public static void create(String title){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_BRAND(\"" + title + "\");").executeUpdate();
        session.close();
    }

    public static List<String[]> read(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> brands = session.createSQLQuery("call parts.GET_BRANDS();").getResultList();
        session.close();
        return brands;
    }

    public static void update(String id, String title){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_BRAND(" + id + ", \"" + title + "\");").executeUpdate();
        session.close();
    }

    public static void delete(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_BRAND(" + id + ");").executeUpdate();
        session.close();
    }

}
