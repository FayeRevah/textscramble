//ScoreDB.java
//Gets 10 records from score table with highest score
//Author: Gregory Gonzalez, Team++
package TextScramble;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


public class ScoreDB {
    
    public static List<Score> selectScores() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //Gets score records from cst438 and orders them by score in descending order
        String qString = "SELECT s FROM Score s ORDER BY s.score DESC";
        //Limits the result set to the top 10
        TypedQuery<Score> q = em.createQuery(qString, Score.class).setMaxResults(10);        
        List<Score> scores;
        try {
            scores = q.getResultList();
            if (scores == null || scores.isEmpty()) {
                scores = null;
            }
        } finally {
            em.close();
        }
        return scores;             
    }
}
