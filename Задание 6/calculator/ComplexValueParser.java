package calculator;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import calculator.RealValueParser;

import java.util.Objects;
import java.util.regex.PatternSyntaxException;

public class ComplexValueParser implements AbstractValueParser{

    public AbstractValue parse(String value) throws ParseValueException
    {
        if (Objects.equals(value, "i")) return new ComplexValue(0,1);
        String[] values;
        try
        {
            values = value.split("i");
            var a = Objects.equals(values[0], "") ? 0 : Double.parseDouble(values[0]);
            var b = Objects.equals(values[1], "") ? 0 : Double.parseDouble(values[1]);
            return new ComplexValue(a,b);
        }
        catch(IndexOutOfBoundsException exception)
        {
            try
            {
                var res = Double.parseDouble(value);
                return new ComplexValue(res, 0);
            }
            catch(Exception ex)
            {
                throw new ParseValueException();
            }
        }
    }

    public String getDatatypeName()
    {
        return "комлексные числа";
    }
}
