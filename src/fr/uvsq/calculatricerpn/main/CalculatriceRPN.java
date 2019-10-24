
package fr.uvsq.calculatricerpn.main;

import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;

import java.io.IOException;

public enum CalculatriceRPN {
	CALCULATRICE;


	public static void run(String args[]) throws IOException {

		SaisieRPN saisi = new SaisieRPN();
		while (saisi.stay) {
			try {
				saisi.saisir();
			} catch (DivisionParZeroException e) {
				System.out.println(e.getMessage());
			} catch (OperationImpossibleException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		CALCULATRICE.run(args);
	}
}

