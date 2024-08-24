package br.com.projeto5.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import br.com.projeto5.dto.VendaDTO;
import br.com.projeto5.ctr.VendaCTR;
import br.com.projeto5.dto.ProdutoDTO;
import br.com.projeto5.ctr.ProdutoCTR;
import br.com.projeto5.dto.ClienteDTO;
import br.com.projeto5.ctr.ClienteCTR;

import java.util.Date;

public class VendaVIEW extends javax.swing.JInternalFrame {

    VendaCTR vendaCTR = new VendaCTR();
    VendaDTO vendaDTO = new VendaDTO();
    ProdutoCTR produtoCTR = new ProdutoCTR();
    ProdutoDTO produtoDTO = new ProdutoDTO();
    ClienteDTO clienteDTO = new ClienteDTO();
    ClienteCTR clienteCTR = new ClienteCTR();

    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_cli;
    DefaultTableModel modelo_jtl_consultar_pro;
    DefaultTableModel modelo_jtl_consultar_pro_selecionado;

    public VendaVIEW() {
        initComponents();

        liberaCampos(false);
        liberaBotoes(true, false, false, true);

        modelo_jtl_consultar_cli = (DefaultTableModel) jtl_consultar_cli.getModel();
        modelo_jtl_consultar_pro = (DefaultTableModel) jtl_consultar_pro.getModel();
        modelo_jtl_consultar_pro_selecionado = (DefaultTableModel) jtl_consultar_pro_selecionado.getModel();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void gravar() {
        vendaDTO.setDat_vend(new Date());
        vendaDTO.setVal_vend(Double.parseDouble(TotalVenda.getText()));
        clienteDTO.setId_cli(Integer.parseInt(String.valueOf(
                jtl_consultar_cli.getValueAt(jtl_consultar_cli.getSelectedRow(), 0))));

        JOptionPane.showMessageDialog(null,
                vendaCTR.inserirVenda(vendaDTO, clienteDTO, jtl_consultar_pro_selecionado));
    }

    private void preencheTabelaCliente(String nome_cli) {
        try {
            modelo_jtl_consultar_cli.setNumRows(0);

            clienteDTO.setNome_cli(nome_cli);
            rs = clienteCTR.consultarCliente(clienteDTO, 1);
            while (rs.next()) {
                modelo_jtl_consultar_cli.addRow(new Object[]{
                    rs.getString("id_cli"),
                    rs.getString("nome_cli")
                });
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void preencheTabelaProduto(String nome_prod) {
        try {
            modelo_jtl_consultar_pro.setNumRows(0);
            produtoDTO.setNome_prod(nome_prod);
            rs = produtoCTR.consultarProduto(produtoDTO, 1);

            while (rs.next()) {
                modelo_jtl_consultar_pro.addRow(new Object[]{
                    rs.getString("id_prod"),
                    rs.getString("nome_prod"),
                    rs.getString("p_venda_prod")
                });
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void calculaTotalVenda() {
        try {
            double total = 0;
            for (int i = 0; i < jtl_consultar_pro_selecionado.getRowCount(); i++) {
                total += (Double.parseDouble(String.valueOf(
                        jtl_consultar_pro_selecionado.getValueAt(i, 2))))
                        * Integer.parseInt(String.valueOf(
                                jtl_consultar_pro_selecionado.getValueAt(i, 3)));
            }

            String totalFormatado = String.format("%.2f", total);
            TotalVenda.setText(totalFormatado.replace(",", "."));

        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void adicionaProdutoSelecionado(int id_prod, String nome_prod, double p_venda_prod) {
        try {
            modelo_jtl_consultar_pro_selecionado.addRow(new Object[]{
                id_prod, nome_prod, p_venda_prod
            });
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void removeProdutoSelecionado(int linha_selecionada) {
        try {
            if (linha_selecionada >= 0) {
                modelo_jtl_consultar_pro_selecionado.removeRow(linha_selecionada);
                calculaTotalVenda();
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void liberaCampos(boolean a) {
        pesquisa_nome_cli.setEnabled(a);
        btnPesquisarCli.setEnabled(a);
        jtl_consultar_cli.setEnabled(a);
        pesquisar_nome_pro.setEnabled(a);
        btnPesquisarPro.setEnabled(a);
        jtl_consultar_pro.setEnabled(a);
        btnProAdd.setEnabled(a);
        btnProRem.setEnabled(a);
        jtl_consultar_pro_selecionado.setEnabled(a);
        TotalVenda.setText("0.00");
    }

    private void limpaCampos() {
        pesquisa_nome_cli.setText("");
        modelo_jtl_consultar_cli.setNumRows(0);
        pesquisar_nome_pro.setText("");
        modelo_jtl_consultar_pro.setNumRows(0);
        modelo_jtl_consultar_pro_selecionado.setNumRows(0);
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnSair.setEnabled(d);
    }

    private boolean verificaPreenchimento() {
        if (jtl_consultar_cli.getSelectedRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Deve ser selecionado um Cliente!");
            jtl_consultar_cli.requestFocus();
            return false;
        } else {
            if (jtl_consultar_pro_selecionado.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(null, "É necessário adicionar pelo menos um produto no pedido");
                jtl_consultar_pro_selecionado.requestFocus();
                return false;
            } else {
                int verifica = 0;
                for (int i = 0; i < jtl_consultar_pro_selecionado.getRowCount(); i++) {
                    if (String.valueOf(jtl_consultar_pro_selecionado.getValueAt(i, 3)).equalsIgnoreCase("null")) {
                        verifica++;
                    }
                }
                if (verifica > 0) {
                    JOptionPane.showMessageDialog(null,
                            "A quantidade de cada produto vendido deve ser informado");
                    jtl_consultar_pro_selecionado.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pesquisa_nome_cli = new javax.swing.JTextField();
        btnPesquisarCli = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_cli = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        TotalVenda = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pesquisar_nome_pro = new javax.swing.JTextField();
        btnPesquisarPro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_pro = new javax.swing.JTable();
        btnProAdd = new javax.swing.JButton();
        btnProRem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtl_consultar_pro_selecionado = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1.setText("jTextField1");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Cliente:");

        btnPesquisarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarCli.setText("Buscar");
        btnPesquisarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCliActionPerformed(evt);
            }
        });

        jtl_consultar_cli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_cli);
        if (jtl_consultar_cli.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_cli.getColumnModel().getColumn(0).setResizable(false);
            jtl_consultar_cli.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtl_consultar_cli.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Total Venda:");

        TotalVenda.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        TotalVenda.setForeground(new java.awt.Color(51, 204, 0));
        TotalVenda.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(112, 112, 112)
                        .addComponent(TotalVenda))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pesquisa_nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnPesquisarCli))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pesquisa_nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TotalVenda))
                .addGap(40, 40, 40))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vendas");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovo)
                .addGap(131, 131, 131)
                .addComponent(btnSalvar)
                .addGap(133, 133, 133)
                .addComponent(btnCancelar)
                .addGap(131, 131, 131)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair))
                .addGap(29, 29, 29))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Descrição:");

        btnPesquisarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarPro.setText("Buscar");
        btnPesquisarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProActionPerformed(evt);
            }
        });

        jtl_consultar_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor"
            }
        ));
        jScrollPane2.setViewportView(jtl_consultar_pro);
        if (jtl_consultar_pro.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_pro.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtl_consultar_pro.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        btnProAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/prod_add.png"))); // NOI18N
        btnProAdd.setText("Adicionar");
        btnProAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProAddActionPerformed(evt);
            }
        });

        btnProRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/prod_rem.png"))); // NOI18N
        btnProRem.setText("Remover");
        btnProRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProRemActionPerformed(evt);
            }
        });

        jtl_consultar_pro_selecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "Qtnd"
            }
        ));
        jtl_consultar_pro_selecionado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtl_consultar_pro_selecionadoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtl_consultar_pro_selecionado);
        if (jtl_consultar_pro_selecionado.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_pro_selecionado.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtl_consultar_pro_selecionado.getColumnModel().getColumn(1).setPreferredWidth(300);
            jtl_consultar_pro_selecionado.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar_nome_pro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisarPro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnProAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProRem)
                .addGap(166, 166, 166))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pesquisar_nome_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarPro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProAdd)
                    .addComponent(btnProRem))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificaPreenchimento()) {
            gravar();
            limpaCampos();
            liberaCampos(false);
            liberaBotoes(true, false, false, true);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_cli.setNumRows(0);
        modelo_jtl_consultar_pro.setNumRows(0);
        liberaBotoes(true, false, false, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCliActionPerformed
        preencheTabelaCliente(pesquisa_nome_cli.getText());
    }//GEN-LAST:event_btnPesquisarCliActionPerformed

    private void btnPesquisarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProActionPerformed
        preencheTabelaProduto(pesquisar_nome_pro.getText());
    }//GEN-LAST:event_btnPesquisarProActionPerformed

    private void btnProAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProAddActionPerformed
        adicionaProdutoSelecionado(
                Integer.parseInt(String.valueOf(jtl_consultar_pro.getValueAt(jtl_consultar_pro.getSelectedRow(), 0))),
                String.valueOf(jtl_consultar_pro.getValueAt(jtl_consultar_pro.getSelectedRow(), 1)),
                Double.parseDouble(String.valueOf(jtl_consultar_pro.getValueAt(jtl_consultar_pro.getSelectedRow(), 2)))
        );
    }//GEN-LAST:event_btnProAddActionPerformed

    private void btnProRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProRemActionPerformed
        removeProdutoSelecionado(jtl_consultar_pro_selecionado.getSelectedRow());
    }//GEN-LAST:event_btnProRemActionPerformed

    private void jtl_consultar_pro_selecionadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtl_consultar_pro_selecionadoKeyReleased
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            calculaTotalVenda();
        }
    }//GEN-LAST:event_jtl_consultar_pro_selecionadoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalVenda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarCli;
    private javax.swing.JButton btnPesquisarPro;
    private javax.swing.JButton btnProAdd;
    private javax.swing.JButton btnProRem;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jtl_consultar_cli;
    private javax.swing.JTable jtl_consultar_pro;
    private javax.swing.JTable jtl_consultar_pro_selecionado;
    private javax.swing.JTextField pesquisa_nome_cli;
    private javax.swing.JTextField pesquisar_nome_pro;
    // End of variables declaration//GEN-END:variables
}
