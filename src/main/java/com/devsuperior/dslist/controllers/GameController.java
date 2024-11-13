package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games") //configurando o caminho
public class GameController {
    //o controller implementa a API
    @Autowired
    private GameService gameService; //controller injeta um service

    @GetMapping(value = "/{id}")
    public GameDTO findAll(@PathVariable Long id){ //para casar com o id recebido se bota no @PathVariable
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping //endpoint
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
