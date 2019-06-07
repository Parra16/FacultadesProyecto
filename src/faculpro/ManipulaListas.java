/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculpro;

import cjb.ci.Mensaje;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.tools.FileObject;
import facultades.*;

/**
 *
 * @author PARRA
 */
public class ManipulaListas {
    


    public static Nodo inserta(Nodo raiz, String[] s, int nivel, Nodo obj, Nodo ant) {
        Nodo tmp = null;
        if (s.length - 1 == nivel) {
            LDLC lt = new LDLC();
            lt.setRaiz(raiz);
            lt.inserta(obj);
            //obj.setArriba(ant);
            Nodo x =lt.getRaiz();
            x.setArriba(ant);
            return x;//lt.getRaiz();
        } else {
            tmp = busqueda(raiz, s[nivel]);
            tmp.setAbajo(inserta(tmp.getAbajo(), s, nivel + 1, obj, tmp));
            
            return raiz;
        }
    }

    public static Nodo busqueda(Nodo raiz, String s) {
        Nodo aux = raiz;
        if(raiz == null) return raiz;
        do {
            if (aux.getEtiqueta().equals(s)) {
                break;
            } else {
                aux = aux.getSiguiente();
            }
        } while (aux != raiz);
        return aux;
    }

    /*public static Nodo elimina(Nodo raiz, String[] s, int nivel, Nodo n) {
        if (s.length - 1 == nivel) {
            Nodo aux = busqueda(raiz, s[nivel]);
            LDLC lt = new LDLC();
            if (aux.getAbajo() == null) {
                lt.setRaiz(raiz);
                n=(Nodo)lt.elimina(n.getEtiqueta());
                n.setArriba(null);
                n.setEtiqueta(aux.getEtiqueta());
                n.setObj(aux.getObj());
            } else {
                System.out.println("Hay datos adicionales en este nivel");
            }
            return lt.getRaiz();
        } else {
            Nodo tmp = busqueda(raiz, s[nivel]);
            tmp.setAbajo(elimina(tmp.getAbajo(), s, nivel + 1, n));
            return raiz;
        }
    }*/
    public static Nodo[] elimina(Nodo r, String s[], int nivel, Nodo n)
    {
        Nodo aux[] = new Nodo[2];
        if(s.length -1 == nivel)
        {
            
            LDLC lt = new LDLC();
            lt.setRaiz(r);
            n = (Nodo) lt.elimina(s[nivel]);
            if (n.getArriba()!= null)
            {
                if(n.getSiguiente()==n)
                {
                    n.getArriba().setAbajo(null);
                }else
                {
                    n.getArriba().setAbajo(n.getAnterior());
                }
                
                n.setArriba(null);
            }
            //n.setDown(null); ???
            aux[0] = lt.getRaiz();
            aux[1]=n;
            return aux;
        }else
        {
            Nodo tmp = busqueda(r,s[nivel]);
            aux = elimina(tmp.getAbajo(), s, nivel+1,n);
            tmp.setAbajo(aux[0]);
            aux[0] = r;///
            return aux;
        }
    }

    public static Nodo busca(Nodo raiz, String[] s, int nivel ){
        if (s.length - 1 == nivel) {
            Nodo aux = busqueda(raiz, s[nivel]);
            return aux;
        } else if(s.length==0)
        {
            return null;
        }else
        {
            Nodo tmp = busqueda(raiz,s[nivel]);
             return busca(tmp.getAbajo(), s, nivel + 1);
        }
    }

    

    /*public static Nodo carga(JFrame jf) {
        LDLC lt = new LDLC();
        try {
            FileInputStream fis = new FileInputStream("facultades.dat");
            ObjectInputStream arch = new ObjectInputStream(fis); 
            Nodo aux;
            aux = (Nodo) arch.readObject();
            String s[] = new String [1];
            boolean band=true;
            while (aux != null) {
                band=false;
                if (aux.getObj() instanceof Facultad) {
                    s[0] = aux.getEtiqueta();
                    System.out.println(aux.getEtiqueta());
                } else {
                    if (aux.getObj() instanceof Carrera) {
                        Carrera obj = (Carrera) aux.getObj();
                        s = new String[2];
                        s[0] = obj.getFacultad();
                        s[1] = obj.getNomCarr();
                        System.out.println(aux.getEtiqueta());
                    } else {
                        if (aux.getObj() instanceof Materia) {
                            Materia obj = (Materia) aux.getObj();
                            s = new String[3];
                            s[0] = obj.getFacultad();
                            s[1] = obj.getCarrera();
                            s[2] = obj.getNommateria();
                            System.out.println(aux.getEtiqueta());
                        } else {
                            if (aux.getObj() instanceof Grupo) {
                                Grupo obj = (Grupo) aux.getObj();
                                s = new String[4];
                                s[0] = obj.getFacultad();
                                s[1] = obj.getCarrera();
                                s[2] = obj.getMateria();
                                s[3] = obj.getClavegrupo();
                                System.out.println(aux.getEtiqueta());
                            }else{
                                if (aux.getObj() instanceof Alumno) {
                                Alumno obj = (Alumno) aux.getObj();
                                s = new String[5];
                                s[0] = obj.getFacultad();
                                s[1] = obj.getCarrera();
                                s[2] = obj.getMateria();
                                s[3] = obj.getGrupo();
                                s[4] = obj.getNomalumno();
                                System.out.println(aux.getEtiqueta());
                                }
                            }
                        }
                    }
                }
                lt.setRaiz(ManipulaListas.inserta(lt.getRaiz(), s, 0, aux, null));
                aux=(Nodo)arch.readObject();
            }
            
            if (band) {
                Mensaje.error(jf, "Archivo vacio");
            }
            

            arch.close();
            
        } catch (FileNotFoundException ex) {
            Mensaje.error(null, "No se encontro la direccion");
        } catch (Exception e) {
            Mensaje.error(null, "ERROR..." + e.toString());

        }
        
        return lt.getRaiz();// Puede retornar nulo
    }*/
    
    public static Nodo carga(JFrame jf) {
        Nodo r = null;
        try {
            FileInputStream fis = new FileInputStream("facultades.dat");
            ObjectInputStream arch = new ObjectInputStream(fis); 
            String s[]= new String[1];
            r = cR(null, s, arch);
            arch.close();
        } catch (FileNotFoundException ex) {
            Mensaje.error(null, "No se encontro la direccion");
        } catch (Exception e) {
            Mensaje.error(null, "ERROR..." + e.toString());
        }
        return r;// Puede retornar nulo
    }
    
    public static Nodo cR(Nodo r, String[] s, ObjectInputStream arch) {
        try {
            Nodo aux = (Nodo) arch.readObject();
            if(aux == null)
            {
                return r;
            }
            if (aux.getObj() instanceof Facultad) {
                
                s = new String[1];
                s[0] = aux.getEtiqueta();
                //r = inserta(r, s, 0, aux, null);
                System.out.println(aux.getEtiqueta());
                r = inserta(r, s, 0, aux, null);                
                r=cR(aux,s,arch);
                
                
            } else if (aux.getObj() instanceof Carrera) {
                String sAux[] = new String[2];
                sAux[0] = s[0];
                sAux[1] = aux.getEtiqueta();
                r = inserta(r, sAux, 0, aux, null);
                System.out.println(aux.getEtiqueta());
                r = cR(r,sAux,arch);

                    
            } else if (aux.getObj() instanceof Materia) {
                String sAux[] = new String[3];
                sAux[0] = s[0];
                sAux[1] = s[1];
                sAux[2] = aux.getEtiqueta();
                r = inserta(r, sAux, 0, aux, null);
                System.out.println(aux.getEtiqueta());
                r = cR(r,sAux,arch);


            } else if (aux.getObj() instanceof Grupo) {
                String sAux[] = new String[4];
                sAux[0] = s[0];
                sAux[1] = s[1];
                sAux[2] = s[2];
                sAux[3] = aux.getEtiqueta();
                r = inserta(r, sAux, 0, aux, null);
                System.out.println(aux.getEtiqueta());
                r = cR(r,sAux,arch);


            }else if (aux.getObj() instanceof Alumno) {
                String sAux[] = new String[5];
                sAux[0] = s[0];
                sAux[1] = s[1];
                sAux[2] = s[2];
                sAux[3] = s[3];
                sAux[4] = aux.getEtiqueta();
                r = inserta(r, sAux, 0, aux,null);
            }
        } catch (FileNotFoundException ex) {
            Mensaje.error(null, "No se encontro la direccion");
        } catch (ClassNotFoundException ex) {
            Mensaje.error(null, "ERROR..." + ex.toString());
        } catch (IOException e) {
            Mensaje.error(null, "ERROR..." + e.toString());
        }
        return r;// Puede retornar nulo
    }

    public static void guarda(Nodo r, JFrame jf)
    {

        try
        {
            FileOutputStream fos = new FileOutputStream("facultades.dat");
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            gr(arch, r, jf);
            arch.close();
        } catch (FileNotFoundException x)
        {
            System.out.println(x.toString());

        } catch (IOException ex)
        {
            System.out.println("no se epudo abrir el archivo");
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
            Mensaje.error(jf, "no se guardo el archivo");
        }
    }

    public static void gr(ObjectOutputStream arch, Nodo r, JFrame jf)
    {
        while (r != null)
        {
            LDLC lt = new LDLC();
            lt.setRaiz(r);
            Nodo aux = (Nodo) lt.elimina(r.getSiguiente().getEtiqueta());
            Nodo tmp = aux.getAbajo();
            aux.setAbajo(null);
            aux.setArriba(null);
            r = lt.getRaiz();
            try
            {
                arch.writeObject(aux);//tiene que se aux
            } catch (IOException ex)
            {
                System.out.println("no se puede guardar en el archivo " + ex.toString());
            } catch (Exception x)
            {
                System.out.println("archivo no guardado " + x.toString());
                Mensaje.error(jf, "error en el writeObject");
            }

            gr(arch, tmp, jf);
        }
    }

    public static void gr1(Nodo r) {

        while (r != null) {
            LDLC lt = new LDLC();
            lt.setRaiz(r);
            Nodo aux = (Nodo) lt.elimina(r.getSiguiente().getEtiqueta());
            Nodo tmp = aux.getAbajo();
            aux.setAbajo(null);
            aux.setArriba(null);
            r = lt.getRaiz();
            System.out.println("DE =" + aux.getEtiqueta());

            gr1(tmp);
        }
    }

}

