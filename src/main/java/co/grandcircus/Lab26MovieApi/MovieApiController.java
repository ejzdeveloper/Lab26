package co.grandcircus.Lab26MovieApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MovieApiController {

	@Autowired
	private MovieDao dao;

	// 1. GET All /movies/ID
	// 2. GET /movies?category=...
	@GetMapping("/movies")
	public List<Movie> listMovies(@RequestParam(value = "category", required = false) String category) {
		if (category == null || category.isEmpty()) {
			return dao.findAll();
		} else {
			return dao.findByCategoryContainsIgnoreCase(category);
		}
	}
	
	
	// 3. GET random
	@GetMapping("/random")
	   public Movie randomMovie(){
	       List<Movie> movieList = dao.findAll();
	       Movie randMovie = new Movie();
	       Collections.shuffle(movieList);
	       randMovie.setTitle(movieList.get(0).getTitle());
	       randMovie.setId(movieList.get(0).getId());
	       randMovie.setCategory(movieList.get(0).getCategory());
	       return randMovie;
	   }
	
	
	// 4. GET /randomCategory
		@GetMapping("randomCategory/{category}")
		   public Movie randomCategory(@PathVariable("category")String category){
		       List<Movie> movieList = dao.findByCategoryContainsIgnoreCase(category);
		       Movie randMovie = new Movie();
		       Collections.shuffle(movieList);
		       randMovie.setTitle(movieList.get(0).getTitle());
		       randMovie.setId(movieList.get(0).getId());
		       randMovie.setCategory(category);
		       return randMovie;
		   }
	

	// 5. GET movies/random-list
	@GetMapping("/movies/random-list/{quantity}")
	   public List<Movie> randomMovieList(@PathVariable("quantity")Integer quantity){
	       List<Movie> movieList = dao.findAll();
	       List<Movie> randMovies = new ArrayList<Movie>();
	       Collections.shuffle(movieList);
	       for(int i = 0; i < quantity; i++) {
	           randMovies.add(movieList.get(i));
	       }
	       return randMovies;
	   }
	
	  // 6. GET /categories
	  @GetMapping("/categories") 
	  public List<String> getCategory(){ 
		  return dao.findByCategory(); 
	}
	 
	
	  // 7. GET /movies/ID
	  @GetMapping("/movies/{id}") 
	  public Movie getMovie(@PathVariable("id")Long id){ 
		  return dao.findById(id).get(); 
		  }
	
	// 8. get by keword
		  @GetMapping("/movie/{keyword}") 
		  public List<Movie> getByKeyword(@PathVariable("keyword")String keyword){ 
			  return dao.findByKeyword(keyword);
		}
}// end class
