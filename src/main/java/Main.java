import com.project.academia.bean.Department;
import com.project.academia.bean.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

//public class Main {
//    private static final SessionFactory ourSessionFactory;
//
//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            ourSessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//
//        } finally {
//            session.close();
//        }
//    }
//}
public class Main{
    public static void main(String[] args){
        System.out.println("Project started ...");
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Department d1=new Department();
        d1.setDept_id(1);
        d1.setName("HR");
        d1.setCapacity(2);

        Department d2=new Department();
        d2.setDept_id(2);
        d2.setName("SAC");
        d2.setCapacity(2);

        Department d3=new Department();
        d3.setDept_id(3);
        d3.setName("Health and care");
        d3.setCapacity(5);

        Department d4=new Department();
        d4.setDept_id(4);
        d4.setName("Placement");
        d4.setCapacity(7);



        Employee e1=new Employee();
        e1.setEmployee_id(1);
        e1.setFirst_name("gopal");
        e1.setLast_name("gupta");
        e1.setEmail("gopal.gupta@iiitb.ac.in");
        e1.setTitle("MR");
        e1.setPhoto_path("xyz");
        e1.setDepartment(d1);

        Session session=factory.openSession();
        session.beginTransaction();
        session.save(d1);
        session.save(d2);
        session.save(d3);
        session.save(d4);

        session.save(e1);
        session.getTransaction().commit();
        session.close();


    }
}