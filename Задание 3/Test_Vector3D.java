import static org.junit.Assert.*;
import org.junit.Test;

public class Test_Vector3D{
    @org.junit.Test
    public void testScalar(){
        var v1 = new Vector3D(3.0,4.0,8.0);
        var v2 = new Vector3D(4.0, 11.0,7.0);
        var res = v1.scalar(v2);
        assertEquals(112.0, res, 0.000001);
    }

    @org.junit.Test
    public void testLen(){
        var v1 = new Vector3D(3.0,0.0,4.0);
        var res = v1.len();
        assertEquals(5.0, res, 0.0001);
    }

    @org.junit.Test
    public void testMultiply(){
        var v1 = new Vector3D(3.0, 4.0,5.0);
        var v2 = v1.multiply(5.0);
        v2.equal(new Vector3D(15.0, 20.0,25.0));
    }

    @org.junit.Test
    public void testSub(){
        var v1 = new Vector3D(2.0, 3.0, 4.0);
        var v2 = new Vector3D(5.0, 6.0,7.0);
        var res = v2.sub(v1);
        res.equal(new Vector3D(3.0,3.0,3.0));
    }

    @org.junit.Test
    public void testVecX(){
        var v1 = new Vector3D(1.0,1.0,1.0);
        var v2 = new Vector3D(-1.0,-1.0,-1.0);
        var res = v1.vecX(v2);
        res.equal(new Vector3D(0.0,0.0,0.0));
    }

    @org.junit.Test
    public void testPCollin(){
        var v1 = new Vector3D(1.0,1.0,1.0);
        var v2 = new Vector3D(-1.0,-1.0,-1.0);
        var res = v1.vecX(v2);
        res.equal(new Vector3D(0.0,0.0,0.0));
    }
}
