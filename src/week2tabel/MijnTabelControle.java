package week2tabel;

public class MijnTabelControle implements TabelControle {
    @Override
    public boolean controleer(int[][] matrix, int x) {
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        if(matrix[row][col]<x){return false;}
        int c=col;
        int r=0;
        if(matrix[r][c]<x) {
            while (matrix[r][c] < x) {r++;}
        } else {
            while (matrix[r][c] > x) {c--;}
            if(c!=col){c++;}
        }
        while(c>0 && r<=row && matrix[r][c]!=x){
            if(c!=0 && r==row){c--;}
            else if(matrix[r+1][c]>x && (matrix[r+1][c]<matrix[r][c-1]||matrix[r][c-1]<x)){r++;} else{c--;}
        }
        if((c==0||r==row) && matrix[r][c]!=x){return false;} else{return true;}
    }
}
