package Util;

public class ValidarRut {

    private int numPart;
    private char dv;

    public ValidarRut() {
    }

    public int getNumPart() {
        return numPart;
    }

    public void setNumPart(int numPart) {
        this.numPart = numPart;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public boolean validaRut(String paramRut) {
        String rut = paramRut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        boolean validacion = true;

        String num = rut.substring(0, rut.length() - 1);
        char dig = rut.substring(rut.length() - 1).charAt(0);
        if (cValNum(num) || cValDV(dig)) {
            validacion = false;
        } else {
        }

        if (validacion == true) {
            this.numPart = Integer.parseInt(num);
            this.dv = dig;

            return true;
        } else {
            return false;
        }
    }

    private boolean cValNum(String num) {
        boolean val = false;
        for (char i : num.toCharArray()) {
            if (i != '1' && i != '2' && i != '3' && i != '4' && i != '5' && i != '6' && i != '7' && i != '8' && i != '9' && i != '0') {
                val = true;
            }
        }
        return val;
    }

    private boolean cValDV(char dig) {
        boolean val = false;
        if (dig != '1' && dig != '2' && dig != '3' && dig != '4' && dig != '5' && dig != '6' && dig != '7' && dig != '8' && dig != '9' && dig != '0' && dig != 'K') {
            val = true;
        }
        return val;
    }

    public String invertirNum(String num) {
        String cadenaInvertida = null;
        for (int x = num.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + num.charAt(x);
        }
        return cadenaInvertida;
    }

    public String obtenerSumaPorDigitos(String num) {
        int pivote = 2;
        int longitudCadena = num.length();
        int cantidadTotal = 0;
        int b = 1;
        String digito;
        for (int i = 0; i < longitudCadena; i++) {
            if (pivote == 8) {
                pivote = 2;
            }
            int temporal = Integer.parseInt("" + num.substring(i, b));
            b++;
            temporal *= pivote;
            pivote++;
            cantidadTotal += temporal;
        }
        cantidadTotal = 11 - cantidadTotal % 11;
        if (String.valueOf(cantidadTotal).equals("11")) {
            digito = "0";
        } else {
            digito = "K";
        }
        return digito;
    }
}
