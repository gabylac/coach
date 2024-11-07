package com.example.coach.controleur;


import android.content.Context;

import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

public final class Controle {

    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";

    private Controle(Context context) {
        recupSerialize(context);
    }

    /**
     * création de l'insytnce unique de la classe
     * @return instance unique
     */
    public static final Controle getInstance(Context context){
        if (Controle.instance == null){
            Controle.instance = new Controle(context);
        }
        return Controle.instance;
    }

    /**
     * création d'un profil avec les infos reçues
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     * @param context
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context context){
        profil = new Profil (poids, taille, age, sexe);
        Serializer.serialize(nomFic, profil, context);
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

    private static void recupSerialize(Context context){
        profil = (Profil)(Serializer.deSerialize(nomFic, context));
    }

    public Integer getPoids(){
        if (profil == null){
            return null;
        }else{
            return profil.getPoids();
        }
    }

    public Integer getTaille(){
        if (profil == null){
            return null;
        }else{
            return profil.getTaille();
        }
    }

    public Integer getAge(){
        if (profil == null){
            return null;
        }else{
            return profil.getAge();
        }
    }

    public Integer getSexe(){
        if (profil == null){
            return null;
        }else{
            return profil.getSexe();
        }
    }

}
