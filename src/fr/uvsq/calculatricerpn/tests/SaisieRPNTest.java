package fr.uvsq.calculatricerpn.tests;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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


    void init(InputStream inputStream, String data, Scanner scanner)throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException{
        inputStream=System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }


    @Test
    public void testSaisieUnElement() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException, IOException{
        data="2\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisir();
        assertEquals(saisie.getMoteur().getOperandes().pop()==2.0,true);
    }


    @Test
    public void testSaisieDeuxElements() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException, IOException{
        data="2\n 3\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisir();
        saisie.saisir();
        
        assertEquals(saisie.getMoteur().getOperandes().pop()==3.0,true);
        assertEquals(saisie.getMoteur().getOperandes().pop()==2.0,true);
    }
    

    @Test
    public void testSaisieTroisElements() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException, IOException{
        data="2\n3\n4\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisir();
        saisie.saisir();
        saisie.saisir();
        assertEquals(saisie.getMoteur().getOperandes().pop()==4.0,true);
        assertEquals(saisie.getMoteur().getOperandes().pop()==3.0,true);
        assertEquals(saisie.getMoteur().getOperandes().pop()==2.0,true);
    }


    @Test
    public void testSaisiePlus() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException, IOException{
        data="2\n3\n+\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisir();
        saisie.saisir();
        saisie.saisir();
        assertEquals(saisie.getMoteur().getOperandes().pop()==5.0,true);
    }


    @Test
    public void testSaisieMoins() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException, IOException{
        data="2\n3\n-\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisir();
        saisie.saisir();
        saisie.saisir();
        boolean test=(saisie.getMoteur().getOperandes().pop()==-1.0);
        assertEquals(test,true);
    }


    @Test
    public void testSaisieMult() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException, IOException{
        data="2\n3\n*\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisir();
        saisie.saisir();
        saisie.saisir();
        boolean test=(saisie.getMoteur().getOperandes().pop()==6.0);
        assertEquals(test,true);
    }


    @Test
    public void testSaisieDiv() throws DivisionParZeroException, BorneSupInfException, OperationImpossibleException, IOException{
        data="3\n2\n/\nexit";
        init(inputStream, data, scanner);

        saisie = new SaisieRPN();
        saisie.saisir();
        saisie.saisir();
        saisie.saisir();
        assertEquals(saisie.getMoteur().getOperandes().pop()==1.5,true);
    }


    

}