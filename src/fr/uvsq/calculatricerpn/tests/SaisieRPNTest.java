package fr.uvsq.calculatricerpn.tests;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

import fr.uvsq.calculatricerpn.main.*;
import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;
import fr.uvsq.calculatricerpn.exceptions.OperationImpossibleException;



//Classe Test de SaisieRPN
public class SaisieRPNTest {

    private String data;
    private InputStream inputStream;
    private Scanner scanner;
    private SaisieRPN saisie;

    //Initialisation des paramètres identiques des différents tests
    void init(InputStream inputStream, String data, Scanner scanner)
            throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        inputStream=System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        scanner=new Scanner(System.in);
    }

    //Test pour la saisie de "4" puis "exit"
    @Test
    public void testSaisieUnElement() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        data="4\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisie();
        boolean test=(saisie.getMoteur().getPile().pop()==4.0);
        assertEquals(test,true);
    }

    //Test pour la saisie de "2", puis "3", puis "exit"
    @Test
    public void testSaisieDeuxElements() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        data="2\n3\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisie();
        boolean test=(saisie.getMoteur().getPile().pop()==3.0);
        assertEquals(test,true);
        test=(saisie.getMoteur().getPile().pop()==2.0);
        assertEquals(test,true);
    }

    //Test pour la saisie "2", "3", "+" puis "exit"
    @Test
    public void testSaisiePlus() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        data="2\n3\n+\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisie();
        boolean test=(saisie.getMoteur().getPile().pop()==5.0);
        assertEquals(test,true);
    }

    //Test pour la saisie de "2", "3", "-", "exit"
    @Test
    public void testSaisieMoins() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        data="2\n3\n-\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisie();
        boolean test=(saisie.getMoteur().getPile().pop()==-1.0);
        assertEquals(test,true);
    }

    //Test la saisie de "2", "3", "*", "exit"
    @Test
    public void testSaisieMult() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        data="2\n3\n*\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisie();
        boolean test=(saisie.getMoteur().getPile().pop()==6.0);
        assertEquals(test,true);
    }

    //Test la saisie de "3", "2", "/" et "exit"
    @Test
    public void testSaisieDiv() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        data="3\n2\n/\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisie();
        boolean test=(saisie.getMoteur().getPile().pop()==1.5);
        assertEquals(test,true);
    }

    //Test la saisie de "3", "0", "/", "exit"
    @Test (expected=DivisionParZeroException.class)
    public void testSaisieDivParZero() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        data="3\n0\n/\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisie();
    }

}