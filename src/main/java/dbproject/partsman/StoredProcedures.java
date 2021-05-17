package dbproject.partsman;

import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class StoredProcedures {

    private static Session session;

    public static List<String[]> getInstock(){
        session = HibernateSession.getCurrentSession();
        session.beginTransaction();
        List<String[]> instock = session.createSQLQuery("call parts.GET_INSTOCK();").getResultList();
        session.close();
        return instock;
    }

}
