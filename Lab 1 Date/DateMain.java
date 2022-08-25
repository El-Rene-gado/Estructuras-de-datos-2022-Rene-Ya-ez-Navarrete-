package lab.pkg1.date;

/**
 *
 * @author Rene Yañez
 */
public class DateMain {
    public static void main(String[] args) {
        Date codigo = new Date(0);
        codigo.setDia(11);
        codigo.setMes(4);
        codigo.setAnio(2001);
        
        System.out.println(codigo.toString()); 
    }
}
