package week4dominatie;

import java.util.*;

public class MyDomination implements Domination {
    @Override
    public Collection<Point> nonDominated(List<Point> points) {
        return recursiveNonDominated(points);
    }
    private ArrayList<Point> recursiveNonDominated(List<Point> points){
        int len = points.size();
        if(len==1) return new ArrayList<>(points);
        if(len==2) {
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            ArrayList<Point> newPoints = new ArrayList<>();
            if (p1.getX() == p2.getX()) {
                if (p1.getY() > p2.getY()) newPoints.add(p1);
                else newPoints.add(p2);
            } else {
                if (p1.getX() > p2.getX()) {
                    Point p3 = p1;
                    p1 = p2;
                    p2 = p3;
                }

                if (p2.getY() < p1.getY()) {
                    newPoints.add(p1);
                }
                newPoints.add(p2);

            }
            return newPoints;
        }
        int mid=len/2;

        ArrayList<Point> points1 = recursiveNonDominated(points.subList(0,mid));
        ArrayList<Point> points2 = recursiveNonDominated(points.subList(mid,len));

        ArrayList<Point> newPoints = new ArrayList<>();
        int maxY=-1;
        int i=points1.size()-1; int j=points2.size()-1;
        while(i>=0 && j>=0){
            Point p1 = points1.get(i);
            Point p2 = points2.get(j);

            if(p1.getX()<p2.getX()){

                if(p2.getY()>maxY) {
                    maxY = p2.getY();
                    newPoints.add(p2);

                }
                j--;

            } else if(p1.getX()>p2.getX()) {
                if(p1.getY()>maxY) {
                    maxY = p1.getY();
                    newPoints.add(p1);

                }
                i--;

            } else {
                if(p1.getY()>p2.getY() && p1.getY()>maxY){
                    newPoints.add(p1);
                    maxY=p1.getY();

                } if(p1.getY()<p2.getY() && p2.getY()>maxY) {
                    newPoints.add(p2);
                    maxY=p2.getY();
                }

                i--;
                j--;
            }
        }
        noDuplicateAnymore(maxY, i, points1, newPoints);
        noDuplicateAnymore(maxY, j, points2, newPoints);
        Collections.reverse(newPoints);
        return newPoints;
    }
    private void noDuplicateAnymore(int maxY, int i, ArrayList<Point> points, ArrayList<Point> newPoints){
        while(i>=0){
            Point p1 = points.get(i);
            if(p1.getY()>maxY){
                maxY=p1.getY();
                newPoints.add(p1);
            }
            i--;
        }
    }
    /*

     */



}
