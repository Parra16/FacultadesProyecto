/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculpro;

import java.io.Serializable;


/**
 *
 * @author Jorge
 */
public class Nodo implements Serializable
{
    public static final long serialVersionUID =1L; 
    private String etiqueta;
    private Object obj;
    private Nodo siguiente;
    private Nodo Anterior;
    private Nodo Arriba;
    private Nodo Abajo;
    

    public Nodo(String etiqueta, Object obj) {
        this.etiqueta = etiqueta;
        this.obj = obj;
        this.siguiente = null;
        this.Anterior = null;
        this.Arriba = null;
        this.Abajo = null;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the obj
     */
    public Object getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente()
    {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }

    /**
     * @return the Anterior
     */
    public Nodo getAnterior()
    {
        return Anterior;
    }

    /**
     * @param Anterior the Anterior to set
     */
    public void setAnterior(Nodo Anterior)
    {
        this.Anterior = Anterior;
    }

    /**
     * @return the Arriba
     */
    public Nodo getArriba() {
        return Arriba;
    }

    /**
     * @param Arriba the Arriba to set
     */
    public void setArriba(Nodo Arriba) {
        this.Arriba = Arriba;
    }

    /**
     * @return the Abajo
     */
    public Nodo getAbajo() {
        return Abajo;
    }

    /**
     * @param Abajo the Abajo to set
     */
    public void setAbajo(Nodo Abajo) {
        this.Abajo = Abajo;
    }

    
    
    
    
}
//cisc toluca.com
//facultat,carreras,grupos,materias,alumnos
//´p{ñ-