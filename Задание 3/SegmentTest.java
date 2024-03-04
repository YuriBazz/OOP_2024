import org.junit.Test;

import static org.junit.Assert.*;
public class SegmentTest {
    public static void main(String[] args) {
        var segment = new Segment(new Vector3D(1, 5, 4), new Vector3D(5, 21, 4));
        System.out.println(segment.len());
        var point = segment.relation(0.5);
        System.out.printf("(%s, %s, %s)\n\r", point.getX(), point.getY(), point.getZ());
        var dot = segment.mult2();
        System.out.printf("(%s, %s, %s)\n\r", dot.getX(), dot.getY(), dot.getZ());
        System.out.println(segment.inSegment(new Vector3D(0, 1, 4)));
    }
}
/*    public void lenTest(){
        var segment = new Segment(new Vector3D(0,0,0) , new Vector3D(1,1,1));
        assertEquals(Math.sqrt(3), segment.len() , 0.0001);
    }


    public void relationTest(){
        var segment = new Segment(
                new Vector3D(0,0,0),
                new Vector3D(10,0,0)
        );
        assertEquals(segment.relation(2), new Vector3D(5,0,0));
    }


    public void mult2Test(){
        var segment = new Segment(
                new Vector3D(0,0,0),
                new Vector3D(5,0,0)
        );
        segment.mult2().equals(new Vector3D(10,0,0));
    }

    public void inSegmentTest(){
        var segment = new Segment(
                new Vector3D(0,0,0),
                new Vector3D(0,0,1)
        );
        assertTrue(segment.inSegment(new Vector3D(0, 0, 0.5)));
*/

