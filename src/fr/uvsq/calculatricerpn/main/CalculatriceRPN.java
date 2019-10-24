<<<<<<< HEAD
package fr.uvsq.calculatricerpn.main;

import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;

import java.io.IOException;

public enum CalculatriceRPN {
	CALCULATRICE;


	public static void run (String args[]) throws IOException  {

		SaisieRPN saisi = new SaisieRPN();
		while (saisi.stay) {
			try {
				saisi.saisir();
			} catch (DivisionParZeroException e) {
				System.out.println(e.getMessage());
			}
			catch (OperationImpossibleException e){
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		CALCULATRICE.run(args);
	}

=======
package fr.uvsq.calculatricerpn;

import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;

/*
 * 6 : Classe enume qui contient le programme principal (Main)
 */
public enum CalculatriceRPN {
	CALCULATRICE;
	
	public void run(String[] args) {

		try {
			SaisieRPN saisie = new SaisieRPN();
			saisie.saisie();
		}
		
		// Exception correspondant au problème de pile
		catch(OperationImpossibleException e) { 
			System.out.println(e.getMessage());		
		}
		
		// Exeption correspondant aux bornes des valeurs
		catch(BorneSupInfException e) {
			SaisieRPN LimiteBorne=new SaisieRPN();
			//affiche le msg d'erreur Opérande non située entre les bornes de la calculatrice : MIN_VALUE = -10000.0 et MAX_VALUE = 10000.0.
			System.out.println(e.getMessage() + LimiteBorne.getMoteur().specifieMinMaxValue() + "!!!!----->");
		}
		
		// Exception correspondant A la division par zéro
		catch(DivisionParZeroException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		CALCULATRICE.run(args);
	}
>>>>>>> f288123e6ecb78f533a0cf002f36e620784db395
}
