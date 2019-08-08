package co.grandcircus.Lab26MovieApi;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MovieDao extends JpaRepository<Movie, Long> {
	
	List<Movie> findByCategoryContainsIgnoreCase(String category);
		
	  //6. all movies categories	
	  @Query(value = "SELECT DISTINCT category FROM movie", nativeQuery = true)
	  List<String> findByCategory();
	  
	  //8. keywords	
	  @Query(value = "SELECT * FROM movie WHERE title LIKE CONCAT('%',:keyword, '%')", nativeQuery = true)
	  List<Movie> findByKeyword(String keyword);
}
