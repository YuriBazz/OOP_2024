import org.junit.Test;

import static org.junit.Assert.*;
public class SegmentTest {
    @org.junit.Test
    public void lenTest(){
        var segment = new Segment(new Vector3D(0,0,0) , new Vector3D(1,1,1));
        assertEquals(Math.sqrt(3), segment.len() , 0.0001);
    }

    @org.junit.Test
    public void relationTest(){
        var segment = new Segment(
                new Vector3D(0,0,0),
                new Vector3D(10,0,0)
        );
        segment.relation(2).equal(new Vector3D(5,0,0));
    }

    @org.junit.Test
    public void mult2Test(){
        var segment = new Segment(
                new Vector3D(0,0,0),
                new Vector3D(5,0,0)
        );
        segment.mult2().equal(new Vector3D(10,0,0));
    }

    @org.junit.Test
    public void inSegmentTest(){
        var segment = new Segment(
                new Vector3D(0,0,0),
                new Vector3D(0,0,1)
        );
        assertTrue(segment.inSegment(new Vector3D(0, 0, 0.5)));
    }
}
