/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Webapp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "categoriabean")
@SessionScoped
public class CategoriaMultaBean {
    private String camNombre;

    public String getCamNombre() {
        return camNombre;
    }

    public void setCamNombre(String camNombre) {
        this.camNombre = camNombre;
    }
}
