public class Segment {
    Vector3D start, end;

    public Segment(Vector3D A, Vector3D B){
        start = A;
        end = B;
    }
    public Double len(){
        return start.sub(end).len();
    }

    public Vector3D relation(Double k){
        return new Vector3D(
                (start.x + k * end.x) / (1 + k),
                (start.y + k * end.y) / (1 + k),
                (start.z + k * end.z) / (1 + k)
        );
    }

    public Vector3D mult2(){
        //к концу прибавть модули начала
        // так работает, только если конец выше или на том же уровне, что и начало
        // если ниже - то надо вычитать абc
        return new Vector3D(
                end.x + Math.abs(start.x),
                end.y + Math.abs(start.y),
                end.z + Math.abs(start.z)
        );
    }

    public Boolean inSegment(Vector3D C){
        var xDelta = start.x - end.x;
        var yDelta = start.y - end.y;
        var zDelta = start.z - end.z;
        //сравниваем эти штуки, если никто из них не Infinity
        var xCheck = (start.x - C.x) / (start.x - end.x);
        var yCheck = (start.y - C.y) / (start.y - end.y);
        var zCheck = (start.z - C.z) / (start.z - end.z);
        var check = true;
        // Double.POSITIVE_INFINITY
        return check && (start.x - C.x)*(end.x - C.x) < 0;

        // похуй, потом когда-нибдь сделаю
    }
}
