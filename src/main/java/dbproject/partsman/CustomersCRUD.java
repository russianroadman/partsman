package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class CustomersCRUD {

    private static Session session;

    public static void create(String f,
                              String s,
                              String m,
                              String e,
                              String p,
                              String st,
                              String bl,
                              String zip){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_CUSTOMER('"+f+"', '"+s+"', '"+m+"', '"+e+"', '"+p+"', '"+st+"', '"+bl+"', '"+zip+"');").executeUpdate();
        session.close();
    }

    public static List<String[]> read(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> customers = session.createSQLQuery("call parts.GET_CUSTOMERS();").getResultList();
        session.close();
        return customers;
    }

    public static void update(String id,
                              String f,
                              String s,
                              String m,
                              String e,
                              String p,
                              String st,
                              String bl,
                              String zip){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_CUSTOMER("+id+", '"+f+"', '"+s+"', '"+m+"', '"+e+"', '"+p+"', '"+st+"', '"+bl+"', '"+zip+"');").executeUpdate();
        session.close();
    }

    public static void delete(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_CUSTOMER("+id+");").executeUpdate();
        session.close();
    }

}
