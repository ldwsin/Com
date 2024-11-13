package com.yueyan.competitiontest3.Service;

import com.yueyan.competitiontest3.Repository.CompetitionRepository;
import com.yueyan.competitiontest3.Specification.CompetitionSpecification;
import com.yueyan.competitiontest3.pojo.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionRepository competitionRepository;

    public void addCompetition(Competition competition) {
        competitionRepository.save(competition);
    }

    public int deleteCompetition(String id) {
        competitionRepository.deleteById(id);
        if(competitionRepository.existsById(id)) {
            return 1;
        }
        return 0;
    }


    //byyear查询
    public Competition getCompetition(String year) {
         List<Competition> competition=competitionRepository.findByYear(year);
         if (competition.size()>0) {
              competition.get(0).setName("上海mojer");
              competitionRepository.save(competition.get(0));
              return competition.get(0);
         }
         else
             return null;
    }

    //JPQL查询
    public List<Competition> FindByYear(String year) {
       return competitionRepository.findByYear(year);
    }

    //原生sql
    public List<Competition> FindByYear1(String year) {
        return competitionRepository.findByYearNative(year);
    }
    public List<Competition> getCompetitionsByYear(String year) {
        CompetitionSpecification spec = new CompetitionSpecification(year);
        System.out.println(1);
        return competitionRepository.findAll(spec);
    }
}
