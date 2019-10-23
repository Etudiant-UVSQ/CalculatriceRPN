package fr.uvsq.calculatricerpn.main;


import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;

import java.util.Stack;


/*
 * MoteurRPN permet d'enregistrer une opérande, d'appliquer une opération sur les opérandes
 * et de retourner l'ensemble des opérandes stockées
 */

public class MoteurRPN {


    //Pile d'opérandes
    private Stack<Double> pile;


    //La plus petite valeur de la calculatrice quand ne peut pas depassé
    private static final double MIN_VALUE =0;


    //La plus grande valeur de la calculatrice quand ne peut pas depassé

    private static final double MAX_VALUE = 10000.0;


    //Initisalisation de la pile dans le constructeur

    public MoteurRPN() {
        pile = new Stack<Double>();
    }

    // 4-a : La Méthode qui permet d'enregistrer une opérande

    public Double enregistreOperande(double val)throws BorneSupInfException{
        if(Math.abs(val)>MAX_VALUE) throw new BorneSupInfException();
        if(Math.abs(val)<MIN_VALUE) throw new BorneSupInfException();
        return pile.push(val);
    }


    /*
     * 4-b : Méthode qui fait le calcul de l'opération entre  les deux opérandes
     * et stocke le résultat dans la pile
     */
    public Double calculeOperation(Operation op)throws DivisionParZeroException,BorneSupInfException{
        return enregistreOperande(op.eval(pile.pop(), pile.pop()));
    }


    /*
     * Methode qui permet de savoir si une operation est possible
     * Test si la pile a au moins deux éléments
     */
    public boolean operationPossible(){
        if(pile.size()>=2) return true;
        else return false;
    }

    /*
     * Une Méthode qui permet d'afficher l'intervalle de nombre
     * entre min_value et max_value dans la console
     */

    public String specifieMinMaxValue(){
        return "MIN_VALUE = " + MIN_VALUE + " et MAX_VALUE = " + MAX_VALUE + ".";
    }

    //4-c : La Méthode qui retourne l'ensemble des operandes stockées
    public String listeOperandes(){
        String string = "";
        for(Double val: pile){
            string += val + " ";
        }
        return string;
    }

    //Get de la pile du moteurRPN
    public Stack<Double> getPile() {
        return pile;
    }
}