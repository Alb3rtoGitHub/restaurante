
package restogrupo51.views;


import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import restogrupo51.accesoAdatos.PedidoProductoData;
import restogrupo51.entidades.Pedido;


public class ConsultaPCMF extends javax.swing.JInternalFrame {

    PedidoProductoData ppData = new PedidoProductoData();
    
    public ConsultaPCMF() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfMesero = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlLista = new javax.swing.JList<>();
        jbMostrarLista = new javax.swing.JButton();

        setClosable(true);

        jlTitulo.setBackground(new java.awt.Color(255, 205, 110));
        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Pedidos Cobrados por Mesero en una Fecha");
        jlTitulo.setOpaque(true);

        jLabel3.setText("Mesero:");

        jLabel4.setText("Fecha:");

        jScrollPane1.setViewportView(jlLista);

        jbMostrarLista.setText("Mostrar Lista");
        jbMostrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jbMostrarLista))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlTitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            LocalDate fecha = jdcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            List<Pedido> listaPedido = ppData.listarPedidosXMeseroYFecha(mesero, fecha);
            Pedido[] arreglo = listaPedido.toArray(new Pedido[0]);
            jlLista.setListData(arreglo);

        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Debe completar el campo Mesero y seleccionar una Fecha.");
        }

    }//GEN-LAST:event_jbMostrarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbMostrarLista;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JList<Pedido> jlLista;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfMesero;
    // End of variables declaration//GEN-END:variables
}
