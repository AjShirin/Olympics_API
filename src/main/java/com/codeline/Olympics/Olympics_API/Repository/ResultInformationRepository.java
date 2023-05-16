package com.codeline.Olympics.Olympics_API.Repository;

import com.codeline.Olympics.Olympics_API.Model.ResultInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultInformationRepository extends JpaRepository<ResultInformation, Integer> {
}
