/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.dao;

import br.cesjf.hotellucena.model.Itens;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.cesjf.hotellucena.util.PersistenceUtil;

/**
 *
 * @author bibim
 */
public class ItemDAO {
    public static ItemDAO itemDAO;

    public static ItemDAO getInstance() {
        if (itemDAO == null) {
            itemDAO = new ItemDAO();
        }
        return itemDAO;
    }

    public Itens buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Itens a where a.nomeItem =:nome ");
        query.setParameter("nome", nome);

        List<Itens> itens = query.getResultList();
        if (itens != null && itens.size() > 0) {
            return itens.get(0);
        }

        return null;
    }

    public List<Itens> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Itens As i");
        return query.getResultList();
    }
    

    public void remover(Itens item) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(item)) {
            item = em.merge(item);
        }
        em.remove(item);
        em.getTransaction().commit();
    }

    public Itens persistir(Itens item) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            item = em.merge(item);
            em.getTransaction().commit();
            System.out.println("Registro Item gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from Itens ");
        query.executeUpdate();
        em.getTransaction().commit();
    }
    
    /*public Double soma() {
        Double soma = new Double(0);
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select sum(i.valorItem) soma from itens i where i.codigoReserva = codigoReserva");
        return soma;
    }*/
    
}
