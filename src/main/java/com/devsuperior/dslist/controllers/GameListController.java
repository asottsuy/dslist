package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists") //configurando o caminho
public class GameListController {
    //o controller implementa a API
    @Autowired
    private GameListService gameListService; //controller injeta um service

    @Autowired
    private GameService gameService;

    @GetMapping //endpoint
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games") //endpoint
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement") //endpoint
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body ){ //mapeia o json para o objeto
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex() );
    }


}
