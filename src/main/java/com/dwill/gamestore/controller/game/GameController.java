package com.dwill.gamestore.controller.game;

import com.dwill.gamestore.model.game.Game;
import com.dwill.gamestore.service.game.GameService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/all")
    public ResponseEntity<List<Game>> showAllGames() {
        List<Game> game = gameService.showAllGames();
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("/all/year/{year}")
    public ResponseEntity<List<Game>> searchByYear(@PathVariable("year") int year) {
        List<Game> game = gameService.SearchGamesByYear(year);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("/all/name/{name}")
    public ResponseEntity<List<Game>> searchByName(@PathVariable("name") String name) {
        List<Game> game = gameService.SearchGamesByName(name);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("/all/genre/{genre}")
    public ResponseEntity<List<Game>> searchByGenre(@PathVariable("genre") String genre) {
        List<Game> game = gameService.SearchGamesByGenre(genre);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }


}
