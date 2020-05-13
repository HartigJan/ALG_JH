package polynoms;

public class Polynoms {
    
    private Polynoms(){ 
    
    }
    
    public static Polynom sum(Polynom a, Polynom b){
        boolean isBigger = a.getDegree() > b.getDegree();
        Polynom max = isBigger ? a : b;     //Math.max(a.getDegree(),b.getDegree())
        Polynom min = isBigger ? b : a;
        
        double[] sumCoef = new double[max.getDegree()+1];
        //6 0 3 5
        //1 3 6
        //-------
        //7 3 9 5
        for (int i = 0; i < max.getDegree()+1; i++) {
            sumCoef[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree()+1; i++) {
            sumCoef[i] = sumCoef[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sumCoef);
    }
    
    //TODO
    //součin
    public static Polynom multiply(Polynom a, Polynom b){   
        int lenA = a.getDegree();
        int lenB = b.getDegree();
       
        double[] A = a.getAllCoef();
        double[] B = b.getAllCoef();
        double[] multi = new double[lenA + lenB +1];
        for (int i = 0; i < multi.length; i++) {
            multi[i] = 0;               
        }
        for (int i = 0; i < lenA+1; i++) {
            for (int j = 0; j < lenB+1; j++) {
                multi[i+j] += A[i]*B[j] ;
            }
        }
        
        return Polynom.getInstanceReverted(multi);
    }
}