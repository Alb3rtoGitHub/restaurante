
package restaurante.views;


import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurante.accesoAdatos.PedidoProductoData;
import restaurante.entidades.Pedido;


public class ConsultaPM extends javax.swing.JInternalFrame {

    PedidoProductoData ppData = new PedidoProductoData();
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    public ConsultaPM() {
        initComponents();
        getContentPane().setBackground(new Color(153,153,153));      
        armarCabecera();
        tamañoColumnas();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfMesero = new javax.swing.JTextField();
        jbMostrarLista = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setTitle("Consulta");

        jlTitulo.setBackground(new java.awt.Color(153, 153, 153));
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jbMostrarLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMostrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarListaActionPerformed

        try{

            borrarFilas();
            
            String mesero = jtfMesero.getText();
            
            if(mesero.equals("")){
                JOptionPane.showMessageDialog(this, "Debe completar el campo Mesero");
            }else{
                for (Pedido p :ppData.obtenerPedidosXMesero(mesero) ) {
                    String cobrada;
                    if(p.isCobrada() == true){
                        cobrada= "Si";
                    }else{
                        cobrada= "No";
                    }
                    modelo.addRow(new Object[]{p.getIdPedido(),p.getMesa().getNumeroMesa(),p.getFechaHoraPedido(),p.getImporte(),cobrada});
                }
            }

        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Debe completar el campo Mesero");
        }

    }//GEN-LAST:event_jbMostrarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbMostrarLista;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtfMesero;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("#");
        modelo.addColumn("Mesa");
        modelo.addColumn("Fecha y Hora");
        modelo.addColumn("Importe");
        modelo.addColumn("Cobrada");
        jTable1.setModel(modelo);
    }
    
    private void borrarFilas() {
        int f = jTable1.getRowCount() - 1; 
        for (; f >= 0; f--) { 
            modelo.removeRow(f);
        }
    }
    
    private void tamañoColumnas(){
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(145);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
    }

}
