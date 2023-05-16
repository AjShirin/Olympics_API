package com.codeline.Olympics.Olympics_API.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class MedalStanding extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String country;
    Integer goldMedal;
    Integer silverMedal;
    Integer bronzeMedal;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    EventInformation eventInformation;




}
