public class Vector {
    private double[] coordinates;
    private int dimension;
    Vector(double ... _coordinates_){
        coordinates = _coordinates_;
        dimension = _coordinates_.length;
    }

    Vector(){
        coordinates = new double[0];
        dimension = 0;
    }

    Vector(Vector vector){
        coordinates = vector.coordinates.clone();
        dimension = coordinates.length;
    }

    Vector(Vector vector, int _dimension_){
        var newCoordinates = new double[_dimension_];
        for(int i = 0; i < _dimension_; i++){
            newCoordinates[i] = i < vector.dimension ? vector.coordinates[i] : 0;
        }
        coordinates = newCoordinates;
        dimension = _dimension_;
    }

    public int dimension(){
        return dimension;
    }

    public double getCoordinateAt(int index){
        //считаем, что пользователь нумерует координаты от 1
        return index > 0 && index < dimension + 1 ? coordinates[index - 1] : Double.NaN;
    }

    public void changeCoordinateAt(int index, double newCoordinate){
        if(index > 0 && index < dimension + 1)
            coordinates[index - 1] = newCoordinate;
    }

    public static void printVector(Vector vector){
        System.out.printf("Размерность %s. ", vector.dimension);
        System.out.print("Координаты (");
        for(int i = 0; i  < vector.dimension - 1; i++)
            System.out.printf("%s, ", vector.coordinates[i]);
        System.out.printf("%s)\n\r", vector.coordinates[vector.dimension - 1]);
    }

    public void printVector(){
        System.out.printf("Размерность %s. ", dimension);
        System.out.print("Координаты (");
        for(int i = 0; i  < dimension - 1; i++)
            System.out.printf("%s, ", coordinates[i]);
        System.out.printf("%s)\n\r", coordinates[dimension - 1]);
    }

    public double scalar(Vector vector){
        var len = Math.min(vector.dimension, dimension);
        double sum = 0;
        for(int i =0 ; i < len; i++) {
            sum += coordinates[i] * vector.coordinates[i];
        }
        return sum;
    }

    public double len(){
        return Math.sqrt(this.scalar(this));
    }

    public Vector multiply(double factor){
        var coordinates_ = coordinates.clone();
        for(int i = 0; i < dimension; i++)
            coordinates_[i] *= factor;
        return new Vector(coordinates_);
    }

    public Vector add(Vector vector){
        var len = Math.min(dimension, vector.dimension);
        var newCoordinates = new double[len];
        for(int i = 0; i < len; i++){
            newCoordinates[i] = coordinates[i] + vector.coordinates[i];
        }
        return new Vector(newCoordinates);
    }

    public Vector sub(Vector vector){
        var len = Math.min(dimension, vector.dimension);
        var newCoordinates = new double[len];
        for(int i = 0; i < len; i++){
            newCoordinates[i] = coordinates[i] - vector.coordinates[i];
        }
        return new Vector(newCoordinates);
    }

    public boolean orthogonal(Vector vector){
        return this.scalar(vector) == 0;
    }

    public double pr(Vector vector){
        return this.scalar(vector) / Math.sqrt(vector.scalar(vector));
    }

}
