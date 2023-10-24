
package restogrupo51.views;


import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restogrupo51.accesoAdatos.PedidoProductoData;
import restogrupo51.entidades.PedidoProducto;


public class ConsultaPCP extends javax.swing.JInternalFrame {

    PedidoProductoData ppData = new PedidoProductoData();
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    public ConsultaPCP() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
        armarCabecera();
        tamañoColumnas();
        llenarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTable();

        setClosable(true);

        jlTitulo.setBackground(new java.awt.Color(255, 205, 110));
        jlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Pedidos con Productos");
        jlTitulo.setOpaque(true);

        jtPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlTitulo)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTable jtPedido;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla(){
        
        try{
            
            for (PedidoProducto p :ppData.obtenerPedidosConProductos() ) {
                
                modelo.addRow(new Object[]{p.getPedido().getIdPedido(),p.getPedido().getMesa().getNumeroMesa(),p.getPedido().getNombreMesero(),p.getPedido().getFechaHoraPedido(),p.getPedido().getImporte(),p.getPedido().isCobrada(), p.getProducto().getNombreProducto(),p.getProducto().getPrecio(),p.getCantidad()});
            }
                        
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "e");
        }
        
    }
    
    private void armarCabecera() {
        modelo.addColumn("Pedido");
        modelo.addColumn("Mesa");
        modelo.addColumn("Mesero");
        modelo.addColumn("Fecha y Hora");
        modelo.addColumn("Importe");
        modelo.addColumn("Cobrada");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        jtPedido.setModel(modelo);
    }
        
    private void tamañoColumnas(){
        jtPedido.getColumnModel().getColumn(0).setPreferredWidth(20);
        jtPedido.getColumnModel().getColumn(1).setPreferredWidth(20);
        jtPedido.getColumnModel().getColumn(2).setPreferredWidth(50);
        jtPedido.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtPedido.getColumnModel().getColumn(4).setPreferredWidth(30);
        jtPedido.getColumnModel().getColumn(5).setPreferredWidth(30);
        jtPedido.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtPedido.getColumnModel().getColumn(7).setPreferredWidth(30);
        jtPedido.getColumnModel().getColumn(8).setPreferredWidth(30);     
        
    }

}
