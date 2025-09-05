//นายณธฬ จันทร์หอม 653380195-1 sec.2
import java.util.List;
import java.util.Map;

public class FavoriteMovie {
	private MovieService movieservice;

	public FavoriteMovie(MovieService movieservice) {
		super();
		this.movieservice = movieservice;
	}

	public List<String> getMoviesByPlaylist(String username, String playlistName) {
		Map<String, List<String>> allPlaylists = movieservice.getMovieByUsername(username);

		return allPlaylists.getOrDefault(playlistName, List.of());
	}

	private static final List<String> ACTION_MOVIES = 
			List.of("Nobody 2", "Thunderbolts", "Novocaine", "Argylle","The Fall Guy");

	public List<String> getActionMoviesByPlaylist(String username, String playlistName) {
		List<String> movies = getMoviesByPlaylist(username, playlistName);
		return movies.stream().filter(ACTION_MOVIES::contains).toList();
	}

}
