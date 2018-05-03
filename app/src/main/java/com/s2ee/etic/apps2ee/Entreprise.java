package com.s2ee.etic.apps2ee;

import java.io.Serializable;

/**
 * Created by Abdallah on 10/02/2018.
 */

public class Entreprise implements Serializable{
    private String entreprisepic;
    private String entreprisenom,entreprisedescrition;
    private String Mail;
    private String adresse;
    private String nbposte;
    private String nbstage;
    private String profilrechercher;
    private String profilvise;
    private String stagepropose;
    private String tel;
    private String postPrps;

    public String getPostPrps() {
        return postPrps;
    }

    public void setPostPrps(String postPrps) {
        this.postPrps = postPrps;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Entreprise(String entreprisepic, String entreprisenom, String entreprisedescrition, String mail, String adresse, String nbposte, String nbstage, String profilrechercher, String profilvise, String stagepropose, String tel, String website) {

        this.entreprisepic = entreprisepic;
        this.entreprisenom = entreprisenom;
        this.entreprisedescrition = entreprisedescrition;
        Mail = mail;
        this.adresse = adresse;
        this.nbposte = nbposte;
        this.nbstage = nbstage;
        this.profilrechercher = profilrechercher;
        this.profilvise = profilvise;
        this.stagepropose = stagepropose;
        this.tel = tel;
        this.website = website;
    }

    private String website;

    public Entreprise(String entreprisepic, String entreprisenom, String entreprisedescrition, String mail, String adresse, String nbposte, String nbstage, String profilrechercher, String profilvise, String stagepropose, String tel) {
        this.entreprisepic = entreprisepic;
        this.entreprisenom = entreprisenom;
        this.entreprisedescrition = entreprisedescrition;
        Mail = mail;
        this.adresse = adresse;
        this.nbposte = nbposte;
        this.nbstage = nbstage;
        this.profilrechercher = profilrechercher;
        this.profilvise = profilvise;
        this.stagepropose = stagepropose;
        this.tel = tel;
    }

    public String getMail() {

        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNbposte() {
        return nbposte;
    }

    public void setNbposte(String nbposte) {
        this.nbposte = nbposte;
    }

    public String getNbstage() {
        return nbstage;
    }

    public void setNbstage(String nbstage) {
        this.nbstage = nbstage;
    }

    public String getProfilrechercher() {
        return profilrechercher;
    }

    public void setProfilrechercher(String profilrechercher) {
        this.profilrechercher = profilrechercher;
    }

    public String getProfilvise() {
        return profilvise;
    }

    public void setProfilvise(String profilvise) {
        this.profilvise = profilvise;
    }

    public String getStagepropose() {
        return stagepropose;
    }

    public void setStagepropose(String stagepropose) {
        this.stagepropose = stagepropose;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Entreprise() {
    }



    public Entreprise(String entreprisepic, String entreprisenom, String entreprisedescrition) {
        this.entreprisepic = entreprisepic;
        this.entreprisenom = entreprisenom;
        this.entreprisedescrition = entreprisedescrition;
    }

    public String getEntreprisepic() {
        return entreprisepic;
    }

    public void setEntreprisepic(String entreprisepic) {
        this.entreprisepic = entreprisepic;
    }

    public String getEntreprisenom() {
        return entreprisenom;
    }

    public void setEntreprisenom(String entreprisenom) {
        this.entreprisenom = entreprisenom;
    }

    public String getEntreprisedescrition() {
        return entreprisedescrition;
    }

    public void setEntreprisedescrition(String entreprisedescrition) {
        this.entreprisedescrition = entreprisedescrition;
    }

}
