
package restogrupo51.views;


import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import restogrupo51.accesoAdatos.PedidoProductoData;
import restogrupo51.entidades.Pedido;


public class ConsultaPM extends javax.swing.JInternalFrame {

    PedidoProductoData ppData = new PedidoProductoData();
    
    public ConsultaPM() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfMesero = new javax.swing.JTextField();
        jbMostrarLista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlLista = new javax.swing.JList<>();

        setClosable(true);

        jlTitulo.setBackground(new java.awt.Color(255, 205, 110));
        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Pedidos por Mesero");
        jlTitulo.setOpaque(true);

        jLabel2.setText("Mesero: ");

        jbMostrarLista.setText("Mostrar Lista");
        jbMostrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarListaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jlLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jbMostrarLista)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlTitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMostrarLista))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMostrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarListaActionPerformed

        try{

            String mesero = jtfMesero.getText();
            List<Pedido> listaPedido = ppData.obtenerPedidosXMesero(mesero);
            Pedido[] arreglo = listaPedido.toArray(new Pedido[0]);
            jlLista.setListData(arreglo);

        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Debe completar el campo Mesero");
        }

    }//GEN-LAST:event_jbMostrarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbMostrarLista;
    private javax.swing.JList<Pedido> jlLista;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfMesero;
    // End of variables declaration//GEN-END:variables
}
