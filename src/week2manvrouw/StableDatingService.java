package week2manvrouw;

public class StableDatingService implements DatingService {
    @Override
    public int[] match(int[][] men, int[][] women) {
        int[] total = new int[men[0].length];
        int[] total_w = new int[men[0].length];
        for(int i=0; i<men[0].length; i++){
            total[i] = -1;
            total_w[i] = -1;

        }
        int i=0;
        int j=0;
        while(total[i]==-1){

            int choice_man = men[i][j];
            if(total_w[choice_man]==-1){
                total[i] = choice_man;
                total_w[choice_man]=i;
                int j_=i+1;
                while(j_<men[0].length && total[j_] != -1){
                    j_++;
                }
                if(j_==men[0].length){
                    return total;
                } else {
                    i=j_;
                    j=0;
                }
            } else {
                int competitor = total_w[choice_man];
                int j_=0;
                while(women[choice_man][j_]!=i && women[choice_man][j_] != competitor){
                    j_++;
                }
                if(women[choice_man][j_]==competitor){
                    j++;
                } else {
                    total[competitor] = -1;

                    total[i] = choice_man;
                    total_w[choice_man] = i;
                    j=0;
                    i=competitor;

                }
            }
        }

        return new int[0];
    }
}
