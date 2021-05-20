package dbproject.partsman;

import org.hibernate.Session;

import java.util.List;

public class WorkersCRUD {

    private static Session session;

    public static void create(String f,
                              String s,
                              String m){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.ADD_WORKER('"+f+"', '"+s+"', '"+m+"');").executeUpdate();
        session.close();
    }

    public static List<String[]> read(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> workers = session.createSQLQuery("call parts.GET_WORKERS();").getResultList();
        session.close();
        return workers;
    }

    public static void update(String id,
                              String f,
                              String s,
                              String m){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.UPDATE_WORKER("+id+", '"+f+"', '"+s+"', '"+m+"');").executeUpdate();
        session.close();
    }

    public static void delete(String id){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("call parts.DELETE_WORKER("+id+");").executeUpdate();
        session.close();
    }

}
