
package restogrupo51.views;


import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import restogrupo51.accesoAdatos.PedidoProductoData;
import restogrupo51.entidades.PedidoProducto;


public class ConsultaPCP extends javax.swing.JInternalFrame {

    PedidoProductoData ppData = new PedidoProductoData();
    
    public ConsultaPCP() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        llenarLista();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlLista = new javax.swing.JList<>();

        setClosable(true);

        jlTitulo.setBackground(new java.awt.Color(255, 205, 110));
        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Pedidos con Productos");
        jlTitulo.setOpaque(true);

        jScrollPane1.setViewportView(jlLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlTitulo)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<PedidoProducto> jlLista;
    private javax.swing.JLabel jlTitulo;
    // End of variables declaration//GEN-END:variables

    private void llenarLista(){
        
        try{
                                               
            List<PedidoProducto> listaPedido = ppData.obtenerPedidosConProductos();
            PedidoProducto[] arreglo = listaPedido.toArray(new PedidoProducto[0]);
            jlLista.setListData(arreglo);
            
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "e");
        }
        
    }

}
