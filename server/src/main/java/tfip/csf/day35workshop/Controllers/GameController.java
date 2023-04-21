package tfip.csf.day35workshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import tfip.csf.day35workshop.Models.Comment;
import tfip.csf.day35workshop.Models.Game;
import tfip.csf.day35workshop.Services.GameService;

@Controller
@RequestMapping
// @CrossOrigin(origins="*")
public class GameController {
    
    @Autowired
    private GameService gameSvc;

    @GetMapping(path="/api/game", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGame(@RequestParam String name) {
        Game game = gameSvc.getGame(name).get().get(0);
        JsonArrayBuilder jsonArrayB = Json.createArrayBuilder();
        for (Comment c : game.getComments()) {
            jsonArrayB.add(Json.createObjectBuilder()
                            .add("user",c.getUser())
                            .add("rating",c.getRating())
                            .add("text",c.getText())
                            .build());
        }
        JsonArray jsonArrayComments = jsonArrayB.build();                     
        JsonObject response = Json.createObjectBuilder()
                                .add("name",game.getName())
                                .add("year",game.getYear())
                                .add("ranking",game.getRanking())
                                .add("url",game.getUrl())
                                .add("image",game.getImage())
                                .add("comments",jsonArrayComments)
                                .build();
        return ResponseEntity.ok(response.toString());
    }

}
