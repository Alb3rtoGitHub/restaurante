package restaurante.views;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;


public class ConsultasView extends javax.swing.JInternalFrame {

    private DefaultComboBoxModel modeloCB = new DefaultComboBoxModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
        
    public ConsultasView() {
        initComponents();
        comboBox();
        getContentPane().setBackground(new Color(255,205,110));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbConsultas = new javax.swing.JComboBox<>();
        panelConsultas = new javax.swing.JPanel();

        setClosable(true);
        setTitle("Gestor de Consultas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consulta.png"))); // NOI18N
        jLabel1.setText("Consultas");

        jcbConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbConsultasActionPerformed(evt);
            }
        });

        panelConsultas.setBackground(new java.awt.Color(255, 205, 110));

        javax.swing.GroupLayout panelConsultasLayout = new javax.swing.GroupLayout(panelConsultas);
        panelConsultas.setLayout(panelConsultasLayout);
        panelConsultasLayout.setHorizontalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelConsultasLayout.setVerticalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jcbConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
            .addComponent(panelConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(panelConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbConsultasActionPerformed
        
        String seleccion = String.valueOf(jcbConsultas.getSelectedItem());
        
        if(seleccion.equals("Ingreso Total de una Fecha")){
            
            
            panelConsultas.removeAll();
            panelConsultas.repaint();
            ConsultaTD td = new ConsultaTD();
            
                //Centrar en X
                Dimension panelSize = panelConsultas.getSize();
                int x = (panelSize.width - td.getWidth()) / 2;
                td.setLocation(x, td.getY());
                
            td.setVisible(true);              
            panelConsultas.add(td);
            
            
        }else if(seleccion.equals("Productos de un Pedido")){
            
            panelConsultas.removeAll();
            panelConsultas.repaint();
            ConsultaPP pp = new ConsultaPP();
            
                //Centrar en X
                Dimension panelSize = panelConsultas.getSize();
                int x = (panelSize.width - pp.getWidth()) / 2;
                pp.setLocation(x, pp.getY());
                
            pp.setVisible(true);              
            panelConsultas.add(pp);
            
            
        }else if(seleccion.equals("Pedidos con Productos")){
            
            panelConsultas.removeAll();
            panelConsultas.repaint();
            ConsultaPCP pcp = new ConsultaPCP();
            
                //Centrar en X
                Dimension panelSize = panelConsultas.getSize();
                int x = (panelSize.width - pcp.getWidth()) / 2;
                pcp.setLocation(x, pcp.getY());
                
            pcp.setVisible(true);              
            panelConsultas.add(pcp);
            
            
        }else if(seleccion.equals("Pedidos por Mesero")){
            
            panelConsultas.removeAll();
            panelConsultas.repaint();
            ConsultaPM pm = new ConsultaPM();
            
                //Centrar en X
                Dimension panelSize = panelConsultas.getSize();
                int x = (panelSize.width - pm.getWidth()) / 2;
                pm.setLocation(x, pm.getY());
                
            pm.setVisible(true);              
            panelConsultas.add(pm);
            
            
        }else if(seleccion.equals("Pedidos Cobrados por Mesero en una Fecha")){
            
            panelConsultas.removeAll();
            panelConsultas.repaint();
            ConsultaPCMF pcmf = new ConsultaPCMF();
            
                //Centrar en X
                Dimension panelSize = panelConsultas.getSize();
                int x = (panelSize.width - pcmf.getWidth()) / 2;
                pcmf.setLocation(x, pcmf.getY());
                
            pcmf.setVisible(true);              
            panelConsultas.add(pcmf);
            
            
        }else if(seleccion.equals("Pedidos por Mesa en una Fecha entre Horas")){
            
            panelConsultas.removeAll();
            panelConsultas.repaint();
            ConsultaPMFH pmfh = new ConsultaPMFH();
            
                //Centrar en X
                Dimension panelSize = panelConsultas.getSize();
                int x = (panelSize.width - pmfh.getWidth()) / 2;
                pmfh.setLocation(x, pmfh.getY());
                
            pmfh.setVisible(true);              
            panelConsultas.add(pmfh);
            
            
        }
                
        
    }//GEN-LAST:event_jcbConsultasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcbConsultas;
    private javax.swing.JPanel panelConsultas;
    // End of variables declaration//GEN-END:variables

    private void comboBox(){
        jcbConsultas.removeAllItems();
        modeloCB.addElement("Ingreso Total de una Fecha");
        modeloCB.addElement("Productos de un Pedido");
        modeloCB.addElement("Pedidos con Productos");
        modeloCB.addElement("Pedidos por Mesero");
        modeloCB.addElement("Pedidos Cobrados por Mesero en una Fecha");
        modeloCB.addElement("Pedidos por Mesa en una Fecha entre Horas");
                        
        jcbConsultas.setModel(modeloCB);
    }
    
}
