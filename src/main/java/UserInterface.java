/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vdmclcv
 */
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    
    private Scanner scanner;
    private PointsManager pointsManager;
    
    public UserInterface(Scanner scanner, PointsManager pointsManager) {
        this.scanner = scanner;
        this.pointsManager = pointsManager;
    }
    
    public void start() {
        System.out.println("Enter point totals, -1 stops: ");
        
        while (true) {
            int point = Integer.valueOf(this.scanner.nextLine());
            if (point == -1) {
                break;
            }
            if (point >= 0 && point <= 100) {
                pointsManager.addPoint(point);
            }
        }
        
        System.out.println("Point average (all): " + pointsManager.getAverage());
        System.out.println("Point average (passing): " + pointsManager.getPassingAverage(50));
        System.out.println("Pass percentage: " + pointsManager.getPassPercentage(50));
        
        System.out.println("Grade distribution:");
        
        pointsManager.calculateGrades();
        int[] grades = pointsManager.getGrades();
        
        for (int i = 5; i >= 0; i--) {
            int count = 0;
            String stars = "";
            while (count < grades[i]) {
                stars += "*";
                count++;
            }
            System.out.println(i + ": " + stars);
        }
    }
    
}
