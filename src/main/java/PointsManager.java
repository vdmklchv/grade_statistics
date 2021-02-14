/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vdmclcv
 */
import java.util.ArrayList;
import java.util.Arrays;

public class PointsManager {

    private ArrayList<Integer> points;
    private int[] grades = {0, 0, 0, 0, 0, 0};

    public PointsManager() {
        this.points = new ArrayList<Integer>();
    }

    public void addPoint(int point) {
        this.points.add(point);
    }

    public double getAverage() {
        if (points.size() > 0) {
            int sum = 0;
            for (int point : points) {
                sum += point;
            }
            return 1.0 * sum / points.size();
        }
        return -1;
    }

    public double getPassingAverage(int passingGrade) {
        if (points.size() > 0) {
            int sum = 0;
            int count = 0;
            for (int point : points) {
                if (point >= passingGrade) {
                    sum += point;
                    count++;
                }
            }
            return 1.0 * sum / count;
        }
        return -1;
    }
    
    public double getPassPercentage(int passingGrade) {
        int passed = 0;
        int failed = 0;
        for (int point: points) {
            if (point >= passingGrade) {
                passed++;
            } else {
                failed++;
            }
        }
        
        return (1.0 * passed / points.size()) * 100;
    }
    
    public void calculateGrades() {
        for (int point: points) {
            if (point < 50) {
                grades[0] += 1;
            } else if (point < 60) {
                grades[1] += 1;
            } else if (point < 70) {
                grades[2] += 1;
            } else if (point < 80) {
                grades[3] += 1;
            } else if (point < 90) {
                grades[4] += 1;
            } else if (point < 100) {
                grades[5] += 1;
            }
        }
    }
    
    public int[] getGrades() {
        return this.grades;
    }
}
