
package restaurante.views;


import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restaurante.accesoAdatos.PedidoProductoData;
import restaurante.entidades.PedidoProducto;


public class ConsultaPP extends javax.swing.JInternalFrame {

    PedidoProductoData ppData = new PedidoProductoData();
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    public ConsultaPP() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        armarCabecera();
        tamañoColumnas();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfPedido = new javax.swing.JTextField();
        jbMostrarLista = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();

        setClosable(true);
        setTitle("Consulta");

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

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jbMostrarLista)
                .addGap(85, 85, 85))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMostrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarListaActionPerformed

        try{
            
            borrarFilas();

            int pedido = Integer.parseInt(jtfPedido.getText());

            for (PedidoProducto p :ppData.obtenerPPXPedido(pedido) ) {
                modelo.addRow(new Object[]{p.getProducto().getIdProducto(),p.getProducto().getCodigoProducto(), p.getProducto().getNombreProducto(),p.getProducto().getPrecio(),p.getCantidad()});
            }

        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Debe completar el campo Pedido.");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Ingrese un numero de pedido valido.");
        }

    }//GEN-LAST:event_jbMostrarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbMostrarLista;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTextField jtfPedido;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("#");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        jtProducto.setModel(modelo);
    }
    
    private void borrarFilas() {
        int f = jtProducto.getRowCount() - 1; 
        for (; f >= 0; f--) { 
            modelo.removeRow(f);
        }
    }
    
    private void tamañoColumnas(){
        jtProducto.getColumnModel().getColumn(0).setPreferredWidth(30);
        jtProducto.getColumnModel().getColumn(1).setPreferredWidth(60);
        jtProducto.getColumnModel().getColumn(2).setPreferredWidth(160);
        jtProducto.getColumnModel().getColumn(3).setPreferredWidth(80);
        jtProducto.getColumnModel().getColumn(4).setPreferredWidth(60);
    }

}
