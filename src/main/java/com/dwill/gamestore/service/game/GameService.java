package com.dwill.gamestore.service.game;

import com.dwill.gamestore.exception.GameNotFoundException;
import com.dwill.gamestore.model.game.Game;
import com.dwill.gamestore.repository.game.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepo gameRepo;

    @Autowired
    public GameService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public List<Game> showAllGames() {
        return gameRepo.findGamesByOrderByRatingAsc();
    }

    public List<Game> SearchGamesByYear(int year) {
        return gameRepo.findGamesByYearOrderByRatingAsc(year);
    }

    public Game addGame(Game game) {
        return gameRepo.save(game);
    }

    public List<Game> SearchGamesByName(String name) {
        return gameRepo.findGameByNameOrderByRatingAsc(name);
    }

    public List<Game> SearchGamesByGenre(String genre) {
        return gameRepo.findGameByGenreOrderByRatingAsc(genre);
    }

    public void deleteGameByName(String name) {
        gameRepo.deleteGameByName(name);
    }

    public void deleteOlderGames(int year) {
        gameRepo.deleteGamesByYearBefore(year);
    }
    public void deleteGameByID(Long id)
    {
        gameRepo.deleteById(id);
    }

    public Game findGame(Long id) {
        return gameRepo.findById(id).orElseThrow(() -> new GameNotFoundException("Game of " + id + "not found"));
    }
}

