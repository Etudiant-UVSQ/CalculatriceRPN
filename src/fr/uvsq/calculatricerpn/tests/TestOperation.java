package fr.uvsq.calculatricerpn.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import fr.uvsq.calculatricerpn.main.Operation;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;



//Classe de test TestOperation fait des testes sur les différentes methodes de l'Operation

public class TestOperation {
	
	private Operation op;
	
	//Test de la constante Plus de la classe Operation
	@Test
	public void testPlus() throws DivisionParZeroException {
		op = Operation.PLUS;
		assertEquals(op.eval(2,3)==5.0,true);
	}
	
	//Test de la constante Moins de la classe Operation
	@Test
	public void testMoins() throws DivisionParZeroException {
		op= Operation.MOINS;
		assertEquals(op.eval(2,3)==1.0,true);
	}
	
	//Test de la constante Mult de la classe Operation
	@Test
	public void testMult() throws DivisionParZeroException {
		op= Operation.MULT;
		assertEquals(op.eval(2,3)==6.0,true);
	}
	
	//Test de la constante Div de la classe Operation
	@Test
	public void testDiv() throws DivisionParZeroException {
		op= Operation.DIV;
		assertEquals(op.eval(2,3)==1.5,true);
	}
	
	//Ce test effectue l'operation de division par 0 et doit retourner une exception
	@Test(expected=DivisionParZeroException.class)
	public void testDivParZero() throws DivisionParZeroException {
		op= Operation.DIV;
		op.eval(0,3);
	}	
}

