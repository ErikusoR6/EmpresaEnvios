/**
 * Un envío agrupa los paquetes que un cliente manda a un mismo destino.
 * Un envío admite como máximo tres paquetes.
 *
 * Ninguno de los métodos de esta clase escribe en pantalla.
 *
 * @author
 */
public class Envio {
    // TODO constante de clase MAX_PAQUETES (ver enunciado)
    public static final int MAX_PAQUETES = 3;

    // TODO atributos: código de seguimiento, código postal y tres paquetes
    private String codigoSegimiento;
    private String codigoPostal;
    private Paquete paquete1;
    private Paquete paquete2;
    private Paquete paquete3;

    /**
     * Crea un envío sin paquetes.
     *
     * @param codigoSegimiento      código de seguimiento, p.ej. "PX00000001R"
     * @param codigoPostal código postal del destino, p.ej. "36202"
     */
    public Envio(String codigoSegimiento, String codigoPostal) {
        // TODO
        this.codigoSegimiento = codigoSegimiento;
        this.codigoPostal = codigoPostal;
    }

    public String getCodigo() {
        // TODO
        return codigoSegimiento;
    }

    public String getCodigoPostal() {
        // TODO
        return codigoPostal;
    }

    /**
     * @return cuántos paquetes tiene el envío (0 a 3)
     * Para mejorar el algoritmo: Los paquetes se añaden siempre en orden, así que nunca hay huecos entre ellos.
     */
    public int getNumeroPaquetes() {
        int numeroPaquetes = 0;
        // TODO (se calcula comprobando qué atributos d paquete son null)
        if (paquete1 != null){
            numeroPaquetes++;
        }
        if (paquete2 != null){
            numeroPaquetes++;
        }
        if (paquete3 != null){
            numeroPaquetes++;
        }
        return numeroPaquetes;
    }

    /**
     * @return true si ya no se pueden añadir más paquetes
     */
    public boolean estaCompleto() {
        // TODO
        if(paquete1 != null && paquete2 != null && paquete3 != null){
            return true;
        }else{
        return false;
        }
    }

    /**
     * Añade un paquete al envío si no está completo.
     *
     * @return true si se ha añadido, false si el envío estaba completo
     */
    public boolean addPaquete(Paquete paquete) {
        // TODO
        if (!estaCompleto() && paquete1 == null){
            this.paquete1 = paquete;
            return true;
        }
        if (!estaCompleto()&& paquete2 == null){
            this.paquete2 = paquete;
            return true;
        }
        if (!estaCompleto()&& paquete3 == null){
            this.paquete3 = paquete;
            return true;
        }
        return false;
    }

    /**
     * Crea un paquete con las medidas y peso indicados y lo añade al envío.
     *
     * @return true si se ha añadido, false si el envío estaba completo
     */
    public boolean addPaquete(double alto, double ancho, double largo, double peso) {
        // TODO
        if (!estaCompleto() && paquete1 == null){
            this.paquete1 = new Paquete(alto, ancho, largo, peso);
            return true;
        }
        if (!estaCompleto()&& paquete2 == null){
            this.paquete2 = new Paquete(alto, ancho, largo, peso);
            return true;
        }
        if (!estaCompleto()&& paquete3 == null){
            this.paquete3 = new Paquete(alto, ancho, largo, peso);
            return true;
        }
        return false;
    }

    /**
     * @return la suma de los pesos reales de los paquetes (kg)
     */
    public double calcularPesoReal() {
        // TODO
        double pesoReal = 0;
        if (paquete1 != null){
            pesoReal += paquete1.getPeso();

        }
        if (paquete2 != null){
            pesoReal += paquete2.getPeso();
        }
        if (paquete3 != null){
            pesoReal += paquete3.getPeso();
        }
        return pesoReal;
    }

    /**
     * Suma los pesos facturables de los paquetes y redondea hacia arriba
     * al kilo entero.
     *
     * @return el peso facturable del envío (kg enteros)
     */
    public double calcularPesoFacturable() {
        // TODO
        double pesoFacturable = 0;
        if (paquete1 != null){
            pesoFacturable += paquete1.calcularPesoFacturable();
        }
        if (paquete2 != null){
            pesoFacturable += paquete2.calcularPesoFacturable();
        }
        if (paquete3 != null){
            pesoFacturable += paquete3.calcularPesoFacturable();
        }
        return Math.ceil(pesoFacturable);
    }

    /**
     * @return el paquete de mayor peso real; si hay empate, el que se añadió
     * antes; null si el envío no tiene paquetes
     */
    public Paquete getPaqueteMasPesado() {
        // TODO
        Paquete paqueteMasPesado;
        if (paquete1 == null){
            return null;
        }else {
            paqueteMasPesado = paquete1;
        }
        if (paquete2 == null){
            return paqueteMasPesado;
        } else if (paquete2.getPeso() > paqueteMasPesado.getPeso()) {
            paqueteMasPesado = paquete2;
        }
        if (paquete3 == null){
            return paqueteMasPesado;
        } else if (paquete3.getPeso() > paqueteMasPesado.getPeso()) {
            paqueteMasPesado = paquete3;
        }

        return paqueteMasPesado;
    }

    /**
     * @return representación textual del envío (ver enunciado)
     */
    public String toString() {
        // TODO
        if (paquete3 == null){
            return "Envío "+codigoSegimiento +" -> CP "+ codigoPostal +" ("+getNumeroPaquetes()+" paquete/s)\n" +
                    "  1. "+paquete1+"\n" +
                    "  2. "+paquete2+"\n" +
                    "  Peso real: "+calcularPesoReal() +"kg | "+ "Peso Facturable: "+ calcularPesoFacturable()+" kg";
        }
        if (paquete2 == null){
            return "Envío "+codigoSegimiento +" -> CP "+ codigoPostal +" ("+getNumeroPaquetes()+" paquete/s)\n" +
                    "  1. "+paquete1+"\n" +
                    "  Peso real: "+calcularPesoReal() +"kg | "+ "Peso Facturable: "+ calcularPesoFacturable()+" kg";
        }
            return "Envío "+codigoSegimiento +" -> CP "+ codigoPostal +" ("+getNumeroPaquetes()+" paquete/s)\n" +
                    "  1. "+paquete1+"\n" +
                    "  2. "+paquete2+"\n" +
                    "  3. "+paquete3+"\n" +
                    "  Peso real: "+calcularPesoReal() +"kg | "+ "Peso Facturable: "+ calcularPesoFacturable()+" kg";

        }

}
