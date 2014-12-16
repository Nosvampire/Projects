/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Webapp;

import FCD.CondicionFCD;
import POJO.Condicion;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "condicionbean")
@SessionScoped
public class CondicionBean {
    private List<Condicion> listCondicion;

    public List<Condicion> getListCondicion() {
        return listCondicion;
    }

    public void setListCondicion(List<Condicion> listCondicion) {
        this.listCondicion = listCondicion;
    }
    
    
    public void consultaCondicion(){
    listCondicion = CondicionFCD.selectCondicion();
    }
    
}
