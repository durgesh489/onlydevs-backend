package com.durgesh.onlydevs.entities;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;


@Entity
@Table(name="experts")
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="expert_id")
    int expert_id;

    @Column(name="expert_name")
     @NotFound
    String expert_name;

    @Column(name="expert_email")
    @NotFound
    String expert_email;

    @Column(name="about")
    @NotNull
    String about;

    public int getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(int expert_id) {
        this.expert_id = expert_id;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

    public String getExpert_email() {
        return expert_email;
    }

    public void setExpert_email(String expert_email) {
        this.expert_email = expert_email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Expert(int expert_id, String expert_name, String expert_email, String about) {
        this.expert_id = expert_id;
        this.expert_name = expert_name;
        this.expert_email = expert_email;
        this.about = about;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "expert_id=" + expert_id +
                ", expert_name='" + expert_name + '\'' +
                ", expert_email='" + expert_email + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
