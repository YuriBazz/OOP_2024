import static org.junit.Assert.*;

public class Vector3DTest {
    @org.junit.Test
    public void testScalar(){
        var v1 = new Vector3D(3,4,8);
        var v2 = new Vector3D(4, 11,7);
        var res = v1.scalar(v2);
        assertEquals(112, res, 0.000001);
    }

    @org.junit.Test
    public void testLen(){
        var v1 = new Vector3D(3,0,4);
        var res = v1.len();
        assertEquals(5, res, 0.0001);
    }

    @org.junit.Test
    public void testMultiply(){
        var v1 = new Vector3D(3, 4,5);
        var v2 = v1.multiply(5);
        v2.equal(new Vector3D(15, 20,25));
    }

    @org.junit.Test
    public void testSub(){
        var v1 = new Vector3D(2, 3, 4);
        var v2 = new Vector3D(5, 6,7);
        var res = v2.sub(v1);
        res.equal(new Vector3D(3,3,3));
    }

    @org.junit.Test
    public void testVecX(){
        var v1 = new Vector3D(1,1,1);
        var v2 = new Vector3D(-1,-1,-1);
        var res = v1.vecX(v2);
        res.equal(new Vector3D(0,0,0));
    }

    @org.junit.Test
    public void testPCollin(){
        var v1 = new Vector3D(1,1,1);
        var v2 = new Vector3D(-1,-1,-1);
        var res = v1.vecX(v2);
        res.equal(new Vector3D(0,0,0));
    }
}
