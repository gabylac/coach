package com.example.coach.controleur;

import com.example.coach.modele.Profil;

public final class Controle {

    private static Controle instance = null;
    private static Profil profil;

    private Controle() {
        super();
    }

    /**
     * création de l'insytnce unique de la classe
     * @return instance unique
     */
    public static final Controle getInstance(){
        if (Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * création d'un profil avec les infos reçues
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){
        profil = new Profil (poids, taille, age, sexe);
    }

    /**
     * getter sur résultat de l'img du profil
     * @return img du profil
     */
    public float getImg(){
        if (profil != null){
            return profil.getImg();
        }else {
            return 0;
        }
    }

    /**
     * getter sur message correspondant à l'img du profil
     * @return message du profil
     */
    public String getMessage(){
        if (profil != null){
            return profil.getMessage();
        }else {
            return "";
        }
    }

}
