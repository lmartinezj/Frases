
public class Frases {
    public static final int PRIMER_CARACTER = 0;
    String frase;

    public Frases() {
    }

    public boolean isPalindromo(String frase) {
        StringBuilder fraseStringBuilder = convertirFraseEnStringBuilder(frase);
        while(true) {
            // Todos los string vacios y de un char son palindromos
            if (esMenorDeUnCaracter(fraseStringBuilder)) {

                return true;

            // Mas de un char
            } else {
                // Evalua si los extremos son iguales
                if (evaluarExtremosIguales(fraseStringBuilder)) {
                    borrarExtremos(fraseStringBuilder);

                // Extremos diferentes
                } else {
                    // Escoger primer y ultimo char
                    char extremoIzquierdo = fraseStringBuilder.charAt(PRIMER_CARACTER);
                    int ultimoCaracter = fraseStringBuilder.length() - 1;
                    char extremoDerecho = fraseStringBuilder.charAt(ultimoCaracter);

                    // Check extremos son letras
                    if(ambosLetras(extremoIzquierdo, extremoDerecho)) {

                        // comparar extremos en minusculas
                        if (Character.toLowerCase(extremoIzquierdo) == Character.toLowerCase(extremoDerecho)) {
                            borrarExtremos(fraseStringBuilder);
                        } else {
                            return false;
                        }
                    // alguno no es letra (evaluo el extremo izquierdo)
                    } else if(Character.isLetter(extremoIzquierdo)) {
                        // El derecho no es letra lo elimino
                        borrarUltimoCaracter(fraseStringBuilder, ultimoCaracter);
                    } else {
                        // El izquierdo no es letra lo elimino
                        borrarPrimerCaracter(fraseStringBuilder);
                    }
                }
            }
        }
    }

    private boolean esMenorDeUnCaracter(StringBuilder fraseStringBuilder) {
        return fraseStringBuilder.length() <= 1;
    }

    private void borrarPrimerCaracter(StringBuilder fraseStringBuilder) {
        fraseStringBuilder.deleteCharAt(PRIMER_CARACTER);
    }

    private StringBuilder borrarUltimoCaracter(StringBuilder fraseStringBuilder, int ultimoCaracter) {
        return fraseStringBuilder.deleteCharAt(ultimoCaracter);
    }

    private boolean ambosLetras(char extremoIzquierdo, char extremoDerecho) {
        return (Character.isLetter(extremoIzquierdo)) && (Character.isLetter(extremoDerecho));
    }

    private void borrarExtremos(StringBuilder fraseStringBuilder) {
        borrarPrimerCaracter(fraseStringBuilder);
        int ultimoCaracter = fraseStringBuilder.length() - 1;
        borrarUltimoCaracter(fraseStringBuilder, ultimoCaracter);
    }

    private StringBuilder convertirFraseEnStringBuilder(String frase) {
        StringBuilder sb = new StringBuilder(frase);
        return sb;
    }


    private boolean evaluarExtremosIguales(StringBuilder fraseStringBuilder) {
        char extremoIzquierdo = fraseStringBuilder.charAt(PRIMER_CARACTER);
        int ultimoCaracter = fraseStringBuilder.length() - 1;
        char extremoDerecho = fraseStringBuilder.charAt(ultimoCaracter);
        if (extremoDerecho == extremoIzquierdo) {
            return true;
        } else {
            return false;
        }
    }
}
