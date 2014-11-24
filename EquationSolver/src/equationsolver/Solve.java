/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakibul Mowla
 * Department of Computer Science and Engineering - 20th Batch
 * Shahjalal University of Science and Technology
 */

package equationsolver;

import static java.lang.Math.abs;

/**
 * This class solves the System of Linear Algebraic Equations
 * @author Sakibul
 */

public class Solve {
    public static double tmp[];
    public static double ans[];
    public static double eps = 0.0000001;
    
    /**
     * This method generates the answer of
     * System of Linear Algebraic Equations
     * from the Triangular Matrix
     */
    
    void substitute(){
        ans = new double[getMatrix.unknown+5];
        int i, j, n;
        n = getMatrix.unknown;
        double sum;

        ans[n] = getMatrix.con[n]/getMatrix.mat[n][n];

        for(i=n-1;i>=1;i--){
            sum = 0;
            for(j=i+1;j<=n;j++)
                sum += getMatrix.mat[i][j] * ans[j];
            ans[i] = (getMatrix.con[i] - sum) / getMatrix.mat[i][i];
        }
    }
    
    /**
     * This method implements the pivot choosing part of
     * Gaussian Elimination for getting better matrix to solve
     * @param k pivot to be interchanged
     */
    
    void pivot(int k){
        int i, j, p, n;
        n = getMatrix.unknown;
        double big, dummy;

        p = k;
        big = abs(getMatrix.mat[k][k]/tmp[k]);

        for(i=k+1;i<=n;i++){
            dummy = abs(getMatrix.mat[i][k]/tmp[i]);
            if(dummy > big){
                big = dummy;
                p = i;
            }
        }

        if(p != k){
            for(j=k;j<=n;j++){
                dummy = getMatrix.mat[p][j];
                getMatrix.mat[p][j] = getMatrix.mat[k][j];
                getMatrix.mat[k][j] = dummy;
            }
            dummy = getMatrix.con[p];
            getMatrix.con[p] = getMatrix.con[k];
            getMatrix.con[k] = dummy;
            dummy = tmp[p];
            tmp[p] = tmp[k];
            tmp[k] = dummy;
        }
    }
    
    /**
     * This method decides whether the system can be solved 
     * or not
     * @return -1 if the System can't be solved and 1 otherwise
     */
    
    int eliminate(){
        int i, j, k, n;
        n = getMatrix.unknown;
        double factor;

        for(k=1;k<=n-1;k++){
            pivot(k);
            if(abs(getMatrix.mat[k][k]/tmp[k]) < eps)
                return -1;
            for(i=k+1;i<=n;i++){
                factor = getMatrix.mat[i][k]/getMatrix.mat[k][k];
                for(j=k+1;j<=n;j++)
                    getMatrix.mat[i][j] = getMatrix.mat[i][j] - (factor*getMatrix.mat[k][j]);
                getMatrix.con[i] = getMatrix.con[i] - factor*getMatrix.con[k];
            }
        }

        if(abs(getMatrix.mat[n][n]/tmp[n]) < eps) return -1;
        return 1;
    }
    
    /**
     * This method decides whether the System can be solver or not
     * @return True if the System is solved and False otherwise
     */
    
    boolean solver(){
        tmp = new double[getMatrix.unknown+5];
        int i, j, n, er;
        n = getMatrix.unknown;
        
        for(i=1; i<=n; i++){
            tmp[i] = abs(getMatrix.mat[i][1]);
            for(j=2; j<=n; j++)
                if(abs(getMatrix.mat[i][j]) > tmp[i])
                    tmp[i] = abs(getMatrix.mat[i][j]);
        }
        
        er = eliminate();
        
        if(er != -1)
            substitute();
        
        return (er != -1);
    }
}
