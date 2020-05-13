package polynoms;

import java.util.Arrays;

public class Polynom {

    //data
    //5x3 + 3x2 + 6 6 0 3 5
    private double[] coef;

    //constructors
    //[6 0 3 5]
    //[5 3 0 6]
    //6,0,3,5
    //5,3,0,6
    private Polynom(double[] coef) {     //private proto aby objekt nikdo nevytvarel pres tenhle konstruktor ale aby objekt vytvarel pres tovarni metody
        double[] coefTemp = new double[coef.length];    //defenzivní kopie, aby byli privátní i hodnoty pole
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coefTemp;
    }

    //tovární metoda(static abychom ji mohli zavolat = Polynom. , jelikoz jeste zadny objekt nemame)
    public static Polynom getInstanceReverted(double[] coef) {   //[6 0 3 5]
        return new Polynom(coef);
    }

    public static Polynom getInstance(double... coef) {   //5 3 0 6
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coefTemp.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);
    }

    //metody
    //Hrnerovo schema vypocet hodnoty --- HOMEWORK
    //TODO
    //5x3 + 3x2 + 6 pre x=1 y=5+3+6=14 // prepsat vzorecek Hornerova schema do kodu - pouzit Hornerovo schema
    public double computeValue(double x) {  //pro getInstanceReverted
        double result = coef[coef.length - 1];
        for (int i = coef.length - 1; i > 0; i--) {
            result = result * x + coef[i - 1];
        }
        return result;
    }

    public double getCoefAt(int exponent) {
        return coef[exponent];
    }

    public double[] getAllCoef() {
        //    return coef; //timhle bychom mu poslali přímí přístup k poli
        return Arrays.copyOf(coef, coef.length);
    }

    public int getDegree() {
        return coef.length - 1;
    }

    //TODO
    //vypisovat to matematicky správně -> 5x^3 + 3x^2 + 6
    @Override
    public String toString() {
        String pol = "";
        if (coef[coef.length - 1] < 0) {
            pol = "-";
        }
        for (int i = coef.length - 1; i > 0; i--) {
            if (coef[i] != 0) {
                pol = pol + Math.abs(coef[i]) + "x^" + i;
                if (coef[i - 1] >= 0) {
                    pol += " + ";
                } else {
                    pol += " - ";
                }
            }
        }
            pol += Math.abs(coef[0]);

        return pol;
    }

    public Polynom derivate() {
        double[] coefD = new double[coef.length - 1]; //coef derivace je o jedno mensi
        for (int i = 0; i < coefD.length; i++) {
            coefD[i] = coef[i + 1] * (i + 1);
        }
        return new Polynom(coefD);
    }


