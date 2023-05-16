package com.codeline.Olympics.Olympics_API.Repository;

import com.codeline.Olympics.Olympics_API.Model.AthleteInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<AthleteInformation, Integer> {

    @Query("SELECT a from AthleteInformation a where a.id= :athleteId")
    AthleteInformation getAthleteByAthleteId(@Param("athleteId") Integer id);

    @Query("SELECT a from AthleteInformation a where a.name= :name")
    AthleteInformation getAthleteByAthleteName(@Param("name") String name);

    @Query("SELECT a from AthleteInformation a")
    List<AthleteInformation> getAllAthletes();


}
