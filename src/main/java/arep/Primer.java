package arep;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//Primer cliente
public class Primer{
    public static void main(String[] args) {

        try {
            String datos = "0.7272727, sin";
            URL site = new URL("https://parcial-arep-1st.herokuapp.com/calcular?datos=" + datos);
            Scanner leer = new Scanner(site.openStream());
            StringBuffer rta = new StringBuffer();
            while (leer.hasNext()) {
                rta.append(leer.next());
            }
            String res = rta.toString();
            System.out.println("La información que retorno el sitio web heroku es: ");
            System.out.println(res);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}