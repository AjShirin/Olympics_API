package com.codeline.Olympics.Olympics_API.DTO;

import com.codeline.Olympics.Olympics_API.Model.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AthleteOlympicsDTO extends BaseEntity {
    String AthleteName;
    Boolean isActive;

    public AthleteOlympicsDTO(String athleteName, Boolean isActive) {
        AthleteName = athleteName;
        this.isActive = isActive;
    }
}
