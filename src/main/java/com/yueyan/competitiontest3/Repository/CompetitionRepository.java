package com.yueyan.competitiontest3.Repository;

import com.yueyan.competitiontest3.Specification.CompetitionSpecification;
import com.yueyan.competitiontest3.pojo.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String>, JpaSpecificationExecutor<Competition> {

//    JPQL查询
    @Query("select c from Competition c where c.year= :year ")
    List<Competition> findByYear(@Param("year") String year);

//    原生SQL
    @Query(value = "select * from competition where year=?1",nativeQuery = true)
    List<Competition> findByYearNative(String year);

    List<Competition> findAll(CompetitionSpecification spec);
}
