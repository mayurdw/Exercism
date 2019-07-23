class Triangle {
    private double side1,side2,side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        if( this.areSidesValid(side1,side2,side3)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            throw new TriangleException("Illegal args");
        }
    }

    private boolean areSidesValid(double side1, double side2, double side3){
        return ( ( side1 != 0 && side2 != 0 && side3 != 0 ) &&
                ( side1 + side2 >= side3 ) &&
                ( side1 + side3 >= side2 ) &&
                ( side2 + side3 >= side1 ));
    }

    boolean isEquilateral() {
        return this.side1 == this.side2 && this.side3 == this.side2 && this.side3 == this.side1;
    }

    boolean isIsosceles() {
        return this.isEquilateral() ||
                ( this.side3 == this.side2 && this.side3 != this.side1 ) ||
                ( this.side2 == this.side1 && this.side2 != this.side3 ) ||
                ( this.side1 == this.side3 && this.side1 != this.side2 );
    }

    boolean isScalene() {
        return !this.isEquilateral() && !this.isIsosceles();
    }

}
