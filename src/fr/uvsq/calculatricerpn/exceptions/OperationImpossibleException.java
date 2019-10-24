package fr.uvsq.calculatricerpn.exceptions;
/*
 * 1 :Exception qui se declenche si la pile est vide
 */
public class OperationImpossibleException extends Exception{

	/**
     * Initialise une instance de <code>OperationImpossibleException</code>.
     */
	public OperationImpossibleException() {
		super("<------!!!! Opération Impossible !!!! Il y a moins de deux opérandes dans la pile");
	}
}
