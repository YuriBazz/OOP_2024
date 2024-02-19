
public class Vector3D {
    Double x,y,z;

    public Vector3D (Double x1, Double y1, Double z1){
        x = x1;
        y = y1;
        z = z1;
    }

    public Double getX(){ return x; }

    public Double getY(){
        return y;
    }

    public Double getZ(){
        return z;
    }

    private Boolean compareToDoubles(Double f1, Double f2){
        return Math.abs(f1 - f2) < 0.00001;
    }

    private Boolean badEqual(Vector3D v){
        return compareToDoubles(x,v.x) && compareToDoubles(y,v.y) && compareToDoubles(z,v.z);
    }

    public Boolean equal(Vector3D v){
        return this.sub(v).len() == 0;
    }
    public Double scalar(Vector3D v){
        return x*v.x + y*v.y + z*v.z;
    }

    public Double len(){
        return Math.sqrt(this.scalar(this));
    }

    public Vector3D multiply(Double factor){
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

    public Boolean pCollin(Vector3D v){
        return this.vecX(v).equal(new Vector3D(0.0,0.0,0.0));
    }
}
