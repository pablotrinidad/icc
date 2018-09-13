package icc.clases;

/* Clase Mosca */
public class Mosca {

    /* Letra original de la canción */
    public static final String original = "Una mosca parada en la pared, \n" +
                                    "en la pared, en la pared. \n" +
                                    "Una mosca, una mosca, \n" +
                                    "una mosca parada en la pared";

    /* Vocal por remplazar en la letra original al llamar al método canta()*/
    private char vocal;

    /* Inicializa a todas las mozcas con la vocal 'a' */
    public Mosca() {
        vocal = 'a';
    }

    /* Setter for this.voval */
    public void setVocal(char vocal) {
        this.vocal = vocal;
    }

    /* Regresa la letra de original de la canción pero
    * reemplazando todas las vocales de la misma por
    * el valor actual de this.vocal
    */
    public String canta() {
        /* Crea nueva letra donde se reemplazan todas las vocales */
        String new_lyrics = this.original.replaceAll(
            "[aeiouAEIOU]",
            String.valueOf(this.vocal)
        );

        /* Regresa nueva letra */
        return new_lyrics;
    }

}
