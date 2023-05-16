package com.codeline.Olympics.Olympics_API.Repository;

import com.codeline.Olympics.Olympics_API.Model.EventInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventInformation, Integer> {
    @Query("SELECT e from EventInformation e where e.id= :eventId")
    EventInformation getEventByEventId(@Param("eventId") Integer id);

    @Query("SELECT e from EventInformation e where e.eventName= :eventName")
    EventInformation getEventByEventName(@Param("eventName") String eventName);

    @Query("SELECT e from EventInformation e")
    List<EventInformation> getAllEvents();
}
