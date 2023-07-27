package org.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
    @Query(value = "SELECT u FROM Organisation u WHERE u.name=:name")
    List<Organisation> findByName(@Param("name") String organisationName);
}
