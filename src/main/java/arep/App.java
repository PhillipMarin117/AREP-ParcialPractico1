package arep;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> {

            return "<h1>Función trigonometica</h1>\n" +
                    "\n" +
                    "<form action=\"/calcular\">\n" +
                    "  <label for=\"datos\">Datos</label>\n" +
                    "  <input type=\"text\" id=\"datos\" name=\"datos\"><br><br>\n" +
                    "  <input type=\"submit\" value=\"Calcular\">\n" +
                    "</form>\n" +
                    "\n" +
                    "<p>Presiona el boton \"calcular\" para asi poder obtener \n" +
                    "la función trigonometrica(recuerda que debe ser el numero y la funcion " +
                    "sin, cos o tan separados por una coma).</p>\n";
        });

        get("/calcular", (req, res) -> {
            String datos = req.queryParams("datos");
            Trigonometry t = new Trigonometry(datos);

            String resultado = t.calcular();
            String fun = t.getFun();
            String num = t.getNum();
            if(fun.equals("")){
                return "<h1>No pudo calcularse la funcion trigonometrica:</h1>\n" +
                        "\n" +
                        "<form action=\"/\">\n" +
                        "  <label for=\"media\">intenta volver a la pagina principal y ver que salio mal. </label>\n" +
                        "<br>"+
                        "<br>"+
                        "  <input type=\"submit\" value=\"Volver al inicio para calcular nuevos valores\">\n" +
                        "</form>\n";

            }
            return
                    "<h1>La funcion trigonometica es:</h1>\n" +
                            "\n" +
                            "<form action=\"/\">\n" +
                            "  <label for=\"media\">"+fun+" de "+num+" es: "+resultado+"</label>\n" +
                            "<br>"+
                            "<br>"+
                            "  <input type=\"submit\" value=\"Volver al inicio para calcular nuevos valores\">\n" +
                            "</form>\n";
        });


    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't se (i.e. on localhost)
    }
}
