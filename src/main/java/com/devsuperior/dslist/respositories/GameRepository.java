package com.devsuperior.dslist.respositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> { //consulta com o banco, JpaRepository | acessa os dados
}
