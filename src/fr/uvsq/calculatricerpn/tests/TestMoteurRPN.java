package fr.uvsq.calculatricerpn.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.calculatricerpn.main.*;
import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;


public class TestMoteurRPN {

    private MoteurRPN m;

    //Setter d'initialisation du moteur
    @Before
    public void setUp() {
        m=new MoteurRPN();
    }

    //Test si la pile est vide sans rien mettre dedans
    @Test
    public void testPileVide() throws BorneSupInfException{
        assertEquals(m.getPile().empty(),true);
    }

    //Test si la pile possède un élément en mettant un élément dedans
    @Test
    public void testPileRemplie() throws BorneSupInfException{
        m.enregistreOperande(2.0);
        assertEquals(m.getPile().empty(),false);
    }

    //Test si l'opérande est bien celle qu'on met dans la pile
    @Test
    public void testEnregistrerOperande() throws BorneSupInfException{
        m.enregistreOperande(2.0);
        assertEquals(m.getPile().pop()==2.0,true);
    }

    //Test si on peut ajouter un élément supérieur au max
    @Test (expected=BorneSupInfException.class)
    public void testEnregistrerOperandeMax() throws BorneSupInfException{
        m.enregistreOperande(10001.0);
    }

    //Test si on peut ajouter un élément inférieur au min
    @Test (expected=BorneSupInfException.class)
    public void testEnregistrerOperandeMin() throws BorneSupInfException{
        m.enregistreOperande(-10001.0);
    }

    //Test si l'opération PLUS fonctionne
    @Test
    public void testCalculerOperationPlus() throws BorneSupInfException, DivisionParZeroException{
        m.enregistreOperande(2.0);
        m.enregistreOperande(3.0);
        assertEquals(m.calculeOperation(Operation.PLUS)==5.0,true);
    }

    // Test si l'opération MOINS fonctionne
    @Test
    public void testCalculerOperationMoins() throws BorneSupInfException, DivisionParZeroException{
        m.enregistreOperande(3.0);
        m.enregistreOperande(1.0);
        boolean test=(m.calculeOperation(Operation.MOINS)==2.0);
        assertEquals(test,true);
    }

    //Teste si l'opération MULT fonctionne
    @Test
    public void testCalculerOperationMult() throws BorneSupInfException, DivisionParZeroException{
        m.enregistreOperande(3.0);
        m.enregistreOperande(2.0);
        assertEquals(m.calculeOperation(Operation.MULT)==6.0,true);
    }

    //Teste si l'opération DIV fonctionne
    @Test
    public void testCalculerOperationDiv() throws BorneSupInfException, DivisionParZeroException{
        m.enregistreOperande(3.0);
        m.enregistreOperande(2.0);
        boolean test=(m.calculeOperation(Operation.DIV)==1.5);
        assertEquals(test,true);
    }

    //Teste si l'opération DIV par 0 renvoie bien une erreur
    @Test(expected=DivisionParZeroException.class)
    public void testCalculerOperationDivParZero() throws BorneSupInfException, DivisionParZeroException{
        m.enregistreOperande(3.0);
        m.enregistreOperande(0);
        m.calculeOperation(Operation.DIV);
    }

    //Teste si l'opération est possible
    @Test
    public void testOperationPossibleTrue() throws BorneSupInfException{
        m.enregistreOperande(3.0);
        m.enregistreOperande(2.0);
        assertEquals(m.operationPossible(),true);
    }

    //Teste si l'opération est bien impossible sans élément
    @Test
    public void testOperationPossibleFalseAucunElem() throws BorneSupInfException{
        assertEquals(m.operationPossible(),false);
    }


    //Teste si l'opération est bien impossible avec 1 seul élément
    @Test
    public void testOperationPossibleFalseUnElem() throws BorneSupInfException{
        m.enregistreOperande(2.0);
        assertEquals(m.operationPossible(),false);
    }

}
