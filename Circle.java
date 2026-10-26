
package project;

public class Circle extends Shape {

            private double radius;
            public Circle(){
            }
            
            public Circle(double radius ) {
               setRadius(radius);
            }
            
            public Circle(double radius, String color) {
                super(color);
             setRadius(radius);
            }


            public double getRadius() {
                return radius;
            }

            public void setRadius(double radius) {
             if (radius <= 0) {
                   throw new IllegalArgumentException("Radius must be positive");
               } 
             else {
                   this.radius = radius;
               }
         }


            @Override
                public double getArea() {
                   return Math.PI *radius * radius; 
                }
                
            @Override
                public  double getPerimeter(){
                    return (2*Math.PI*radius);
                }

            @Override

                public String toString(){
                 return "circle with radius " +radius;
               }
            @Override
                 public String howToDraw() {
                     
                 return "Draw a circle with radius " + radius;
               }

}