import java.util.Arrays;

class Triangle {
    private double[] sides = new double[3];

    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.sides[0] = side1;
        this.sides[1] = side2;
        this.sides[2] = side2;

        Arrays.sort(this.sides);
        if( this.sides[0]<=0) {
            throw new TriangleException("Illegal args");
        }
    }

    boolean isEquilateral() {
        return this.sides[0] == this.sides[1] && this.sides[1] == this.sides[2];
    }

    boolean isIsosceles() {
        return this.isEquilateral() ||
                ( this.sides[2] == this.sides[1] && this.sides[2] != this.sides[0] ) ||
                ( this.sides[1] == this.sides[0] && this.sides[1] != this.sides[2] ) ||
                ( this.sides[0] == this.sides[2] && this.sides[0] != this.sides[1] );
    }

    boolean isScalene() {
        return !this.isEquilateral() && !this.isIsosceles();
    }

}
