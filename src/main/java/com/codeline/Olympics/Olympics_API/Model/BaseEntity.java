package com.codeline.Olympics.Olympics_API.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@Getter
@Setter
@Data
@MappedSuperclass
public class BaseEntity {
    @CreationTimestamp // creates date and time automatically
    Date createDate;
    @UpdateTimestamp // updates date and time automatically
    Date updateDate;
    Boolean isActive;
}
