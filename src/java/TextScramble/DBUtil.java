package TextScramble;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TPP_Text_ScramblePU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}