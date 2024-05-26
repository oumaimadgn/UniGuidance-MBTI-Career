package com.example.careermap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
import javax.persistence.OneToOne;
=======
>>>>>>> f962d6087840983d5858ed32adca6fff306f4c0f

@Entity
public class Resultat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resultat;

    @Column(name="date")
    private String date;

    @Column(name="personnalite")
    private String personnalite;

    @ManyToOne
    @JoinColumn(name = "matricule")
    private Utilisateur fk_utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_test")
    private Test fk_test;
<<<<<<< HEAD
    
    @OneToOne
    @JoinColumn(name = "id")
    private Jobs id;

    public Resultat() {
       
    }

	


	public Resultat(Long id_resultat, String date, String personnalite, Utilisateur fk_utilisateur, Test fk_test,
			Jobs id) {

		this.id_resultat = id_resultat;
		this.date = date;
		this.personnalite = personnalite;
		this.fk_utilisateur = fk_utilisateur;
		this.fk_test = fk_test;
		this.id = id;
	}




	public Jobs getId() {
		return id;
	}




	public void setId(Jobs id) {
		this.id = id;
	}




=======

    public Resultat() {
        // no-argument constructor
    }

	public Resultat(Long id_resultat, String date, String personnalite, Utilisateur utilisateur, Test test) {
		super();
		this.id_resultat = id_resultat;
		this.date = date;
		this.personnalite = personnalite;
		this.fk_utilisateur = utilisateur;
		this.fk_test = test;
	}


>>>>>>> f962d6087840983d5858ed32adca6fff306f4c0f
	public Long getId_resultat() {
		return id_resultat;
	}

	public void setId_resultat(Long id_resultat) {
		this.id_resultat = id_resultat;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPersonnalite() {
		return personnalite;
	}

	public void setPersonnalite(String personnalite) {
		this.personnalite = personnalite;
	}

	public Utilisateur getFk_utilisateur() {
		return fk_utilisateur;
	}

	public void setFk_utilisateur(Utilisateur fk_utilisateur) {
		this.fk_utilisateur = fk_utilisateur;
	}

	public Test getFk_test() {
		return fk_test;
	}

	public void setFk_test(Test fk_test) {
		this.fk_test = fk_test;
	}

}
