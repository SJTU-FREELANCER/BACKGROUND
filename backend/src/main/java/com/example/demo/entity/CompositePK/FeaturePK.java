package com.example.demo.entity.CompositePK;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class FeaturePK implements Serializable{
    private int App_ID;
    private int Skill_ID;
    private String Certificate;
}
