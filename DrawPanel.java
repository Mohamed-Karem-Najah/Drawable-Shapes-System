    package project;
    import javax.swing.*;
    import java.awt.*;

    public class DrawPanel extends JPanel {

        private Drawable[] shapes;
        private static final double SCALE = 5.0;
        private static final int GAP = 100;

        public DrawPanel(Drawable[] shapes) {
            this.shapes = shapes;
            int panelWidth = shapes.length * 350;
        setPreferredSize(new Dimension(panelWidth, 600));
            setBackground(Color.WHITE);

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (shapes == null) return;

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int x = 50;
            int y = 200;

            for (Drawable d : shapes) {
                Shape s = (Shape) d;
                int usedWidth = 0;

                if (d instanceof Circle) {
                    usedWidth = drawCircle(g2, (Circle) d, x, y);
                }
                else if (d instanceof Cube) {
                    usedWidth = drawCube3D(g2, (Cube) d, x, y);
                }
                x += usedWidth + GAP;


                 System.out.println(d.toString());
                 System.out.println(d.howToDraw());
                 System.out.println(s.getDateCreated());
            }
        }
            private int drawCircle(Graphics2D g2, Circle c, int x, int y) {

                int r = (int) (c.getRadius() * SCALE);
                int d = r * 2;
            g2.setColor(getAWTColor(c.getColor()));
            //
            g2.fillOval(x, y - r, d, d);
            g2.setColor(Color.BLACK);
            //
            g2.drawOval(x, y - r, d, d);
            g2.drawString("Circle r = " + r, x, y + r + 20);
                return d; 
            }

            private int drawCube3D(Graphics2D g2, Cube c, int x, int y) {

                int s = (int) (c.getSide() * SCALE);
                int depth = s / 2;
            Color base = getAWTColor(c.getColor());
            g2.setColor(base);
            g2.fillRect(x, y, s, s);
            Polygon top = new Polygon();
            top.addPoint(x, y);
            top.addPoint(x + depth, y - depth);
            top.addPoint(x + s + depth, y - depth);
            top.addPoint(x + s, y);
            g2.setColor(base.brighter());
            g2.fillPolygon(top);
            g2.setColor(Color.BLACK);
            g2.drawRect(x, y, s, s);
            g2.drawPolygon(top);
            Polygon side = new Polygon();
            side.addPoint(x + s, y);
            side.addPoint(x + s + depth, y - depth);
            side.addPoint(x + s + depth, y + s - depth);
            side.addPoint(x + s, y + s);
            g2.setColor(base.darker());
            g2.fillPolygon(side);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(side);
            g2.drawRect(x + depth, y - depth, s, s);
            g2.drawLine(x + depth, y - depth, x, y);
            g2.drawLine(x + depth + s, y - depth, x + s, y);
            g2.drawLine(x + depth, y - depth + s, x, y + s);
            g2.drawLine(x + depth + s, y - depth + s, x + s, y + s);
            g2.drawString("Cube s = " + s, x, y + s + 25);
     //       g2.setColor(getAWTColor(c.getColor()));
    //        g2.drawRect(x, y, s, s);
    //        g2.drawRect(x + depth, y - depth, s, s);
    //        g2.drawLine(x, y, x + depth, y - depth);
    //        g2.drawLine(x + s, y, x + s + depth, y - depth);
    //        g2.drawLine(x, y + s, x + depth, y + s - depth);
    //        g2.drawLine(x + s, y + s, x + s + depth, y + s - depth);
    //        g2.drawString("Cube s = " + s, x, y + s + 25);
                return s + depth;

        }

        private Color getAWTColor(String colorName) {

        switch (colorName.toLowerCase()) {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            case "black": return Color.BLACK;
            case "yellow": return Color.YELLOW;
            case "orange": return Color.ORANGE;
            case "gray": return Color.GRAY;
            default: return Color.BLACK; 
        }
    }

     }
