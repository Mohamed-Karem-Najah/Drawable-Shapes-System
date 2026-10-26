package project;
import java.awt.BorderLayout;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Project {

    public static void main(String[] args) {

        try {
            List<Drawable> shapes = readShapes("input.txt");
            double sum = calculateSumAreas(shapes);
            writeSum(sum, "SumAreas.txt");
            showGUI(shapes, sum);

            } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

        private static List<Drawable> readShapes(String fileName) throws Exception {
            Scanner in = new Scanner(new File(fileName));
//            if(!in.hasNextInt())
//            throw new Exception("Invalid input: first value must be an integer");
            int size = in.nextInt();
            if (size < 2)
              throw new Exception("Number of shapes must be at least 2");
              List<Drawable> list = new ArrayList<>();
            for (int i = 0; i < size && in.hasNext(); i++) {
              if (!in.hasNext())
                throw new Exception("Number of entered shapes are less than the entered size of array");

                String type = in.next().toLowerCase();
                if (!in.hasNextDouble()) {
                 System.out.println(
                "Invalid value for shape at index " + (i + 1) +
                " (expected a number)"
                    );
                   in.next();
                   continue;
        }
                 if (!in.hasNextDouble()){

                throw new Exception("Invalid value for " + type + ": expected a numeric value");
              
                 }
                double value = in.nextDouble();

             try {
            switch (type) {
                case "circle":
                    list.add(new Circle(value));
                    break;

                case "cube":
                    list.add(new Cube(value));
                    break;

                default:
                    System.out.println(
                        "Unknown shape type at index " + (i + 1) +    ": " + type );
            }
        } 
            catch (IllegalArgumentException e) 
            {
            System.out.println(
                "Invalid value for " + type + " at index " + (i + 1) + " → " + e.getMessage());
            }
        }
            
            in.close();
            return list;
        }
        private static double calculateSumAreas(List<Drawable> shapes) {

            double sum = 0;
            for (Drawable d : shapes)
                sum += ((Shape) d).getArea();

            return sum;
            }
            private static void writeSum(double sum, String fileName) throws IOException {

                PrintWriter out = new PrintWriter(fileName);
                out.println("Sum Of Areas = " + sum);
                out.close();
            }

        private static void showGUI(List<Drawable> shapes, double sum) {

            SwingUtilities.invokeLater(() -> {

                JFrame frame = new JFrame("Shapes Viewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                DrawPanel panel = new DrawPanel(shapes.toArray(new Drawable[0]));
                JScrollPane scrollPane = new JScrollPane(panel);
                scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.add(new JLabel(
                        "Shapes: " + shapes.size() +
                        " | Total Areas = " + String.format("%.2f", sum)),
                        java.awt.BorderLayout.NORTH);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
            );
      }
}
