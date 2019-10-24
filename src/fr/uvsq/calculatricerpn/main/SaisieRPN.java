package fr.uvsq.calculatricerpn.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;

public class SaisieRPN {

    Scanner sc = new Scanner(System.in);
    BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
    MoteurRPN moteur = new MoteurRPN();
    Operation operation;
    boolean stay=true,operateur=true;
    public void saisir() throws IOException, DivisionParZeroException, OperationImpossibleException {
        System.out.println("\n\t\t\t\t\t ******** Entrez au clavier (un nombre, un operateur ou exit) ********");
        String saisie = entree.readLine();


        for (Operation i:Operation.values()
             ) {
            if (saisie.toUpperCase().equals(i.name()) || saisie.equals(String.valueOf(i.symbole))){
                operateur=true;
                if (moteur.operandes.size()<2) throw new OperationImpossibleException();

                else {

                    moteur.operer(i);
                    moteur.getExpCourante();
                    moteur.getOperandes();

                }
                break;

            }
            operateur=false;


        }
        if (!operateur) {
            try {
                double x = Double.parseDouble(saisie);

                moteur.enregistrerOperande(x);
                moteur.getExpCourante();
                moteur.getOperandes();

            }catch (BorneSupInfException e){System.out.println(e.getMessage());}


             catch (NumberFormatException e) {
                if (saisie.toLowerCase().equals("exit")) {
                    System.out.println("\t\t\t\t\t  ******** Au revoir!!!  ********");
                    stay=false;
                } else {
                    System.out.println("\t\t\t\t\t  ******** Vous n'avez pas saisie une entrée valide!!! ********");
                    moteur.getExpCourante();
                    moteur.getOperandes();
                }
            }
        }




    }

}