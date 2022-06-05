package com.spring.api.dao;

import com.spring.api.model.Player;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PlayerRepoImpl implements PlayerRepo{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Player> players() {
        Session session = entityManager.unwrap(Session.class);
       Query<Player> query =  session.createQuery("from Player order by name asc", Player.class);

        return query.getResultList();
    }

    @Override
    public Player getPlayer(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Player.class, id);

    }

    @Override
    public void addPlayer(Player player) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(player);
    }
}
