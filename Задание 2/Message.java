public class Message {
    String line;
    public Message (String str){
        line = str;
    }
    public Message (){
        line = "";
    }

    public String reverse(){
        StringBuilder res = new StringBuilder();
        for(int i = line.length() - 1; i > -1; i--)
            res.append(line.charAt(i));
        return res.toString();
    }

    public int amountOfWords(){
        // слова - все что отделено друг от друга пробелами
        var array = line.split(" ");
        return array.length;
    }

    public int amountOfSymbol(char c){
        var count = 0;
        for(int i = 0; i < line.length(); i++)
            count += line.charAt(i) == c ? 1 : 0;
        return count;
    }

    public String number(){
        //предполагается, что все номера состоят из 4 цифр
        // также предпологается, что номер всегда есть
        var numberIndex = line.indexOf("№");
        return line.substring(numberIndex+1, Math.min(numberIndex + 6, line.length())).trim();
    }

    public String knSubstring(int k, int n, String str){
        var result = new StringBuilder(line);
        if(k > result.length())
            return result.toString();
        var indexWhereReplaceFinish = Math.min(k + n, result.length());
        var strBuilder = new StringBuilder(str);
        if(strBuilder.length() < n)
            strBuilder.append("*".repeat(n - strBuilder.length()));
        str = strBuilder.toString();
        result.replace(k, indexWhereReplaceFinish, str);
        return result.toString();
    }
}
