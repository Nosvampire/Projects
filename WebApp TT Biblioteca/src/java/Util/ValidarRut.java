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

    public boolean validaRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char digVer = rut.charAt(rut.length() - 1);
            
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (digVer == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
            
            numPart = rutAux;
            dv = digVer;

        } catch (NumberFormatException e) {
            validacion = false;
        } catch (Exception e) {
        }
        return validacion;
    }
}
