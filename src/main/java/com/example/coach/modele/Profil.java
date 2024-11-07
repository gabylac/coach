package com.example.coach.modele;

import android.content.Context;

import java.io.Serializable;

public class Profil implements Serializable {

    //constantes
    private static final Integer minFemme= 15; //maigre si en desosus
    private static final Integer maxFemme= 30; //gros si au dessus
    private static final Integer minHomme= 10; //maigre si en dessous
    private static final Integer maxHomme= 25; //gros si au dessus

    //propriétés
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    float img = 0;
    String message = "";

    /**
     * constructeur qui valorise les propriétés
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    /**
     * retourne IMG après calcul en fonction des infos et si img = 0 au départ
     * @return IMG
     */
    public float getImg() {
        if (img == 0){
            float tailleM= ((float)taille)/100;
            img= (float)((1.2*poids/(tailleM*tailleM))+(0.23*age)-(10.83*sexe)-5.4);
        }
        return img;
    }

    /**
     * retourne le message correspondant à l'img
     * @return "normal", "trop faible" ou "trop élevé"
     */
    public String getMessage() {
        if (message == ""){
            img = getImg();
            if (sexe == 0){
                if (img < minFemme){
                    message = "trop faible";
                }
                else {
                    if (img > maxFemme){
                        message = "trop élevé";
                    } else {
                        message = "normal";
                    }
                }
            } else {
                if (img < minHomme){
                    message = "trop faible";
                }
                else {
                    if (img > maxHomme){
                        message = "trop élevé";
                    } else {
                        message = "normal";
                    }
                }
            }
        }
        return message;
    }
}
