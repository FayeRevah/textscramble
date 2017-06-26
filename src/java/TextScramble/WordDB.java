/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextScramble;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Contains the functions needed to interface with the DB
 * @author West
 */
public class WordDB {

    public static Word selectUser(Integer id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT w FROM Word w "
                + "WHERE w.id = :id";
        TypedQuery<Word> q = em.createQuery(qString, Word.class);
        q.setParameter("id", id);
        try {
            Word word = q.getSingleResult();
            return word;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
