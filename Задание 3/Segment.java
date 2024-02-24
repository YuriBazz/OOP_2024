public class Segment {
    Vector3D start, end;

    public Segment(Vector3D A, Vector3D B){
        start = A;
        end = B;
    }
    public Double len(){
        return start.sub(end).len();
    }

    public Vector3D relation(double k){
        return new Vector3D(
                (start.getX() + k * end.getX()) / (1 + k),
                (start.getY() + k * end.getY()) / (1 + k),
                (start.getZ() + k * end.getZ()) / (1 + k)
        );
    }

    public Vector3D mult2(){
        return new Vector3D(
                2 * end.getX() - start.getX(),
                2 * end.getY() - start.getY(),
                2 * end.getZ() - start.getZ());
    }

   public boolean inSegment(Vector3D C){
       var AB = new Vector3D(
               end.getX() - start.getX(),
               end.getY() - start.getY(),
               end.getZ() - start.getZ()
       );
       var CB = new Vector3D(
               end.getX() - C.getX(),
               end.getY() - C.getY(),
               end.getZ() - C.getZ()
       );
       var coll = AB.vecX(CB).len() == 0;
       var xCheck = start.getX() <= C.getX() && C.getX() <= end.getX();
       var yCheck = start.getY() <= C.getY() && C.getY() <= end.getY();
       var zCheck = start.getZ() <= C.getZ() && C.getZ() <= end.getZ();
       return coll && xCheck && yCheck && zCheck;
    }
}
