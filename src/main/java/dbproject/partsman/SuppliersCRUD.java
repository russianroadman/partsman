package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class SuppliersCRUD {

    private static Session session;

    public static void create(String country,
                              String homestate,
                              String city,
                              String street,
                              String building,
                              String zip){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_SUPPLIER('"+country+"', '"+homestate+"', '"+city+"', '"+street+"', '"+building+"', "+zip+");").executeUpdate();
        session.close();
    }

    public static List<String[]> read(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> suppliers = session.createSQLQuery("call parts.GET_SUPPLIERS();").getResultList();
        session.close();
        return suppliers;
    }

    public static void update(String id,
                              String country,
                              String homestate,
                              String city,
                              String street,
                              String building,
                              String zip){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_SUPPLIER("+id+", '"+country+"', '"+homestate+"', '"+city+"', '"+street+"', '"+building+"', "+zip+");").executeUpdate();
        session.close();
    }

    public static void delete(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_SUPPLIER("+id+");").executeUpdate();
        session.close();
    }

}
