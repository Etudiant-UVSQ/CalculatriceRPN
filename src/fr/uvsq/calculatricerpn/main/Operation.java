package fr.uvsq.calculatricerpn;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;


/*
 * Classe d'enumeration Operation qui permet de definir les differentes operations des operandes.
 */
public enum Operation {
	
	/*
	 * 3-d :  Constante qui definit l'operation + (ADDITION)
	 */
	PLUS('+') { 

		/*
		 * 3-e : Methode de l'evaluation pour l'addition
		 */
		public double eval(double op1, double op2) {
			return op1 + op2;
		}
	},
	

	/*
	 * 3-d :Constante qui definit l'operation - (SOUSTRACTION)
	 */
	MOINS('-') {
		
		/*
		 * 3-e : Methode de l'evaluation pour la soustraction
		 */
		public double eval(double op1, double op2) {
			return op2 - op1;
		}
	},
	
	
	/*
	 * 3-d :Constante qui definit l'operation * (MULTIPLICATION)
	 */
	MULT('*') {
		
		/*
		 * 3-e : Methode de l'evaluation pour la multiplication
		 */
		public double eval(double op1, double op2) {
			return op1 * op2;
		}
	},
	
	
	/*
	 * 3-d :Constante qui definit l'operation / (DIVISION)
	 */
	DIV('/') {
		
		/*
		 * 3-e : Methode de l'evaluation pour la division
		 */
		public double eval(double op1, double op2) throws DivisionParZeroException{
			if(op1==0) throw new DivisionParZeroException();
			return op2 / op1;
		}
	};
	
	
	/*
	 * 3-a : Attribut Symbole representant l'operateur 
	 */
	private char symbole;
	

	/*
	 * 3-b : Constructeur privee de l'enumeration de l'operation
	 */
	private Operation(char symbole) {
		this.symbole=symbole;
	}
	
	/*
	 * 3-c : La methode eval qui retourne retournant le resultat 
	 * de l'evaluation de l'operation sur deux operandes.
	 */
	public abstract double eval(double op1, double op2)throws DivisionParZeroException;
	
	
	public char getSymbole() {
		return symbole;
	}
}

