
package restogrupo51;

import restogrupo51.accesoAdatos.MesaData;
import restogrupo51.entidades.Mesa;


public class RestoGrupo51 {

    
    public static void main(String[] args) {
        
        /*    MESA     */
        
            MesaData mesaData=new MesaData();

            /*AGREGAR MESA*/
            Mesa mesa1=new Mesa(10, 2, true, true);
            Mesa mesa2=new Mesa(11, 4, true,true);
            Mesa mesa3=new Mesa(12, 6, true, true);
            //mesaData.agregarMesa(mesa1);
            //mesaData.agregarMesa(mesa2);
            //mesaData.agregarMesa(mesa3);


            /*MODIFICAR MESA*/             
            //Mesa mesaModificada = new Mesa(2, 22, 4, false, true);
            //mesaData.modificarMesa(mesaModificada);


            /*ELIMINAR MESA*/                     
            //mesaData.eliminarMesa(2);


            /*BUSCAR POR ID DE MESA*/
            //System.out.println( mesaData.buscarMesaPorId(3));


            /*BUSCAR POR NUMERO DE MESA*/
            //System.out.println( mesaData.buscarMesaPorNumero(22));


            /*LISTAR MESAS*/
            /*
            for (Mesa listaMesas : mesaData.listaDeMesas()) {
                System.out.println(listaMesas);
                System.out.println("");
            }
            */
        
        
        
        
        
        
        
    }
    
}
