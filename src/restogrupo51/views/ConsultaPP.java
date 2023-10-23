
package restogrupo51.views;


import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import restogrupo51.accesoAdatos.PedidoProductoData;
import restogrupo51.entidades.PedidoProducto;


public class ConsultaPP extends javax.swing.JInternalFrame {

    PedidoProductoData ppData = new PedidoProductoData();
    
    public ConsultaPP() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfPedido = new javax.swing.JTextField();
        jbMostrarLista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlLista = new javax.swing.JList<>();

        setClosable(true);

        jlTitulo.setBackground(new java.awt.Color(255, 205, 110));
        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Productos de un Pedido");
        jlTitulo.setOpaque(true);

        jLabel3.setText("Pedido:");

        jbMostrarLista.setText("Mostrar Lista");
        jbMostrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarListaActionPerformed(evt);
            }
        });

        jlLista.setBackground(new java.awt.Color(255, 204, 110));
        jScrollPane1.setViewportView(jlLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jbMostrarLista)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlTitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMostrarLista))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMostrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarListaActionPerformed

        try{

            int pedido = Integer.parseInt(jtfPedido.getText());

            List<PedidoProducto> listaPedido = ppData.obtenerPPXPedido(pedido);
            PedidoProducto[] arreglo = listaPedido.toArray(new PedidoProducto[0]);
            jlLista.setListData(arreglo);

        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Debe completar el campo Pedido.");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Ingrese un numero de pedido valido.");
        }

    }//GEN-LAST:event_jbMostrarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbMostrarLista;
    private javax.swing.JList<PedidoProducto> jlLista;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfPedido;
    // End of variables declaration//GEN-END:variables
}
