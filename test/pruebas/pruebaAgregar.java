/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import control.EjemplarDao;
import objetosNegocio.Libro;

/**
 *
 * @author alexis
 */
public class pruebaAgregar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Libro libro=new Libro();
       
       libro.setAutor("autor");
       libro.setDescripccion("asdasdasdasd");
       libro.setGenero("CACA");
       libro.setNombre("POOP");
       libro.setCantidad(0);
       
       EjemplarDao dao = new EjemplarDao();
       dao.Registrar(libro);
       
    }
    
}
