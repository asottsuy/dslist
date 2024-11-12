package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.respositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //vai registrar o GameService como um componente do sistema
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository; //injetando uma instancia do gamerepository dentro do service

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll(); //chama o repository e busca todos os dados
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
