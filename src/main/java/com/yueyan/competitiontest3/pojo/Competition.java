package com.yueyan.competitiontest3.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * 竞赛实体
 */
@Entity
@Table
public class Competition {
    /**
     * 数据库Id
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    /**
     * 年度
     */
    private String year;

    /**
     * 赛事名称
     */
    private String name;

    /**
     * 主办单位
     */
    private String organizer;

    /**
     * 所属专业
     */
    private String major;

    /**
     * 赛事的描述
     */
    private String description;


    //region

    public void setYear(String year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getMajor() {
        return major;
    }

    public String getDescription() {
        return description;
    }

    //endregion
}
