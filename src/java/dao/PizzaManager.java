
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Pizza;

@Stateless
public class PizzaManager {
    
    @PersistenceContext
    EntityManager em;
    
    public void add(Pizza pizza){
        em.persist(pizza);
    }
    public List<Pizza> getAllPizzas(){
        Query q = em.createQuery("SELECT p FROM Pizza p");
        return q.getResultList();
    }

 
}
