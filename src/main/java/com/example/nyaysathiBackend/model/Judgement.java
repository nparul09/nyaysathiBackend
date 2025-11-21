package com.example.nyaysathiBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "judgements")
public class Judgement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long caseId;
    @Column(length = 255)
    private String username;
    private String text;
    private String date;

    public Judgement() {}
    public Long getId(){ return id; }
    public Long getCaseId(){ return caseId; }
    public void setCaseId(Long c){ caseId=c; }
    public String getText(){ return text; }
    public void setText(String t){ text=t; }
    public String getDate(){ return date; }
    public void setDate(String d){ date=d; }
}
