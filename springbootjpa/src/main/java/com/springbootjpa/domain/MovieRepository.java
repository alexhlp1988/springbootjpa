package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

//持久层:由JPA管理
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    //包含了一般的增删改查

    //hibernate query language:hibernate查询语言 - 类名 + 属性名
    @Query(value = "from Movie m where m.name like concat('%',:name,'%')")
    List<Movie> findByParam(@Param("name")String name);

    List<Movie> findByNameLike(String name);//模糊查询包含name的数据

    List<Movie> findByNameNotLike(String name);//模糊查询不包含name的数据

    List<Movie> findByNameNotLikeAndPrice(String name,Double price);

    List<Movie> findByActionTimeBetween(Date beginDate,Date endDate);

    @Query(value = "from Movie m where m.name=:name")
    List<Movie> findByName(@Param("name")String name);
}
