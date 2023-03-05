package oefeningenweek1.omgekeerdegetallen;

public class MyReverseAddition implements ReverseAddition {
    @Override
    public int add(int a, int b) {
        int total = this.reverseInt(this.reverseInt(a)+this.reverseInt(b));
        return total;
    }
    public int reverseInt(int n){
        int total = 0;
        while(n>0){
            total*=0;
            total += n%10;
            n/=10;
        }
        return total;
    }
}
