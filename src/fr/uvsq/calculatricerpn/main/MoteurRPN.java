package fr.uvsq.calculatricerpn.main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import fr.uvsq.calculatricerpn.exceptions.BorneSupInfException;
import fr.uvsq.calculatricerpn.exceptions.DivisionParZeroException;

public class MoteurRPN {

    Deque<Double> operandes = new ArrayDeque<>();
    Deque<String> expCourante = new ArrayDeque<>();

    //La plus petite valeur de la calculatrice quand ne peut pas depassé
    private static final double MIN_VALUE =-10000.0;


    //La plus grande valeur de la calculatrice quand ne peut pas depassé

    private static final double MAX_VALUE = 10000.0;

    public void enregistrerOperande(double x) throws BorneSupInfException {

        if(Math.abs(x)>MAX_VALUE) throw new BorneSupInfException();
        operandes.push(x);
        expCourante.push(String.valueOf(x));
    }

    public double operer (Operation op) throws DivisionParZeroException {
        Double resultat = -1.0;
        double op1,op2;
        op1=operandes.removeFirst();
        op2=operandes.removeFirst();
        try {
            
            
            resultat=op.eval(op1,op2);
            if (resultat.isInfinite()){
                operandes.push(op2);
                operandes.push(op1);
            }
            else
            {
                operandes.push(resultat);
                expCourante.push(String.valueOf(op.getSymbole()));
            }


        }catch (NoSuchElementException  e) {
            System.out.println("La pile est vide!! Vous de pouvez pas faire d'operation sans operandes");
        }
        catch (DivisionParZeroException e){
        	operandes.push(op2);
            operandes.push(op1);
            System.out.println(e.getMessage());
        }
       
        
        return resultat;
    }


    public Deque<String> getExpCourante() {

        System.out.println("\n Expression Courante: \n");
        for (Iterator<String> it = expCourante.descendingIterator(); it.hasNext(); ) {
            String i = it.next();

            System.out.print(i + ' ');
        }
        return expCourante;
    }

    public Deque<Double> getOperandes() {

        System.out.println("\n\n CONTENUE DE LA PILE des opérandes:\n");
        for (double i:operandes
             ) {

            System.out.println("\t" + i);
        }
        return operandes;
    }
    
    public boolean operationPossible(){
        if(operandes.size()>=2) return true;
        else return false;
    }

    public static double getMaxValue() {
        return MAX_VALUE;
    }

    public static double getMinValue() {
        return MIN_VALUE;
    }

}
