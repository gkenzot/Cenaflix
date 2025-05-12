package cenaflix;

import conexao.Conexao;
import forms.FormFilme;

/**
 *
 * @author Kenzo
 */
public class Cenaflix {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Conexao c = new Conexao();
        c.conectar();

        FormFilme frm = new FormFilme();
        frm.setVisible(true);

    }

}
