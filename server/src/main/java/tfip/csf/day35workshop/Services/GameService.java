package tfip.csf.day35workshop.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.csf.day35workshop.Models.Game;
import tfip.csf.day35workshop.Repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepo;

    public Optional<List<Game>> getGame(String name) {
        List<Game> games = gameRepo.getGame(name);
        if (games.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(games);
    }

}
