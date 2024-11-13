package com.yueyan.competitiontest3;

import com.yueyan.competitiontest3.Service.CompetitionService;
import com.yueyan.competitiontest3.pojo.Competition;
import org.hamcrest.comparator.ComparatorMatcherBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CompetitionTest3ApplicationTests {

    @Autowired
    CompetitionService competitionService;
    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        Competition competition = new Competition();
        competition.setYear("2024");
        competition.setName("编程大赛");
        competition.setOrganizer("某科技公司");
        competition.setMajor("计算机科学与技术");
        competition.setDescription("一场精彩的编程比赛");

        competitionService.addCompetition(competition);
    }
    @Test
    public void test1(){
       List<Competition> competitionList= competitionService.FindByYear("2024");
       if(competitionList.size()>0){
           for(Competition competition:competitionList){
               System.out.println(competition);
           }
       }
       else {
           System.out.println("未查询到结果");
       }
    }
    @Test
    public void test2(){
        List<Competition> competitionList= competitionService.FindByYear1("2024");
        if(competitionList.size()>0){
            for(Competition competition:competitionList){
                System.out.println(competition);
            }
        }
        else {
            System.out.println("未查询到结果");
        }
    }
    @Test
    public void test3(){
        Competition competition = competitionService.getCompetition("2024");
        System.out.println(competition);
    }
    @Test
    public void test4(){
        List<Competition> competitions=competitionService.getCompetitionsByYear("2024");
    }


}
