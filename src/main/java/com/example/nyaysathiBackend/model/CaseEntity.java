package com.example.nyaysathiBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cases")
public class CaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String jurisdiction;
    private String status;
    private String nextHearing;
    private Long ownerId;
    private Long lawyerId;

    public CaseEntity() {}
    public Long getId(){ return id; }
    public String getTitle(){ return title; }
    public void setTitle(String t){ title=t; }
    public String getDescription(){ return description; }
    public void setDescription(String d){ description=d; }
    public String getJurisdiction(){ return jurisdiction; }
    public void setJurisdiction(String j){ jurisdiction=j; }
    public String getStatus(){ return status; }
    public void setStatus(String s){ status=s; }
    public String getNextHearing(){ return nextHearing; }
    public void setNextHearing(String n){ nextHearing=n; }
    public Long getOwnerId(){ return ownerId; }
    public void setOwnerId(Long o){ ownerId=o; }
    public Long getLawyerId(){ return lawyerId; }
    public void setLawyerId(Long l){ lawyerId=l; }
}
