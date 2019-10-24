package fr.uvsq.calculatricerpn.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import fr.uvsq.calculatricerpn.main.Operation;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;



//Classe de test OperationTest fait des testes sur les différentes methodes de l'Operation

public class OperationTest {
	
	private Operation op;
	

	@Test
	public void testConstantePlusClassOperation() throws DivisionParZeroException {
		op = Operation.PLUS;
		assertEquals(op.eval(2,3)==5.0,true);
	}
	

	@Test
	public void testConstanteMoinsClassOperation() throws DivisionParZeroException {
		op= Operation.MOINS;
		assertEquals(op.eval(2,3)==1.0,true);
	}
	

	@Test
	public void testConstanteMultClassOperation() throws DivisionParZeroException {
		op= Operation.MULT;
		assertEquals(op.eval(2,3)==6.0,true);
	}
	
	
	@Test
	public void testConstanteDivClassOperation() throws DivisionParZeroException {
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

