package br.com.projeto5.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.projeto5.dto.FornecedorDTO;
import br.com.projeto5.ctr.FornecedorCTR;
import br.com.projeto5.dto.ProdutoDTO;
import br.com.projeto5.ctr.ProdutoCTR;

public class ProdutoVIEW extends javax.swing.JInternalFrame {

    FornecedorDTO fornecedorDTO = new FornecedorDTO();
    FornecedorCTR fornecedorCTR = new FornecedorCTR();
    ProdutoDTO produtoDTO = new ProdutoDTO();
    ProdutoCTR produtoCTR = new ProdutoCTR();

    int gravar_alterar;

    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_produto;
    DefaultTableModel modelo_jtl_consultar_fornecedor;

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public ProdutoVIEW() {
        initComponents();

        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_produto = (DefaultTableModel) jtl_consultar_produto.getModel();
        modelo_jtl_consultar_fornecedor = (DefaultTableModel) jtl_consultar_fornecedor.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_fornecedor = new javax.swing.JTable();
        pesquisa_nome_produto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_produto = new javax.swing.JTable();
        pesquisa_nome_fornecedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nome_prod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        desc_prod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        qtd_estoque_produto = new javax.swing.JTextField();
        p_custo_prod = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        p_venda_prod = new javax.swing.JTextField();
        cod_bar_prod = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnConsultaProduto = new javax.swing.JButton();
        btnConsultaFornecedor = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jLabel11.setText("jLabel11");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cadastro de Produto");

        jtl_consultar_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_fornecedor);
        if (jtl_consultar_fornecedor.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_fornecedor.getColumnModel().getColumn(0).setResizable(false);
            jtl_consultar_fornecedor.getColumnModel().getColumn(0).setPreferredWidth(60);
            jtl_consultar_fornecedor.getColumnModel().getColumn(1).setResizable(false);
            jtl_consultar_fornecedor.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consulta - Produto");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Nome:");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(btnNovo)
                .addGap(63, 63, 63)
                .addComponent(btnSalvar)
                .addGap(59, 59, 59)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addGap(62, 62, 62)
                .addComponent(btnSair)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jtl_consultar_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_produtoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_produto);
        if (jtl_consultar_produto.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_produto.getColumnModel().getColumn(0).setResizable(false);
            jtl_consultar_produto.getColumnModel().getColumn(0).setPreferredWidth(60);
            jtl_consultar_produto.getColumnModel().getColumn(1).setResizable(false);
            jtl_consultar_produto.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Fornecedor:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Código:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("P.Custo:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Estoque:");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("P.Venda:");

        btnConsultaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/pesquisar.png"))); // NOI18N
        btnConsultaProduto.setText("Ok");
        btnConsultaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultaProdutoMouseClicked(evt);
            }
        });

        btnConsultaFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto5/view/imagens/pesquisar.png"))); // NOI18N
        btnConsultaFornecedor.setText("Ok");
        btnConsultaFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultaFornecedorMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Selecione o Fornecedor do Produto cadastrado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisa_nome_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultaFornecedor))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(p_custo_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(qtd_estoque_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(p_venda_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(desc_prod)
                            .addComponent(nome_prod)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cod_bar_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pesquisa_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultaProduto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisa_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(nome_prod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desc_prod)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p_venda_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(p_custo_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod_bar_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(qtd_estoque_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pesquisa_nome_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(btnConsultaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (gravar_alterar == 1) {
            gravar();
            gravar_alterar = 0;
        } else {
            if (gravar_alterar == 2) {
                alterar();
                gravar_alterar = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Erro no sistema");
            }
        }

        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_fornecedor.setNumRows(0);
        liberaBotoes(true, false, false, false, true);
        gravar_alterar = 0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_fornecedor.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jtl_consultar_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_produtoMouseClicked
        preencheCamposProduto(Integer.parseInt(String.valueOf(
                jtl_consultar_produto.getValueAt(
                        jtl_consultar_produto.getSelectedRow(), 0))));
        liberaBotoes(false, true, true, true, true);
    }//GEN-LAST:event_jtl_consultar_produtoMouseClicked

    private void btnConsultaFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaFornecedorMouseClicked
        preencheTabelaFornecedor(pesquisa_nome_fornecedor.getText());
    }//GEN-LAST:event_btnConsultaFornecedorMouseClicked

    private void btnConsultaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaProdutoMouseClicked
        preencheTabelaProduto(pesquisa_nome_produto.getText());
    }//GEN-LAST:event_btnConsultaProdutoMouseClicked

    private void gravar() {
        try {
            produtoDTO.setNome_prod(nome_prod.getText());
            produtoDTO.setDesc_prod(desc_prod.getText());
            produtoDTO.setCod_bar_prod(qtd_estoque_produto.getText());
            produtoDTO.setP_custo_prod(Double.parseDouble(p_custo_prod.getText()));
            produtoDTO.setP_venda_prod(Double.parseDouble(p_venda_prod.getText()));
            produtoDTO.setQuantidade_estoque(Integer.parseInt(qtd_estoque_produto.getText()));
            fornecedorDTO.setId_for(Integer.parseInt(String.valueOf(
                    jtl_consultar_fornecedor.getValueAt(
                            jtl_consultar_fornecedor.getSelectedRow(), 0))));

            JOptionPane.showMessageDialog(null, produtoCTR.inserirProduto(produtoDTO, fornecedorDTO));
        } catch (Exception e) {
            System.out.println("Erro ao gravar!" + e.getMessage());
        }
    }

    private void alterar() {
        try {
            produtoDTO.setNome_prod(nome_prod.getText());
            produtoDTO.setDesc_prod(desc_prod.getText());
            produtoDTO.setCod_bar_prod(cod_bar_prod.getText());
            produtoDTO.setP_custo_prod(Double.parseDouble(p_custo_prod.getText()));
            produtoDTO.setP_venda_prod(Double.parseDouble(p_venda_prod.getText()));
            produtoDTO.setQuantidade_estoque(Integer.parseInt(qtd_estoque_produto.getText()));
            fornecedorDTO.setId_for(Integer.parseInt(String.valueOf(
                    jtl_consultar_fornecedor.getValueAt(
                            jtl_consultar_fornecedor.getSelectedRow(), 0))));

            JOptionPane.showMessageDialog(null, produtoCTR.alterarProduto(produtoDTO, fornecedorDTO));
        } catch (Exception e) {
            System.out.println("Erro ao gravar!" + e.getMessage());
        }
    }

    private void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Produto?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    produtoCTR.excluirProduto(produtoDTO));
        }
    }

    private void liberaCampos(boolean a) {
        nome_prod.setEnabled(a);
        desc_prod.setEnabled(a);
        qtd_estoque_produto.setEnabled(a);
        p_custo_prod.setEnabled(a);
        p_venda_prod.setEnabled(a);
        cod_bar_prod.setEnabled(a);
        qtd_estoque_produto.setEnabled(a);
        pesquisa_nome_fornecedor.setEnabled(a);
        jtl_consultar_fornecedor.setEnabled(a);
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }

    private void limpaCampos() {
        nome_prod.setText("");
        desc_prod.setText("");
        qtd_estoque_produto.setText("");
        p_custo_prod.setText("");
        p_venda_prod.setText("");
        cod_bar_prod.setText("");
        qtd_estoque_produto.setText("");
        pesquisa_nome_fornecedor.setText("");
        modelo_jtl_consultar_fornecedor.setNumRows(0);
    }

    private void preencheTabelaProduto(String nome_prod) {
        try {
            // Limpa todas as linhas
            modelo_jtl_consultar_produto.setNumRows(0);

            produtoDTO.setNome_prod(nome_prod);
            rs = produtoCTR.consultarProduto(produtoDTO, 1);
            while (rs.next()) {
                modelo_jtl_consultar_produto.addRow(new Object[]{
                    rs.getString("id_prod"),
                    rs.getString("nome_prod"),});
            }
        } catch (Exception e) {
            System.out.println("Erro ao preencher a tabela produto!" + e.getMessage());
        } finally {
            produtoCTR.CloseDB();
        }
    }

    private void preencheCamposProduto(int id_prod) {
        try {
            produtoDTO.setId_prod(id_prod);
            rs = produtoCTR.consultarProduto(produtoDTO, 2);
            if (rs.next()) {
                limpaCampos();

                nome_prod.setText(rs.getString("nome_prod"));
                desc_prod.setText(rs.getString("desc_prod"));
                cod_bar_prod.setText(rs.getString("cod_bar_prod"));
                p_custo_prod.setText(rs.getString("p_custo_prod"));
                p_venda_prod.setText(rs.getString("p_venda_prod"));
                qtd_estoque_produto.setText(rs.getString("quantidade_estoque"));

                // Colocando os dados do fornecedor
                modelo_jtl_consultar_fornecedor.setNumRows(0);
                modelo_jtl_consultar_fornecedor.addRow(new Object[]{rs.getInt("id_for"), rs.getString("nome_for"),});
                jtl_consultar_fornecedor.setRowSelectionInterval(0, 0);
            }

            gravar_alterar = 2;
            liberaCampos(true);

        } catch (Exception e) {
            System.out.println("Erro preencheCamposProduto: " + e.getMessage());
        } finally {
            produtoCTR.CloseDB();
        }
    }

    private void preencheTabelaFornecedor(String nome_for) {
        try {
            // Limpa todas as linhas
            modelo_jtl_consultar_fornecedor.setNumRows(0);

            fornecedorDTO.setNome_for(nome_for);
            rs = fornecedorCTR.consultarFornecedor(fornecedorDTO, 1);
            while (rs.next()) {
                modelo_jtl_consultar_fornecedor.addRow(new Object[]{
                    rs.getString("id_for"),
                    rs.getString("nome_for"),});
            }
        } catch (Exception e) {
            System.out.println("Erro ao preencher a tabela fornecedor!" + e.getMessage());
        } finally {
            produtoCTR.CloseDB();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultaFornecedor;
    private javax.swing.JButton btnConsultaProduto;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cod_bar_prod;
    private javax.swing.JTextField desc_prod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtl_consultar_fornecedor;
    private javax.swing.JTable jtl_consultar_produto;
    private javax.swing.JTextField nome_prod;
    private javax.swing.JTextField p_custo_prod;
    private javax.swing.JTextField p_venda_prod;
    private javax.swing.JTextField pesquisa_nome_fornecedor;
    private javax.swing.JTextField pesquisa_nome_produto;
    private javax.swing.JTextField qtd_estoque_produto;
    // End of variables declaration//GEN-END:variables
}
