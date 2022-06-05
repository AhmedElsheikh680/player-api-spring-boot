package com.spring.api.dao;

import com.spring.api.model.Player;

import java.util.List;

public interface PlayerRepo {

    public  List<Player> players();

    public Player getPlayer(int id);

}
