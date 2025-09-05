//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.main.FavoriteMovie;

class FavoriteMovieTest {

	private FavoriteMovie favoritemovie;
	
	@BeforeEach
	void setUp() throws Exception {
		favoritemovie = new FavoriteMovie(new MovieServiceStud());
	}

	@Test
	void testGetMovieFromDateNightPlaylist() {
		List<String> movielist = favoritemovie.getMoviesByPlaylist("username", "datenight");
		
		assertNotNull(movielist);
		assertEquals(5, movielist.size());
		assertTrue(movielist.contains("The Notebook"));
	}
	@Test
	void testGetMovieFromHorrorPlaylist() {
		List<String> movielist = favoritemovie.getMoviesByPlaylist("username", "horror");
		
		assertNotNull(movielist);
		assertEquals(5, movielist.size());
		assertTrue(movielist.contains("Home for Rent"));
	}
	@Test
	void testGetMovieFromActionPlaylist() {
		List<String> movielist = favoritemovie.getMoviesByPlaylist("username", "action");
		
		assertNotNull(movielist);
		assertEquals(5, movielist.size());
		assertTrue(movielist.contains("Nobody 2"));
	}
	@Test
	void testGetMovieFromMixedPlaylist() {
		List<String> movielist = favoritemovie.getMoviesByPlaylist("username", "mixed");
		
		assertNotNull(movielist);
		assertEquals(4, movielist.size());
	}
	@Test
    void testGetMoviesFromUnknownPlaylist() {
        List<String> movielist = favoritemovie.getMoviesByPlaylist("username", "comedy");
        //Expected result is return null
        assertNotNull(movielist);
        assertTrue(movielist.isEmpty());
    }
	//Test method getActionMoviesByPlaylist
    @Test
    void testGetActionMoviesFromActionPlaylist() {
        List<String> actionMovies = favoritemovie.getActionMoviesByPlaylist("username", "action");

        assertNotNull(actionMovies);
        assertEquals(5, actionMovies.size());
        assertTrue(actionMovies.contains("Nobody 2"));
        assertTrue(actionMovies.contains("The Fall Guy"));
    }

    @Test
    void testGetActionMoviesFromMixedPlaylist() {
        List<String> actionMovies = favoritemovie.getActionMoviesByPlaylist("username", "mixed");

        assertNotNull(actionMovies);
        assertEquals(2, actionMovies.size());
        assertTrue(actionMovies.contains("Nobody 2"));
        assertTrue(actionMovies.contains("Novocaine"));
    }

    @Test
    void testGetActionMoviesFromNonActionPlaylist() {
        List<String> actionMovies = favoritemovie.getActionMoviesByPlaylist("username", "datenight");

        assertNotNull(actionMovies);
        assertTrue(actionMovies.isEmpty());
    }

    @Test
    void testGetActionMoviesFromUnknownPlaylist() {
        List<String> actionMovies = favoritemovie.getActionMoviesByPlaylist("username", "comedy");

        assertNotNull(actionMovies);
        assertTrue(actionMovies.isEmpty());
    }
}
