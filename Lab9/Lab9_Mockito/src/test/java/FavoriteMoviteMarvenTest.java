//นายณธฬ จันทร์หอม 653380195-1 sec.2
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FavoriteMoviteMarvenTest {

	@Test
    void testGetMoviesByPlaylist() {
        MovieService movieService = Mockito.mock(MovieService.class);
        when(movieService.getMovieByUsername("username"))
                .thenReturn(Map.of(
                        "playlist1", List.of("Nobody 2", "Frozen", "Novocaine"),
                        "playlist2", List.of("Thunderbolts", "The Fall Guy")
                ));
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieService);
        List<String> movies = favoriteMovie.getMoviesByPlaylist("username", "playlist1");
        assertEquals(List.of("Nobody 2", "Frozen", "Novocaine"), movies);
        verify(movieService, times(1)).getMovieByUsername("username");
    }

    @Test
    void testGetActionMoviesByPlaylist() {
        MovieService movieService = Mockito.mock(MovieService.class);
        when(movieService.getMovieByUsername("username"))
                .thenReturn(Map.of(
                        "playlist1", List.of("Nobody 2", "Frozen", "Thunderbolts", "Moana")
                ));
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieService);
        List<String> actionMovies = favoriteMovie.getActionMoviesByPlaylist("username", "playlist1");
        assertEquals(List.of("Nobody 2", "Thunderbolts"), actionMovies);
        verify(movieService, times(1)).getMovieByUsername("username");
    }
}
