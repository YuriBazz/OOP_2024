package calculator;

public class ComplexValue extends AbstractValue{

    private final double real;
    private final double imaginary;

    public ComplexValue(double real, double imaginary)
    {
        super();
        this.real = real;
        this.imaginary = imaginary;
    }


    public String toString()
    {
        var aFlag = Math.abs(real - (int)real) < 0.00001;
        var bFlag = Math.abs(imaginary - (int)imaginary) < 0.00001;
        var result = new StringBuilder();
        if(aFlag) result.append((int)real);
        else result.append(real);
        result.append("i");
        if(bFlag) result.append((int)imaginary);
        else result.append(imaginary);
        return result.toString();
    }

    public AbstractValue add(AbstractValue operand)
    {
        return new ComplexValue(
                this.real + ((ComplexValue) operand).real,
                this.imaginary + ((ComplexValue) operand).imaginary
        );
    }

    public AbstractValue sub(AbstractValue operand)
    {
        return new ComplexValue(
                this.real - ((ComplexValue) operand).real,
                this.imaginary - ((ComplexValue) operand).imaginary
        );
    }

    public AbstractValue mul(AbstractValue operand)
    {
        var a = ((ComplexValue)operand).real;
        var b = ((ComplexValue)operand).imaginary;
        return new ComplexValue(
               real * a - imaginary * b,
               imaginary * a + real * b
        );
    }

    private AbstractValue conjugate()
    {
        return new ComplexValue(real, - imaginary);
    }

    public AbstractValue div(AbstractValue operand)
            throws DivisionByZeroException
    {
        var a = ((ComplexValue) operand).real;
        var b = ((ComplexValue) operand).imaginary;
        var divisor = a * a + b * b;
        if (divisor == 0.0)
            throw new DivisionByZeroException();

        return new ComplexValue(
                (real * a + imaginary * b) / divisor,
                (imaginary * a - real * b) / divisor
        );
    }
}
