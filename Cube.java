package project;

public class Cube extends ThreeDShape {

    private double side;
     public Cube(){
         
     }

    public Cube(double side) {
        setSide(side);

    }

    public Cube(String color, double side) {
        super(color);
      setSide(side);

    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side <= 0)
            throw new IllegalArgumentException("Side must be positive");
        this.side = side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getPerimeter() {
        return 12 * side;
    }

    @Override
    public String howToDraw() {
        return "Draw a cube with side " + side;
    }

    @Override
    public String toString() {
        return "cube with side " + side;
    }
}
