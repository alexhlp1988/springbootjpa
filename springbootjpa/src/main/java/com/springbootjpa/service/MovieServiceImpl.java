package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//业务逻辑接口的实现类
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    /**
     * 新增(无ID)或修改(有ID)
     * @param movie
     */
    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> findByParam(String name) {
        return movieRepository.findByParam(name);
    }


}
