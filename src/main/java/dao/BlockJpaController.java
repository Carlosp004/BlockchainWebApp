
package dao;

import dto.Block;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Piero
 */
public class BlockJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public BlockJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // ✅ Método para insertar un nuevo bloque en la base de datos
    public void create(Block block) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            block.setTimestamp(new Date()); // Fecha actual
            em.persist(block);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // ✅ Método para listar todos los bloques
    public List<Block> findBlockEntities() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Block> query = em.createNamedQuery("Block.findAll", Block.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // ✅ Método para encontrar el último bloque (por ID descendente)
    public Block findLastBlock() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Block> query = em.createQuery("SELECT b FROM Block b ORDER BY b.id DESC", Block.class);
            query.setMaxResults(1);
            List<Block> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }
}
