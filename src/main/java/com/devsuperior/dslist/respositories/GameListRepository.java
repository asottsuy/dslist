package com.devsuperior.dslist.respositories;

import com.devsuperior.dslist.entities.GameList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> { //consulta com o banco, JpaRepository | acessa os dados
    @Modifying //quando nao e o select se bota o modifuing
    @Query(nativeQuery = true, //consulta sql nativo com update
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
