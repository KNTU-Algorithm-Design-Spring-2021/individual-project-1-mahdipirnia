import java.util.*;

public class project1
{          
    public static double[] find_maxmin(double[] array, int L, int U) {
        double[] Result = new double[2];
        double min, Max, Maxtemp1, mintemp1, Maxtemp2, mintemp2;
        int mid;
        if (L==U) {
            min = array[L];
            Max = array[L];
        }
        else {
            mid = (L + U) / 2;
            double[] Result1 = find_maxmin( array, L, mid);    
            double[] Result2 = find_maxmin( array, mid+1, U);
            Maxtemp1 = Result1[0];
            mintemp1 = Result1[1];
            Maxtemp2=Result2[0];
            mintemp2=Result2[1];
            if (Maxtemp1 < Maxtemp2) Max = Maxtemp2;
            else Max=Maxtemp1;
            if (mintemp1 < mintemp2) min = mintemp1;
            else min=mintemp2;
        }
        Result[0] = Max;
        Result[1] = min;
        return Result;
    }

    public static void main(String[] args)
    {

        int n;
        Scanner input = new Scanner(System.in); 
        System.out.println("enter n :");
        n=input.nextInt();
        double[] x=new double[n];
        double[] y=new double[n];
        for(int i=0; i<n; i++){
        System.out.println("enter x["+i+"]:");
          x[i] = input.nextDouble();
          System.out.println("enter y["+i+"]:");
          y[i] = input.nextDouble();
        }
        x=find_maxmin(x,0,n-1);
        y=find_maxmin(y,0,n-1);
        System.out.println("minimum rectangle nodes are:");
        System.out.println("(" + x[1] + ", " + y[0]+")");
        System.out.println("(" + x[0] + ", " + y[0]+")");
        System.out.println("(" + x[0] + ", " + y[1]+")");
        System.out.println("(" + x[1] + ", " + y[1]+")");
    }
}