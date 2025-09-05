//นายณธฬ จันทร์หอม 653380195-1 sec.2
import java.util.List;
import java.util.Map;

public interface MovieService {
	Map<String, List<String>> getMovieByUsername(String username);
}
