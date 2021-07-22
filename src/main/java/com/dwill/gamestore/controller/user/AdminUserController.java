package com.dwill.gamestore.controller.user;

import com.dwill.gamestore.model.game.Game;
import com.dwill.gamestore.service.game.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users/admins")
@AllArgsConstructor
public class AdminUserController {

    private final GameService gameService;


    @PostMapping("/games/add")
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        Game newGame = gameService.addGame(game);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

    @DeleteMapping("/games/delete/name/{name}")
    public ResponseEntity<?> deleteGameName(@PathVariable("name") String name) {
        gameService.deleteGameByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/games/delete/year/{year}")
    public ResponseEntity<?> deleteGameYear(@PathVariable("year") int year) {
        gameService.deleteOlderGames(year);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/games/delete/id/{id}")
    public ResponseEntity<?> deleteGameID(@PathVariable("id") Long id) {
        gameService.deleteGameByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
