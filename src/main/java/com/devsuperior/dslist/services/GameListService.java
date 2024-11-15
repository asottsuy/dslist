package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.respositories.GameListRepository;
import com.devsuperior.dslist.respositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //vai registrar o GameService como um componente do sistema
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository; //injetando uma instancia do gamerepository dentro do service

    @Autowired
    private GameRepository gameRepository;

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll(); //chama o repository e busca todos os dados
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move (Long listId, int sourceIndex,int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId); //resgata a lista do banco

        GameMinProjection obj = list.remove(sourceIndex); //removi o source index
        list.add(destinationIndex, obj); //injetei na posicao destinada

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
