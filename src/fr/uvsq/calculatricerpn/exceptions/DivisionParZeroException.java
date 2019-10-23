package fr.uvsq.calculatricerpn.exceptions;
/*
 * 1 : Exception pour la division par zero
 */
public class DivisionParZeroException extends Exception{

	
	/**
     * Initialise une instance de <code>DivisionParZeroException</code>.
     */
	public DivisionParZeroException() {
		super("<------!!!! Impossible de divisé par Zéro !!!!----->");
	}
	
}
