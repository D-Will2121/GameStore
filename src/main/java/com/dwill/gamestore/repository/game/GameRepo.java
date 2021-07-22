package com.dwill.gamestore.repository.game;

import com.dwill.gamestore.model.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepo extends JpaRepository<Game, Long> {
    List<Game> findGamesByOrderByRatingAsc();
    List<Game> findGamesByYearOrderByRatingAsc(int year);
    List<Game> findGameByNameOrderByRatingAsc(String name);
    List<Game> findGameByGenreOrderByRatingAsc(String genre);
    void deleteGamesByYearBefore(int year);
    void deleteGameByName(String name);


}
