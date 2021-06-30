package org.factoriaf5.legacygames.services;

import org.factoriaf5.legacygames.models.Game;
import org.factoriaf5.legacygames.models.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public List<Game> allGames() {
        List<Game> allGames = (List<Game>) gameRepository.findAll();
        return allGames;
    }

    public void save(Game game) {
        gameRepository.save(game);
    }

    public Game findById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);
    }

    public List<Game> searchByName(String word) {
        return gameRepository.findGamesByTitleContaining(word);
    }
}
