import java.util.Arrays;

public class Vector2DTest {
    public static Vector2D symmetry(Vector2D P, Vector2D normal, Vector2D S)
    {
        Vector2D SP = P.sub2D(S);
        Vector2D pr = SP.vectorProectionOn(normal);
        return S.add2D(pr.multiply2D(2));
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
        Vector2D A1X = BA1.multiply2D((pr.len() * pr.len()) / BA1.scalar(pr.multiply2D(-1)));
        return A1.add2D(A1X);
    }

    public static void main(String[] args)
    {
        Vector2D
                A = new Vector2D(0,0),
                B = new Vector2D(0,0),
                P = new Vector2D(0,0),
                normal = new Vector2D(0,0);
        try
        {
            bissectris(A,B,P,normal).printVector();
            symmetry(P,normal,A).printVector();
        }
        catch(ABException e)
        {
            System.out.println(e.getMessage());
        }
        catch(ParallelException e)
        {
            System.out.println(e.getMessage());
        }
        var letters = new String[] {"a", "b", "c", "d"};
        var array =
                new Vector2D[]
                {
                    new Vector2D(-3.0/5, 4.0/3),
                    new Vector2D(2.0/3,2.0/3),
                    new Vector2D(0,-1),
                    new Vector2D(3.0/5,-4.0/5)
                };
        var orts = Arrays.stream(array).filter(x -> x.len() == 1).toArray(Vector2D[] :: new);
        for (Vector2D ort : orts) ort.printVector();
        for(int i = 0; i < array.length - 1 ; i++)
            for(int j = i + 1; j < array.length; j++)
            {
                if(array[i].collin(array[j]))
                    System.out.printf("Вектор %s коллинеарен вектору %s\n\r", letters[i], letters[j]);
            }
    }

}
