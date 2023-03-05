package week6shell;

import java.util.Arrays;

public class ShellSorteerder implements Sorteerder {
    int[] incrementReeks;
    Tabel tabel;
    int tabelSize;
    public ShellSorteerder(int[] incrementReeks) {
        this.incrementReeks = incrementReeks;
        Arrays.sort(incrementReeks);
    }
    public void sorteer(Tabel invoerTabel) {
        tabel = invoerTabel;
        tabelSize = invoerTabel.size();
        for(int i=incrementReeks.length-1;i>=0;i--){
            for(int j=0;j<incrementReeks[i];j++){
                doInsertionSort(incrementReeks[i],j);
            }
        }
    }
    public void doInsertionSort(int step, int j){
        for (int i = j; i < tabelSize-step; i += step) {
            if (tabel.get(i) > tabel.get(i + step)) {
                tabel.swap(i, i + step);
                for(int i_=i;i_-step>=j;i_-=step){
                    if(tabel.get(i_-step)>tabel.get(i_)) tabel.swap(i_,i_-step);
                    else break;
                }
            }
        }
    }
}
