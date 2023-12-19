import java.awt.*;

public abstract class Shape {
    protected int x;
    protected int y;
    protected Color color;
    protected int xSpeed;
    protected int ySpeed;

    public Shape(int x, int y, Color color, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public abstract void draw(Graphics g);

    public abstract void move(int panelWidth, int panelHeight);

    // Getters and setters if needed
}

class Circle extends Shape {
    private final int radius;
    public Circle(int x, int y, int radius, Color color, int xSpeed, int ySpeed) {
        super(x, y, color, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int diameter = radius * 2;
        g.fillOval(x - radius, y - radius, diameter, diameter);
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        x += xSpeed;
        y += ySpeed;
        handleWallCollision(panelWidth, panelHeight);
    }

    public void handleWallCollision(int panelWidth, int panelHeight) {
        if (x - radius <= 0 || x + radius >= panelWidth) {
            xSpeed = -xSpeed;
            x = Math.max(radius, Math.min(x, panelWidth - radius));
        }
        if (y - radius <= 0 || y + radius >= panelHeight) {
            ySpeed = -ySpeed;
            y = Math.max(radius, Math.min(y, panelHeight - radius));
        }
    }


    // Getters for radius
    public int getRadius() {
        return radius;
    }
}

class Square extends Shape {
    private final int sideLength;

    public Square(int x, int y, int sideLength, Color color, int xSpeed, int ySpeed) {
        super(x, y, color, xSpeed, ySpeed);
        this.sideLength = sideLength;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x - sideLength / 2, y - sideLength / 2, sideLength, sideLength);
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        x += xSpeed;
        y += ySpeed;
        handleWallCollision(panelWidth, panelHeight);
    }

    public void handleWallCollision(int panelWidth, int panelHeight) {
        int halfWidth = sideLength / 2;
        int halfHeight = sideLength / 2;
        if (x - halfWidth <= 0) {
            xSpeed = Math.abs(xSpeed);
            x = halfWidth;
        } else if (x + halfWidth >= panelWidth) {
            xSpeed = -Math.abs(xSpeed);
            x = panelWidth - halfWidth;
        }
        if (y - halfHeight <= 0) {
            ySpeed = Math.abs(ySpeed);
            y = halfHeight;
        } else if (y + halfHeight >= panelHeight) {
            ySpeed = -Math.abs(ySpeed);
            y = panelHeight - halfHeight;
        }
    }



    // Getters for side length
    public int getSideLength() {
        return sideLength;
    }
}

class Triangle extends Shape {
    private final int sideLength;

    public Triangle(int x, int y, int sideLength, Color color, int xSpeed, int ySpeed) {
        super(x, y, color, xSpeed, ySpeed);
        this.sideLength = sideLength;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x, x - sideLength / 2, x + sideLength / 2};
        int[] yPoints = {y - sideLength / 2, y + sideLength / 2, y + sideLength / 2};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void move(int panelWidth, int panelHeight) {
        x += xSpeed;
        y += ySpeed;
        handleWallCollision(panelWidth, panelHeight);
    }

    public void handleWallCollision(int panelWidth, int panelHeight) {
        int halfSide = sideLength / 2;
        if (x - halfSide <= 0 || x + halfSide >= panelWidth) {
            xSpeed = -xSpeed;
            x = Math.max(halfSide, Math.min(x, panelWidth - halfSide));
        }
        if (y - halfSide <= 0 || y + halfSide >= panelHeight) {
            ySpeed = -ySpeed;
            y = Math.max(halfSide, Math.min(y, panelHeight - halfSide));
        }
    }


    // Getters for side length
    public int getSideLength() {
        return sideLength;
    }
}
