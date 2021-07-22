package com.dwill.gamestore.controller.user;

import com.dwill.gamestore.model.game.Game;
import com.dwill.gamestore.service.game.GameService;
import com.dwill.gamestore.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final GameService gameService;

    @PutMapping("/buy/{UID}/{GID}")
    public ResponseEntity<Game> purchaseGame(@PathVariable("UID") Long UID, @PathVariable("GID") Long GID) {
        userService.purchaseGame(UID, GID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

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