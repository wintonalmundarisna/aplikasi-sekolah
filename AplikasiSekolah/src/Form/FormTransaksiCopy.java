
package Form;

import Config.Koneksi;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author winton
 */
public class FormTransaksiCopy extends javax.swing.JFrame {
    @SuppressWarnings("unchecked")
    
    private Connection conn;
    
    public FormTransaksiCopy() {
        initComponents();
        conn=Koneksi.getConnection();
        getData();
        nonAktifButton();
        aktifButton();
        cmb_nis(); // Panggil kelas di main class agar query di run di awal juga
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t_tahun_ajaran = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        t_tunggakan = new javax.swing.JTextField();
        t_tanggal_pembayaran = new com.toedter.calendar.JDateChooser();
        t_nis = new javax.swing.JComboBox<>();
        t_nama = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        t_kelas = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_batal_bayar = new javax.swing.JButton();
        btn_bayar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        t_total_bayar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_edit_bayar = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        t_total_tunggakan_bayar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_kembali = new javax.swing.JLabel();
        t_nis_bayar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(0, 102, 102));
        jPanel20.setPreferredSize(new java.awt.Dimension(228, 96));

        jLabel21.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/change.png"))); // NOI18N
        jLabel21.setText("PEMBAYARAN SPP");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Data Siswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel4.setText("NIS");

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel5.setText("Nama");

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel6.setText("Kelas");

        t_tahun_ajaran.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel3.setText("Tanggal Tunggakan");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Tambah Tunggakan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel8.setText("Input Tunggakan");

        btn_ok.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ok.png"))); // NOI18N
        btn_ok.setText("OK");
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_okMouseClicked(evt);
            }
        });
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        t_tunggakan.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        t_tunggakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_tunggakanActionPerformed(evt);
            }
        });
        t_tunggakan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_tunggakanKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_ok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(btn_batal))
                    .addComponent(t_tunggakan))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(t_tunggakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal)
                    .addComponent(btn_ok))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        t_tanggal_pembayaran.setDateFormatString("yyyy-MM-dd");
        t_tanggal_pembayaran.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N

        t_nis.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        t_nis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_nisMouseClicked(evt);
            }
        });
        t_nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nisActionPerformed(evt);
            }
        });

        t_nama.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel13.setText("Tahun Ajaran");

        t_kelas.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_tanggal_pembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_nis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_tanggal_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(t_nama))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(t_kelas))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Daftar Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transaksi", "Tgl Transaksi", "NIS", "Nama", "Kelas", "Tahun Ajaran", "Total Tunggakan", "Total Bayar"
            }
        ));
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_transaksi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N

        btn_batal_bayar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btn_batal_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btn_batal_bayar.setText("Batal");
        btn_batal_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_bayarActionPerformed(evt);
            }
        });

        btn_bayar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btn_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money-bag.png"))); // NOI18N
        btn_bayar.setText("Bayar");
        btn_bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bayarMouseClicked(evt);
            }
        });
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel12.setText("Total Tunggakan");

        t_total_bayar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        t_total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_total_bayarActionPerformed(evt);
            }
        });
        t_total_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_total_bayarKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel14.setText("Total Bayar");

        jLabel15.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel15.setText("Kembali");

        btn_edit_bayar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btn_edit_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pencil.png"))); // NOI18N
        btn_edit_bayar.setText("Edit");
        btn_edit_bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit_bayarMouseClicked(evt);
            }
        });
        btn_edit_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_bayarActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/recycle-bin.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        t_total_tunggakan_bayar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        t_total_tunggakan_bayar.setText("0");

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel7.setText("NIS");

        t_kembali.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        t_kembali.setText("0");

        t_nis_bayar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        t_nis_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nis_bayarActionPerformed(evt);
            }
        });
        t_nis_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nis_bayarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_bayar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_hapus)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_total_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(t_nis_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_total_tunggakan_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(t_nis_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(t_total_tunggakan_bayar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(t_total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(t_kembali))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_bayar)
                    .addComponent(btn_batal_bayar)
                    .addComponent(btn_edit_bayar)
                    .addComponent(btn_hapus))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void getData() {
        DefaultTableModel model =(DefaultTableModel) tbl_transaksi.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "Select * From transaksi";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
//            int no = 0;
            
            while(rs.next()){
//                no++;
                int id = rs.getInt("id");
                String tanggal_pembayaran = rs.getString("tanggal_pembayaran");
                String nis = rs.getString("nis");
                String nama = rs.getString("nama");
                String kelas = rs.getString("kelas");
                String tahun_ajaran = rs.getString("tahun_ajaran");
                String total_tunggakan = rs.getString("total_tunggakan");
                String total_pembayaran = rs.getString("total_pembayaran");
                
                Object[] rowData = {id,tanggal_pembayaran,nis,nama,kelas,tahun_ajaran,total_tunggakan,total_pembayaran};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
        }catch (Exception e){ 
            Logger.getLogger(FormTransaksiCopy.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    public void cmb_nis() {
        try {
            String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/aplikasi_sekolah";
            SUser = "root";
            SPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            
            String sql = "select * from siswa";
            ResultSet rs = st.executeQuery(sql);                 
           
            while(rs.next()) {
                String nis = rs.getString("nis");
                t_nis.addItem(nis); // Masukkan data ke combo box        
            }
        } catch (Exception e) {
            Logger.getLogger(FormTransaksiCopy.class.getName()).log(Level.SEVERE,null, e);
        }  
    }
    
    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
       
    }//GEN-LAST:event_btn_batalActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
       int selectedRow = tbl_transaksi.getSelectedRow();
       if (selectedRow !=-1) {
           String nis = tbl_transaksi.getValueAt(selectedRow, 2).toString();
           String total_tunggakan = tbl_transaksi.getValueAt(selectedRow, 6).toString();
                  
           t_nis_bayar.setText(nis);
           t_total_tunggakan_bayar.setText(total_tunggakan);
       }
       btn_edit_bayar.setEnabled(true);
       btn_bayar.setEnabled(true);
       btn_batal_bayar.setEnabled(true);
       btn_hapus.setEnabled(true);
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void btn_batal_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_bayarActionPerformed
       
    }//GEN-LAST:event_btn_batal_bayarActionPerformed

    private void btn_bayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bayarMouseClicked

    }//GEN-LAST:event_btn_bayarMouseClicked

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
           String total_tunggakan = t_total_tunggakan_bayar.getText().toString();
           String total_pembayaran = t_total_bayar.getText().toString();
                  
           t_total_tunggakan_bayar.setText(total_tunggakan);
           t_total_bayar.setText(total_pembayaran);
           
           int tunggakan = Integer.parseInt(total_tunggakan);
           int bayar = Integer.parseInt(total_pembayaran);
           
           if(tunggakan < bayar) {
                int kembali = bayar - tunggakan;     
                String hasil = Integer.toString(kembali);
                t_kembali.setText(hasil);
           } else {
                t_kembali.setText("0");
           }
           
//         save ke dalam db
           JOptionPane.showMessageDialog(null, "Pembayaran Sukses");
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void t_total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_total_bayarActionPerformed
           
    }//GEN-LAST:event_t_total_bayarActionPerformed

    private void t_total_bayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_total_bayarKeyTyped

//      Hanya boleh diisi angka
        if (Character.isAlphabetic(evt.getKeyChar())) {
                   evt.consume();
                   JOptionPane.showMessageDialog(null, "Hanya Boleh Diisi dengan Angka!");
        }

               int limit = 10;
               if (t_total_bayar.getText().length() >= limit) {
                   evt.consume();
        }
    }//GEN-LAST:event_t_total_bayarKeyTyped

    private void t_nisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_nisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nisMouseClicked

    private void t_nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nisActionPerformed
          try {
            String nis = t_nis.getSelectedItem().toString();
            String sql = "SELECT * FROM transaksi WHERE nis = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,nis);
            
            ResultSet rs= st.executeQuery();
            
            
            while(rs.next()){
              String nama = rs.getString("nama");
              String kelas = rs.getString("kelas");
              String tahun_ajaran = rs.getString("tahun_ajaran");
              
              
              t_nama.setText(nama);
              t_kelas.setText(kelas);
              t_tahun_ajaran.setText(tahun_ajaran);
            }
            rs.close();
            st.close();
        }catch (Exception e){ 
            Logger.getLogger(FormTransaksiCopy.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_t_nisActionPerformed

    private void btn_edit_bayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_bayarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_bayarMouseClicked

    private void btn_edit_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_bayarActionPerformed

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void t_tunggakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_tunggakanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tunggakanActionPerformed

    private void t_nis_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nis_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nis_bayarActionPerformed

    private void t_nis_bayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nis_bayarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nis_bayarKeyTyped

    private void t_tunggakanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_tunggakanKeyTyped
       // Hanya boleh diisi angka
        if (Character.isAlphabetic(evt.getKeyChar())) {
                   evt.consume();
                   JOptionPane.showMessageDialog(null, "Hanya Boleh Diisi dengan Angka!");
        }

               int limit = 10;
               if (t_total_bayar.getText().length() >= limit) {
                   evt.consume();
        }
    }//GEN-LAST:event_t_tunggakanKeyTyped

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        // Ambil semua data inputan
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(t_tanggal_pembayaran.getDate());

        String nis = t_nis.getSelectedItem().toString();
        String nama = t_nama.getText().toString();
        String kelas = t_kelas.getText().toString();
        String tahun_ajaran = t_tahun_ajaran.getText().toString();
        String tunggakan = t_tunggakan.getText().toString();

        if(nama.isEmpty() || nis.isEmpty() || kelas.isEmpty() || tahun_ajaran.isEmpty() || tunggakan.isEmpty() ){
            JOptionPane.showMessageDialog(this,"Semua Kolom Harus Diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        try{
            String sql ="INSERT INTO transaksi (tanggal_pembayaran,nis,nama,kelas,tahun_ajaran,total_tunggakan,total_pembayaran) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, date);
            st.setString(2, nis);
            st.setString(3, nama);
            st.setString(4, kelas);
            st.setString(5, tahun_ajaran);
            st.setString(6, tunggakan);
            st.setString(7, "0");
            
            int rowInserted = st.executeUpdate();
            if (rowInserted >0) {
                JOptionPane.showMessageDialog(this, "Tunggakan Berhasil Ditambahkan");
                resetForm();
                getData();
            }
            st.close();
        }catch (Exception e) {
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_okActionPerformed

    private void btn_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseClicked
        //         try {
            //
            //        // Ambil semua data inputan
            //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //        String date = sdf.format(t_tanggal_pembayaran.getDate());
            //
            //        String nis = t_nis.getSelectedItem().toString();
            //        String nama = t_nama.getText().toString();
            //        String kelas = t_kelas.getText().toString();
            //        String tahun_ajaran = t_tahun_ajaran.getText().toString();
            //        String tunggakan = t_tunggakan.getText().toString();
            //
            //            String SUrl, SUser, SPass;
            //            SUrl = "jdbc:MySQL://localhost:3306/aplikasi_sekolah";
            //            SUser = "root";
            //            SPass = "";
            //            Class.forName("com.mysql.cj.jdbc.Driver");
            //            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            //            Statement st = con.createStatement();
            //
            //            String sql = "select * from transaksi";
            //            ResultSet rs = st.executeQuery(sql);
            //
            //            while(rs.next()) {
                //                String nisKedua = rs.getString("nis");
                //
                //                // Jika nis sama/sudah ada, maka update
                //                if (nis == nisKedua) {
                    //                    String tambah ="UPDATE transaksi\n" + "SET tanggal_pembayaran = ?, nis = ?, nama = ?, kelas = ?, " +
                    //                                   "tahun_ajaran = ?, total_tunggakan = ?, total_pembayaran = ?\n" +
                    //                                   "WHERE nis = ? and nama = ?;";
                    //                    PreparedStatement pst = conn.prepareStatement(tambah);
                    //                    pst.setString(1, date);
                    //                    pst.setString(2, nis);
                    //                    pst.setString(3, nama);
                    //                    pst.setString(4, kelas);
                    //                    pst.setString(5, tahun_ajaran);
                    //                    pst.setString(6, tunggakan);
                    //                    pst.setString(7, "0");
                    //                    pst.setString(8, nis);
                    //                    pst.setString(9, nama);
                    //                } else {
                    //                    // Jika nis beda/belum ada maka tambahkan
                    //                    String tambah ="INSERT INTO transaksi (date,nis,nama,kelas,tahun_ajaran,total_tunggakan,total_bayar) VALUES (?,?,?,?,?,?,?)";
                    //                    PreparedStatement pst = conn.prepareStatement(tambah);
                    //                    pst.setString(1, date);
                    //                    pst.setString(2, nis);
                    //                    pst.setString(3, nama);
                    //                    pst.setString(4, kelas);
                    //                    pst.setString(5, tahun_ajaran);
                    //                    pst.setString(6, tunggakan);
                    //                    pst.setString(7, "0");
                    //                }
                //            }
            //        } catch (Exception e) {
            //            Logger.getLogger(FormTransaksi.class.getName()).log(Level.SEVERE,null, e);
            //        }
    }//GEN-LAST:event_btn_okMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksiCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksiCopy().setVisible(true);
            }
  });
    }
    
    
    private void resetForm() {
       t_tanggal_pembayaran.setDate(null);
       t_nis.setSelectedItem("");
       t_nama.setText("");
       t_kelas.setText("");
       t_tahun_ajaran.setText("");
       t_tunggakan.setText("");
    }
    
    private void resetFormPembayaran() {
       t_total_tunggakan_bayar.setText("");
       t_total_bayar.setText("");
       t_kembali.setText("0");
    }

    private void nonAktifButton() {
      btn_edit_bayar.setEnabled(false);
      btn_hapus.setEnabled(false);      
    }

    private void aktifButton() {
     btn_ok.setEnabled(true);
     btn_bayar.setEnabled(true);
     btn_batal.setEnabled(true);
     btn_batal_bayar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_batal_bayar;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_edit_bayar;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel t_kelas;
    private javax.swing.JLabel t_kembali;
    private javax.swing.JLabel t_nama;
    private javax.swing.JComboBox<String> t_nis;
    private javax.swing.JTextField t_nis_bayar;
    private javax.swing.JLabel t_tahun_ajaran;
    private com.toedter.calendar.JDateChooser t_tanggal_pembayaran;
    private javax.swing.JTextField t_total_bayar;
    private javax.swing.JLabel t_total_tunggakan_bayar;
    private javax.swing.JTextField t_tunggakan;
    private javax.swing.JTable tbl_transaksi;
    // End of variables declaration//GEN-END:variables
}
