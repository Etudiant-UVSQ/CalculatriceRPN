package fr.uvsq.calculatricerpn.main;

import java.util.Scanner;

import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;

/*
 * 5 : Classe qui gère les interactions avec lutilisateur et invoque le moteur RPN.
 */
public class SaisieRPN {

    //Attribut scanner qui permet de gerer les saisies
    private Scanner scanner;

    //Attribut  moteur qui permet d'enregistrer une opérande, d'appliquer une opération sur les opérandes .
    private MoteurRPN moteur;


    //Constructeur de Saisie qui initialise les attributs moteur et scanner
    public SaisieRPN() {
        this.scanner = new Scanner(System.in);
        this.moteur = new MoteurRPN();
    }

    // Cette méthode permet de gérer les saisies de l'utilisateur
    public void saisie() throws OperationImpossibleException,BorneSupInfException,DivisionParZeroException{
        String string = "";
        boolean arret = false;
        System.out.println("===> Veillez Saisir un nombre, un opération ou exit pour quitter la calculatrice.");
        while (arret == false) {

            if (scanner.hasNextDouble()) { // si la saisie est un nombre
                moteur.enregistreOperande(scanner.nextDouble()); // on met le nombre en haut de la pile
                System.out.println(moteur.listeOperandes()); // affichage opérande
                string = scanner.nextLine(); // lecture de la prochaine saisie
            }

            else { // si la saisie est une opération ou une chaine de caractère
                string = scanner.nextLine();
                if (this.testeOperation(string)) // si la saisie est une opération
                    if (moteur.operationPossible()) { // si la pile a au moins deux éléments
                        // enlève les deux premiers éléments, fait l'opération et met le résultat dans la pile
                        moteur.calculeOperation(renvoieOperation(string));
                        System.out.println(moteur.listeOperandes());
                    }
                    else throw new OperationImpossibleException(); // sinon si la pile n'a pas au moins deux éléments
                    // si la saisie est "exit", on arréte le programme
                else if (string.equals("exit")) {
                    arret = true;
                    System.out.println("<--------- END --------->");
                }


            }
        }
    }

    //Méthode permet de savoir si une chaine de caractère correspond à PLUS, MOINS, MULT, DIV
    public boolean testeOperation(String string) {
        if (string.length() != 1)
            return false;

        return renvoieOperation(string) != null;
    }

    //Méthode qui renvoie l'opération
    public Operation renvoieOperation(String string) {
        for (Operation op : Operation.values())
            if (string.charAt(0) == op.getSymbole())
                return op;
        return null;

    }

    // Get de l'attribut moteur
    public MoteurRPN getMoteur() {
        return this.moteur;
    }







}