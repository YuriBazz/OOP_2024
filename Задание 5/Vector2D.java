public class Vector2D extends Vector {
    private double
            x = this.getCoordinateAt(1),
            y = this.getCoordinateAt(2);

    Vector2D(double _x_, double _y_){
        super(_x_,_y_);
    }

    Vector2D(Vector vector){
        super(vector, 2);
    }

    public Vector2D add2D(Vector2D vector){
        return new Vector2D(this.add(vector));
    }

    public Vector2D sub2D(Vector2D vector){
        return new Vector2D(this.sub(vector));
    }

    public Vector2D multiply2D(double factor){
        return new Vector2D(this.multiply(factor));
    }

    public Vector2D ort(){
        return new Vector2D(y, -1 * x);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void changeX(double newX){
        this.changeCoordinateAt(1, newX);
        x = newX;
    }

    public void changeY(double newY){
        this.changeCoordinateAt(2, newY);
        y = newY;
    }


    public Vector2D vectorProectionOn(Vector2D vector){
        return new Vector2D(vector.multiply(this.pr(vector)/ vector.len()));
    }

    public boolean collin(Vector2D vector){
        return Math.abs(x * vector.y - vector.x *  y) < 0.000001;
    }

    public double[] decomposition(Vector2D vector1, Vector2D vector2) throws VecCollinearException{
        if(vector1.collin(vector2))
            throw new VecCollinearException();
        double _x = (x * vector2.y - y * vector2.x) / (vector1.x * vector2.y - vector1.y * vector2.x);
        double _y = (x * vector1.y - y * vector1.x) / (vector2.x * vector1.y - vector2.y * vector1.x);
        return new double[]{_x, _y};
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Vector2D vec = (Vector2D) o;
        return this.sub(vec).len() < 0.00001;
    }
}
