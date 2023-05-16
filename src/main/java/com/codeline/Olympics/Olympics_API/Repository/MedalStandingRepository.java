package com.codeline.Olympics.Olympics_API.Repository;

import com.codeline.Olympics.Olympics_API.Model.MedalStanding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalStandingRepository extends JpaRepository<MedalStanding, Integer> {
    @Query("SELECT m from MedalStanding m where m.id= :medalId")
    MedalStanding getStandingsByMedalId(@Param("medalId") Integer id);

    @Query("SELECT m from MedalStanding m where m.country= :country")
    MedalStanding getMedalStandingByCountry(@Param("country") String country);
}
