package com.devsuperior.dslist.respositories;

import com.devsuperior.dslist.entities.GameList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> { //consulta com o banco, JpaRepository | acessa os dados
}
