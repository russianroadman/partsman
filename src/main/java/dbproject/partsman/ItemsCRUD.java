package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class ItemsCRUD {

    private static Session session;

    public static void create(String type,
                              String serial,
                              String supplierID,
                              String brandTitle,
                              String description,
                              String title,
                              String category,
                              String partQtty){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        System.out.println("call parts.ADD_ITEM('"+type+"', '"+serial+"', "+supplierID+", '"+brandTitle+"', '"+description+"', '"+title+"', '"+category+"', "+partQtty+");");
        session.createSQLQuery("call parts.ADD_ITEM('"+type+"', '"+serial+"', "+supplierID+", '"+brandTitle+"', '"+description+"', '"+title+"', '"+category+"', "+partQtty+");").executeUpdate();
        session.close();
    }

    public static List<String[]> read(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> items = session.createSQLQuery("call parts.GET_ITEMS();").getResultList();
        session.close();
        return items;
    }

    public static void update(String selectedSerial,
                              String selectedTitle,
                              String serial,
                              String supplierID,
                              String brandTitle,
                              String description,
                              String title,
                              String category,
                              String partQtty){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_ITEM('"+selectedSerial+"',  '"+selectedTitle+"', '"+serial+"', "+supplierID+", '"+brandTitle+"', '"+description+"', '"+title+"', '"+category+"', "+partQtty+");").executeUpdate();
        session.close();
    }

    public static void delete(String serial, String title){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_ITEM('"+serial+"', '"+title+"');").executeUpdate();
        session.close();
    }



}
