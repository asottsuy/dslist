package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.respositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //vai registrar o GameService como um componente do sistema
public class GameService {

    @Autowired
    private GameRepository gameRepository; //injetando uma instancia do gamerepository dentro do service

    @org.springframework.transaction.annotation.Transactional(readOnly = true) //para garantir a transacao com o banco de dados
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //chama o repository e busca todos os dados
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
