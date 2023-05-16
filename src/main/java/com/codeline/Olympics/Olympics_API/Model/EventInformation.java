package com.codeline.Olympics.Olympics_API.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class EventInformation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String eventName;
    String sport;
    String schedule;

    Integer numberOfAthletes;

    @ManyToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    AthleteInformation athleteInformation;


}
