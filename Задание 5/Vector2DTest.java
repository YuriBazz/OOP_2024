import java.util.Arrays;

public class Vector2DTest {
    public static Vector2D symmetry(Vector2D P, Vector2D normal, Vector2D S)
    {
        Vector2D SP = P.sub2D(S);
        Vector2D pr = SP.vectorProectionOn(normal);
        return S.add2D(pr).add2D(pr);
    }

    public static Vector2D bissectris(Vector2D A, Vector2D B, Vector2D P, Vector2D normal)
            throws ABException, ParallelException
    {
        if(normal.scalar(A) * normal.scalar(B) >= 0)
            throw new ABException();
        Vector2D A1 = symmetry(P, normal, A);
        Vector2D pr = P.sub2D(A).vectorProectionOn(normal);
        Vector2D BA1 = A1.sub2D(B);
        Vector2D normalA1B = BA1.ort();
        if(normal.collin(normalA1B)) throw new ParallelException();
        var factor = -(pr.scalar(pr)) / BA1.scalar(pr);
        Vector2D A1X = BA1.multiply2D(factor);
        return A1.add2D(A1X);
    }

    public static void main(String[] args)
    {

        Vector2D
                A = new Vector2D(2,0),
                B = new Vector2D(-1,0),
                P = new Vector2D(1,1),
                normal = new Vector2D(1,-1);

        try{
            var d = A.decomposition(
                    new Vector2D(-1,-1),
                    new Vector2D(1,1)
            );
            System.out.printf("x = %.3f ", d[0]);
            System.out.printf("y = %.3f\n\r", d[1]);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try
        {
            symmetry(P,normal,A).printVector();
            bissectris(A,B,P,normal).printVector();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


        var letters = new String[] {"a", "b", "c", "d"};
        var array =
                new Vector2D[]
                {
                    new Vector2D(-3.0/5, 4.0/5),
                    new Vector2D(2.0/3,2.0/3),
                    new Vector2D(0,-1),
                    new Vector2D(3.0/5,-4.0/5)
                };
        System.out.println("Задание из таблички");
        var orts = Arrays.stream(array).filter(x -> Math.abs(x.len() - 1) < 0.00001).toArray(Vector2D[] :: new);
        for (Vector2D ort : orts) ort.printVector();
        for(int i = 0; i < array.length - 1 ; i++)
            for(int j = i + 1; j < array.length; j++)
            {
                if(array[i].collin(array[j]))
                    System.out.printf("Вектор %s коллинеарен вектору %s\n\r", letters[i], letters[j]);
            }
    }

}
