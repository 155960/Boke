package test;

import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=input.nextInt();
        }
        long p=23;
        long sum=0;
        for(int i=0;i<m;i++){
           p=p*(long)Math.pow(10,1)+3;
           sum+=p;
           sum%=10000007;
        }
        for(int i=1;i<=n;i++){
            sum+=a[i];
            sum%=10000007;
        }
        System.out.println(sum);
    }
}
