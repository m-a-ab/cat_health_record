package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
            name="getAllConditions",
            query="SELECT m FROM Condition AS m ORDER BY m.id DESC"
            )
})
@Table(name="conditions")
public class Condition {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="neko_id")
    private Integer neko_id;

    //, nullable =false 後で足す
    @Column(name="date")
    private Date date;

    @Column(name="food")
    private String food;

    @Column(name="food_other")
    private String food_other;

    @Column(name="water")
    private String water;

    @Column(name="water_other")
    private String water_other;

    @Column(name="pee")
    private String pee;

    @Column(name="pee_other")
    private String pee_other;

    @Column(name="poop")
    private String poop;

    @Column(name="poop_other")
    private String poop_other;


    @Column(name="vomit")
    private String vomit;

    @Column(name="vomit_other")
    private String vomit_other;

    @Column(name="exercise")
    private String exercise;

    @Column(name="exercise_other")
    private String exercise_other;

    @Column(name="etc")
    private String etc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNeko_id() {
        return neko_id;

    }

    public void setNeko_id(Integer neko_id) {
        this.neko_id=neko_id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date=date;
    }

    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food=food;
    }

    public String getFood_other() {
        return food_other;
    }

    public void setFood_other(String food_other) {
        this.food_other=food_other;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water=water;
    }

    public String getWater_other() {
        return water_other;
    }

    public void setWater_other(String water_other) {
        this.water_other=water_other;
    }

    public String getPee() {
        return pee;
    }
    public void setPee(String pee) {
        this.pee=pee;
    }

    public String getPee_other() {
        return pee_other;
    }

    public void setPee_other(String pee_other) {
        this.pee_other=pee_other;
    }

    public String getPoop() {
        return poop;
    }

    public void setPoop(String poop) {
        this.poop=poop;
    }
    public String getPoop_other() {
        return poop_other;
    }
    public void setPoop_other(String poop_other) {
        this.poop_other=poop_other;
    }


    public String getVomit() {
        return vomit;
    }

    public void setVomit(String vomit) {
        this.vomit=vomit;
    }

    public String getVomit_other() {
        return vomit_other;
    }
    public void setVomit_other(String vomit_other) {
        this.vomit_other=vomit_other;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise=exercise;
    }

    public String getExercise_other() {
        return exercise_other;
    }

    public void setExercise_other(String exercise_other) {
        this.exercise_other=exercise_other;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
    this.etc=etc;
    }


}
