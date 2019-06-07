/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculpro;

import machote1.Machote1;

/**
 *
 * @author M05H
 */
public class LDLC implements Machote1
{

    private Nodo raiz = null;

    @Override
    public boolean vacia()
    {
        return raiz == null;
    }

    @Override
    public boolean llena()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserta(Object obj)
    {
        if (obj != null)
        {
            if (raiz == null)
            {
                raiz = (Nodo) obj;
                raiz.setSiguiente(raiz);
                raiz.setAnterior(raiz);
            } else
            {
                Nodo n = (Nodo) obj;
                if (n.getEtiqueta().compareTo(raiz.getSiguiente().getEtiqueta()) < 0
                        || n.getEtiqueta().compareTo(raiz.getEtiqueta()) >= 0)
                {
                    n.setSiguiente(raiz.getSiguiente());
                    n.setAnterior(raiz);
                    raiz.getSiguiente().setAnterior(n);
                    raiz.setSiguiente(n);
                    if (n.getEtiqueta().compareTo(raiz.getEtiqueta()) >= 0)
                    {
                        raiz = n;
                    }
                } else
                {
                    boolean b = true;
                    Nodo aux = raiz.getSiguiente();
                    while (b)
                    {
                        if (n.getEtiqueta().compareTo(aux.getSiguiente().getEtiqueta()) <= 0)
                        {
                            n.setSiguiente(aux.getSiguiente());
                            n.setAnterior(aux);
                            aux.getSiguiente().setAnterior(aux);
                            aux.setSiguiente(n);
                            b = false;
                        } else
                        {
                            aux = aux.getSiguiente();
                        }
                    }
                }
            }
        }
    }

    @Override
    public Object inserta(Object obj, Object r)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object elimina()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object elimina(Object obj)
    {
        if (raiz == null)
        {
            System.out.println("Lista vacia");
            return null;
        } else
        {
            Nodo aux = null;
            String s = (String) obj;
            if (s.compareTo(raiz.getSiguiente().getEtiqueta()) >=0
                    && s.compareTo(raiz.getEtiqueta()) <=0)
            {
                if (raiz.getSiguiente().getEtiqueta().equals(s))
                {
                    aux = raiz.getSiguiente();
                    if (raiz == aux)
                    {
                        raiz = null;
                    } else
                    {
                        raiz.setSiguiente(aux.getSiguiente());
                        raiz.getSiguiente().setAnterior(raiz);
                    }
                } else
                {
                    Nodo aux2 = raiz.getSiguiente();
                    boolean b = true;
                    while (aux2 != raiz && b)
                    {
                        if (s.compareTo(aux2.getSiguiente().getEtiqueta()) ==0)
                        {
                            aux = aux2.getSiguiente();
                            aux2.setSiguiente(aux.getSiguiente());
                            aux2.getSiguiente().setAnterior(aux2);
                            if (aux == raiz)
                            {
                                raiz = aux2;
                            }
                            b = false;
                        } else
                        {
                            aux2 = aux2.getSiguiente();
                        }
                    }
                }
            }
            if (aux != null)
            {
                aux.setSiguiente(null);
                aux.setAnterior(null);
            }
            return aux;
        }
    }

    @Override
    public Object elimina(Object obj, Object r)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object elimina(Object obj, Object r, Object b)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the raiz
     */
    public Nodo getRaiz()
    {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo raiz)
    {
        this.raiz = raiz;
    }

    public String desp()
    {
        String s = "";
        if (raiz != null)
        {
            Nodo aux = raiz.getSiguiente();
            do
            {
                s += aux.getSiguiente() + desp() + "\n";
            } while (aux != raiz.getSiguiente());
        } else
        {
            s = "No hay datos";
        }
        return s;
    }

    public String despRecurisvo(Nodo r ,Nodo aux)
    {
        String s = "";
        if (aux != r)
        {
           
                s += aux.getEtiqueta()+"\n" + despRecurisvo(r,aux.getSiguiente());
                
        } else
        {
            s += aux.getEtiqueta()+"\n";
        }
        return s;
    }
}
