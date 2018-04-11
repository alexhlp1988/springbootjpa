package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//持久层:由JPA管理
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    //包含了一般的增删改查
    @Query(value = "from Movie where name like concat('%',:name,'%')")
    List<Movie> findByParam(@Param("name")String name);
}
