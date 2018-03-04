package com.s2ee.etic.apps2ee;

import java.io.Serializable;

/**
 * Created by Abdallah on 10/02/2018.
 */

public class Entreprise implements Serializable{
    private String entreprisepic;
    private String entreprisenom,entreprisedescrition;

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
