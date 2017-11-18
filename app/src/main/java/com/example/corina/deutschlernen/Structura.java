package com.example.corina.deutschlernen;

import java.util.ArrayList;

/**
 * Created by Corina on 03.06.2017.
 */

public class Structura {
    private String structuraGermana;
    private String traducere;
    private String forma;
    private String listacuvinteAsemanatoare;
    private String listaAlteStructuriAsemanatoare;
    private TipStructura tipStructura;

    public Structura(){}

    public Structura(String structuraGermana, String traducere, TipStructura tipStructura){
        this.structuraGermana = structuraGermana;
        this.traducere = traducere;
        this.tipStructura = tipStructura;
    }

    public Structura(String structuraGermana, String forma, String traducere, String listacuvinteAsemanatoare, String listaAlteStructuriAsemanatoare, TipStructura tipStructura) {
        this.structuraGermana = structuraGermana;
        this.forma = forma;
        this.traducere = traducere;
        this.listacuvinteAsemanatoare = listacuvinteAsemanatoare;
        this.listaAlteStructuriAsemanatoare = listaAlteStructuriAsemanatoare;
        this.tipStructura = tipStructura;
    }

    public String getStructuraGermana() {
        return structuraGermana;
    }

    public String getTraducere() {
        return traducere;
    }

    public String getForma() {
        return forma;
    }

    public String getListacuvinteAsemanatoare() {
        return listacuvinteAsemanatoare;
    }

    public String getListaAlteStructuriAsemanatoare() {
        return listaAlteStructuriAsemanatoare;
    }

    public String getTipStructuraString() {
        return tipStructura.toString();
    }


    public TipStructura getTipStructura() {
        return tipStructura;
    }

    public void setStructuraGermana(String structuraGermana) {
        this.structuraGermana = structuraGermana;
    }

    public void setTraducere(String traducere) {
        this.traducere = traducere;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setListacuvinteAsemanatoare(String listacuvinteAsemanatoare) {
        this.listacuvinteAsemanatoare = listacuvinteAsemanatoare;
    }

    public void setListaAlteStructuriAsemanatoare(String listaAlteStructuriAsemanatoare) {
        this.listaAlteStructuriAsemanatoare = listaAlteStructuriAsemanatoare;
    }

    public void setTipStructura(TipStructura tipStructura) {
        this.tipStructura = tipStructura;
    }
}
