public class Main {
    public static void main(String[] args) {
        var segment = new Segment(new Vector3D(1.0,0.0,0.0), new Vector3D(3.0,0.0,0.0));
        var point = new Vector3D(2.0,0.0,0.0);
        System.out.println(segment.inSegment(point));
        System.out.println(segment.start.x);
        System.out.println(1/ (segment.start.y - segment.end.z));
        System.out.println();
        }
    }
