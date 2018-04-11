package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private MovieService movieService;
	@Test
	public void save() {
		Movie movie = new Movie();
		movie.setName("黑豹");
		movie.setPrice(60d);
		movie.setActionTime(new Date());
		movieService.save(movie);
	}
	@Test
	public void findall(){
		for(Movie movie : movieService.findAll()){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}
	@Test
	public void findByParam(){
		for(Movie movie : movieService.findByParam("头")){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}
	@Test
	public void findBylike(){
		for(Movie movie : movieService.findByNameLike("%头%")){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}
	@Test
	public void findByNotLike(){
		for(Movie movie : movieService.findByNameNotLike("%头%")){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}
	@Test
	public void findByNameNotLikeAndPrice(){
		for(Movie movie : movieService.findByNameNotLikeAndPrice("%头%",80d)){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}
	@Test
	public void findByActionTimeBetween(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = new Date();
		Date endDate = new Date();
		try {
			beginDate = sdf.parse("2018-01-01");
			endDate = sdf.parse("2018-05-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for(Movie movie : movieService.findByActionTimeBetween(beginDate,endDate)){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}
	@Test
	public void findById(){
		Optional<Movie> movie = movieService.findById(1);
		System.out.println(movie.get().getName());
	}
	@Test
	public void delete(){
		movieService.deleteById(3);
	}

}
