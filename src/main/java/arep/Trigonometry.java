package arep;

public class Trigonometry {
    private double num;
    private String fun;
    public Trigonometry(String datos){
        String[] d = (datos.split(","));
        num = Double.parseDouble(d[0]);
        fun = d[1].trim();
    }

    public String getFun() {
        if(fun.equals("sin") || fun.equals("cos") || fun.equals("tan")) {
            return fun;
        }
        else{
            return "";
        }
    }

    public String getNum(){
        return String.valueOf(num);
    }



    public String calcular(){
        String rta = "";
        if (fun.equals("sin")){
            rta = String.valueOf(Math.sin(num));
        }
        else if(fun.equals("cos")){
            rta = String.valueOf(Math.cos(num));
        }
        else if(fun.equals("tan")){
            rta = String.valueOf(Math.tan(num));
        }
        else{
            rta = "Los valores dados no corresponden a los validos.";
        }

        return "{\"rta\":"+rta+"}";
    }



}
