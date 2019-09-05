import java.util.Arrays;

class Triangle {
    private boolean isIsosceles;
    private boolean isEquilateral;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        double[] sides = new double[3];
        sides[0] = side1;
        sides[1] = side2;
        sides[2] = side3;

        Arrays.sort(sides);
        if (sides[0] <= 0) {
            throw new TriangleException("One or more side is 0");
        } else if ((sides[0] + sides[1] < sides[2])) {
            throw new TriangleException("Doesn't pass the triangle inequality law");
        } else {
            this.isIsosceles = (sides[0] == sides[1] || sides[1] == sides[2]);
            this.isEquilateral = (sides[0] == sides[1] && sides[1] == sides[2]);
        }
    }

    boolean isEquilateral() {
        return this.isEquilateral;
    }

    boolean isIsosceles() {
        return this.isIsosceles;
    }

    boolean isScalene() {
        return !this.isIsosceles;
    }
}
