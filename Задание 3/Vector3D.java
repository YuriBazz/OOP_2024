
public class Vector3D {
    private double x,y,z;

    public Vector3D (double i, double j, double k){
        x = i;
        y = j;
        z = k;
    }


    public double getX(){ return x; }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    private boolean compareToDoubles(Double f1, Double f2){
        return Math.abs(f1 - f2) < 0.00001;
    }

    private boolean badEqual(Vector3D v){
        return compareToDoubles(x,v.x) && compareToDoubles(y,v.y) && compareToDoubles(z,v.z);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Vector3D vec = (Vector3D) o;
        return this.sub(vec).len() == 0;
    }
    public double scalar(Vector3D v){
        return x*v.x + y*v.y + z*v.z;
    }

    public double len(){
        return Math.sqrt(this.scalar(this));
    }

    public Vector3D multiply(double factor){
        return new Vector3D (x * factor, y * factor, z * factor);
    }

    public Vector3D add(Vector3D v){
        return new Vector3D(x + v.x, y + v.y, z + v.z);
    }

    public Vector3D sub(Vector3D v){
        return new Vector3D(x - v.x, y - v.y, z - v.z);
    }

    public Vector3D vecX(Vector3D v){
        return new Vector3D(y * v.z - z * v.y, -x * v.z + v.x * z, x * v.y - v.x * y);
    }

    public boolean pCollin(Vector3D v){
        return this.vecX(v).equals(new Vector3D(0.0,0.0,0.0));
    }
}
