//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sqa.main.MovieService;

public class MovieServiceStud implements MovieService{
	@Override
	public Map<String, List<String>> getMovieByUsername(String username){
		Map<String, List<String>> data = new HashMap<>();
        data.put("datenight", List.of(
                "The Notebook", "50 First Dates", "A Walk to Remember", "First Love", "The Lucky One"));
        data.put("horror", List.of(
                "The Pope's Exorcist", "Home for Rent", "Incantation", "Qorin", "The Invitation"));
        data.put("action", List.of(
                "Nobody 2", "Thunderbolts", "Novocaine", "Argylle","The Fall Guy"));
        data.put("mixed",List.of(
        		"Nobody 2","The Notebook","Home for Rent","Novocaine"));
        return data;
	}
}
