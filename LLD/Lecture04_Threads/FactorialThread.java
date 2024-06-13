package Lecture04_Threads;

import java.math.BigInteger;

public class FactorialThread extends Thread{
    int n;
    BigInteger ans;
    FactorialThread(int n){
        this.n = n;
    }
    public void factorial(int n){
        ans = BigInteger.ONE;

        for(int i=1;i<=n;i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        System.out.println(ans);
    }

    @Override
    public void run() {
        factorial(n);
    }

    public BigInteger getAnswer(){
        return ans;
    }
}
