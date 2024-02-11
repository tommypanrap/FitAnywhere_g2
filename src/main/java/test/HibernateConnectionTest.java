package test;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;

// 
// 執行"Run as Java Application", 如果運作成功會顯示Hibernate Session開啟成功
public class HibernateConnectionTest {

    public static void main(String[] args) {
        // 加載 Hibernate 配置文件
        Configuration configuration = new Configuration().configure();
        
        // 建立 ServiceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
        
        // 建立 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Session session = null;
        try {
            // 嘗試開啟一個 session
            session = sessionFactory.openSession();
            System.out.println("Hibernate session 開啟成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // 關閉 session
            }
        }
        
        sessionFactory.close(); // 清理後關閉 SessionFactory
    }
}


