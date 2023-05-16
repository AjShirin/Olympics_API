package com.codeline.Olympics.Olympics_API.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class ResultInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String athlete;
    String country;
    String time;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    EventInformation eventInformation;
}
