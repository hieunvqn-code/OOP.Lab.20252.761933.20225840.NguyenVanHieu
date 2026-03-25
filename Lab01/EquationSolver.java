import javax.swing.JOptionPane;

public class EquationSolver {

    public static void main(String[] args) {
        String[] options = {"Linear (1 var)", "Linear System (2 vars)", "Quadratic (1 var)"};
        int choice = JOptionPane.showOptionDialog(null, "Choose the type of equation to solve:",
                "Equation Solver", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0 -> solveLinearEquation();
            case 1 -> solveLinearSystem();
            case 2 -> solveQuadraticEquation();
            default -> System.exit(0);
        }
    }

    // 1. Giải phương trình bậc nhất: ax + b = 0
    private static void solveLinearEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a (a != 0):"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

        if (a == 0) {
            JOptionPane.showMessageDialog(null, (b == 0) ? "Infinite solutions" : "No solution");
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Solution: x = " + x);
        }
    }

    // 2. Giải hệ phương trình bậc nhất 2 ẩn (Sử dụng định thức Cramer)
    private static void solveLinearSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Solution: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions");
            } else {
                JOptionPane.showMessageDialog(null, "No solution");
            }
        }
    }

    // 3. Giải phương trình bậc hai: ax^2 + bx + c = 0
    private static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a (a != 0):"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        if (a == 0) {
            // Quay về giải phương trình bậc nhất bx + c = 0
            if (b == 0) {
                JOptionPane.showMessageDialog(null, (c == 0) ? "Infinite solutions" : "No solution");
            } else {
                JOptionPane.showMessageDialog(null, "Linear solution: x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Two roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Double root: x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "No real root");
            }
        }
    }
}