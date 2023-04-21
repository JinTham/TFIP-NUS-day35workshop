package tfip.csf.day35workshop.Repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import tfip.csf.day35workshop.Models.Comment;
import tfip.csf.day35workshop.Models.Game;

@Repository
public class GameRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_QUERY = "select g.gid, g.name, g.year, g.ranking, g.url, g.image, c.user, c.rating, c.c_text from game g left join comment c on g.gid = c.gid where g.name = ? order by rating desc limit 5";

    public List<Game> getGame(String name) {
        List<Comment> comments = new LinkedList<>();
        List<Game> games = new LinkedList<>();
        Game game = new Game();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_QUERY, name);
        while (rs.next()) {
            game.setGid((rs.getInt("gid")));
            game.setName(rs.getString("name"));
            game.setYear(rs.getInt("year"));
            game.setRanking(rs.getInt("ranking"));
            game.setUrl(rs.getString("image"));
            game.setImage(rs.getString("image"));
            Comment comment = new Comment();
            comment.setUser(rs.getString("user"));
            comment.setRating(rs.getInt("rating"));
            comment.setText(rs.getString("c_text"));
            comments.add(comment);
        }
        game.setComments(comments);
        games.add(game);
        return games;
    }

}
