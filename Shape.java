package project;

import java.util.Date;

public abstract class Shape implements Drawable  {
    
        private Date dateCreated;
        private String color;

        public Shape() {
            
          dateCreated = new Date();
          color = "BLUE";
        }

        public Shape(String color) {
             this();
            this.color = color;
            
        }


        public Date getDateCreated() {
            return dateCreated;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
        
        
        public abstract double getArea();
           
        public abstract double getPerimeter();
    
    
}

