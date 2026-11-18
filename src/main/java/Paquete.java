/**
 * Un bulto físico que forma parte de un envío.
 *
 * @author Erik Dafonte Da concepcion
 */

public class Paquete {
    /** cm3 que equivalen a 1 kg a efectos de facturación */
    public static final double FACTOR_VOLUMETRICO = 5000;

    // TODO atributos: una Dimension y el peso real (kg)

    private Dimension dimension;
    private double peso;

    /**
     * Crea un paquete a partir de una dimensión ya creada y su peso real (kg).
     */
    public Paquete(Dimension dimension, double peso) {
        // TODO
      this.dimension = new Dimension(dimension.getAlto(),dimension.getAncho(),dimension.getLargo());
      this.peso = peso;
    }

    /**
     * Crea un paquete a partir de sus medidas (cm) y su peso real (kg).
     * Sin duplicar el código del otro constructor.
     */
    public Paquete(double alto, double ancho, double largo, double peso) {
        // TODO
        this.dimension = new Dimension(alto,ancho,largo);
        this.peso = peso;

    }

    public Dimension getDimension() {
        // TODO
        return dimension;
    }

    /**
     * @return el peso real en kg
     */
    public double getPeso() {
        // TODO
        return peso;
    }

    /**
     * @return el volumen del paquete en cm3
     */
    public double calcularVolumen() {
        // TODO (lee la decisión de diseño del enunciado)
        // TODO Decidi calcular el volumen aquí porque no forma parte de las dimensiones del paquete
        double volumen;

        volumen = dimension.getLargo() * dimension.getAncho() * dimension.getAlto();

        return volumen;
    }

    /**
     * @return el peso volumétrico en kg (volumen / FACTOR_VOLUMETRICO)
     */
    public double calcularPesoVolumetrico() {
        // TODO
        return calcularVolumen() / FACTOR_VOLUMETRICO;
    }

    /**
     * El peso facturable es el mayor entre el peso real y el volumétrico.
     *
     * @return el peso facturable en kg
     */
    public double calcularPesoFacturable() {
        // TODO
        return Math.max(calcularPesoVolumetrico(),peso);
    }

    /**
     * @return por ejemplo "40.0 x 30.0 x 50.0 cm | 8.0 kg (facturable 12.0 kg)"
     */
    public String toString() {
        // TODO
        return dimension.toString() + " | " + peso + " kg" + " (facturable "+ calcularPesoFacturable() + " kg)";
    }
}
