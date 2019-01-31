package com.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.Weather;


public interface WeatherRepository extends JpaRepository<Weather, Long>  {
	
	@Query("select a from Weather a where a.createdate >= :creationDateTime AND a.siteid = :siteid")
	    List<Weather> findAllWithCreationDateTimeAfter(
	    		@Param("creationDateTime") Date creationDateTime, 
	    		@Param("siteid") String siteid);
	 
		
}
