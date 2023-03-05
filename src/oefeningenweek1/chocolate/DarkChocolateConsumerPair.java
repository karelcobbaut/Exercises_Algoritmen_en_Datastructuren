package oefeningenweek1.chocolate;

public class DarkChocolateConsumerPair implements ChocolateConsumerPair {
    @Override
    public int consume(int[] bars) {
        int bobIndex = bars.length;
        if(bobIndex==0){
            return 0;
        }
        int aliceIndex = -1;

        int aliceTime = 0;
        int bobTime = 0;
        while(aliceIndex < bobIndex){

            if(aliceTime==0){
                aliceIndex++;
                aliceTime = bars[aliceIndex];
            }
            aliceTime--;
            if(bobTime==0) {
                bobIndex--;
                bobTime = bars[bobIndex];
            }
            bobTime--;
        }
        if(aliceIndex == bobIndex && aliceTime<=bobTime) {
            return aliceIndex + 1;
        } else {
            return aliceIndex;
        }
    }
}
