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

public class FormSiswa extends javax.swing.JFrame {

    private Connection conn;
 
    public FormSiswa() {
        initComponents();
        conn=Koneksi.getConnection();
        getData();
        nonAktifButton();
        aktifButton();
        cmb_kelas(); // Panggil kelas di main class agar query di run di awal juga
        cmb_jurusan();
        cmb_jenis_studi();
        cmb_tahun_ajaran();
    }

    private void getData() {
        DefaultTableModel model =(DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "Select * From Siswa";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs= st.executeQuery();
//            int no = 0;
            
            while(rs.next()){
//                no++;
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String nis = rs.getString("nis");
                String kelas = rs.getString("kelas");
                String wali_kelas = rs.getString("wali_kelas");
                String jurusan = rs.getString("jurusan");
                String jenis_studi = rs.getString("jenis_studi");
                String tahun_ajaran = rs.getString("tahun_ajaran");
                
                Object[] rowData = {id,nama,nis,kelas,wali_kelas,jurusan,jenis_studi,tahun_ajaran};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
        }catch (Exception e){ 
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    public void cmb_kelas() {
        try {
            String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/aplikasi_sekolah";
            SUser = "root";
            SPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            
            String sql = "select * from kelas";
            ResultSet rs = st.executeQuery(sql);                 
           
            while(rs.next()) {
                String data = rs.getString("kelas");
                t_kelas.addItem(data); // Masukkan data ke combo box        
            }
        } catch (Exception e) {
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }  
    }
    
     public void cmb_tahun_ajaran() {
        try {
            String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/aplikasi_sekolah";
            SUser = "root";
            SPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            
            String sql = "select * from tahun_ajaran";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                String data = rs.getString("tahun_ajaran");
                t_tahun_ajaran.addItem(data); // Masukkan data ke combo box
            }
        } catch (Exception e) {
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }  
    }
     public void cmb_jurusan() {
        try {
            String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/aplikasi_sekolah";
            SUser = "root";
            SPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            
            String sql = "select * from jurusan";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                String data = rs.getString("jurusan");
                t_jurusan.addItem(data); // Masukkan data ke combo box
            }
        } catch (Exception e) {
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }  
    }
     public void cmb_jenis_studi() {
        try {
            String SUrl, SUser, SPass;
            SUrl = "jdbc:MySQL://localhost:3306/aplikasi_sekolah";
            SUser = "root";
            SPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            
            String sql = "select * from jenis_studi";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                String data = rs.getString("jenis_studi");
                t_jenis_studi.addItem(data); // Masukkan data ke combo box
            }
        } catch (Exception e) {
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }  
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_nis = new javax.swing.JTextField();
        t_cari = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        t_kelas = new javax.swing.JComboBox<>();
        t_jurusan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        t_wali_kelas = new javax.swing.JLabel();
        t_nama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_jenis_studi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        t_tahun_ajaran = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_data.setForeground(new java.awt.Color(51, 51, 51));
        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "Nis", "Kelas", "Wali Kelas", "Jurusan", "Jenis Studi", "Tahun Ajaran"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel1.setText("NIS                       :      ");

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setText("Kelas                   :");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel3.setText("Jurusan              :");

        t_nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nisActionPerformed(evt);
            }
        });
        t_nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nisKeyTyped(evt);
            }
        });

        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        btn_tambah.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_perbarui.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_perbarui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pencil.png"))); // NOI18N
        btn_perbarui.setText("PERBARUI");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/recycle-bin.png"))); // NOI18N
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btn_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cari.png"))); // NOI18N
        jLabel5.setText("Cari");

        jDesktopPane1.setBackground(new java.awt.Color(0, 102, 102));

        jToolBar1.setBackground(new java.awt.Color(0, 102, 102));
        jToolBar1.setRollover(true);

        jLabel4.setBackground(new java.awt.Color(0, 153, 255));
        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/users.png"))); // NOI18N
        jLabel4.setText(" DATA SISWA");
        jToolBar1.add(jLabel4);

        jDesktopPane1.setLayer(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        t_kelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_kelasMouseClicked(evt);
            }
        });
        t_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kelasActionPerformed(evt);
            }
        });

        t_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_jurusanActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setText("Wali Kelas          :");

        t_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_namaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setText("Nama Siswa         :      ");

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel8.setText("Jenis Studi          :");

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel9.setText("Tahun Ajaran      :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_perbarui)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel7))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(t_nis)
                                .addComponent(t_kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(t_jurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(t_wali_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t_tahun_ajaran, 0, 246, Short.MAX_VALUE)
                            .addComponent(t_jenis_studi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_cari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_nis, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_wali_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_jenis_studi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_batal)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
      int selectedRow = tbl_data.getSelectedRow();
        if (selectedRow ==-1){
            JOptionPane.showMessageDialog(this,"Pilih baris yang akan di hapus");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,"Apakah Anda Ingin Menghapus Data Ini?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            String id = tbl_data.getValueAt(selectedRow, 0).toString();
            
            try {
                String sql="DELETE FROM siswa WHERE id=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1,id);
                
                int rowDelete = st.executeUpdate();
                if (rowDelete>0) {
                    JOptionPane.showMessageDialog(this,"Data Berhasil Dihapus");
                    resetForm();
                    getData();
                }
                
                st.close();
            } catch(Exception e) {
                 Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
            }
        }
       resetForm();
       getData();
       aktifButton();
       nonAktifButton();
        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
       resetForm();
       aktifButton();
       nonAktifButton();
      
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String nama = t_nama.getText();
        String nis = t_nis.getText();
        String kelas = t_kelas.getSelectedItem().toString();
        String tahun_ajaran = t_tahun_ajaran.getSelectedItem().toString();
        String wali_kelas = t_wali_kelas.getText();
        String jurusan = t_jurusan.getSelectedItem().toString();
        String jenis_studi = t_jenis_studi.getSelectedItem().toString();
        
        if(nama.isEmpty() || nis.isEmpty() || kelas.isEmpty() || tahun_ajaran.isEmpty() || wali_kelas.isEmpty() ){
            JOptionPane.showMessageDialog(this,"Semua Kolom Harus Diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
       return;
        }
        
        try{
            String sql ="INSERT INTO siswa (nama,nis,kelas,wali_kelas,jurusan,jenis_studi,tahun_ajaran) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nama);
            st.setString(2, nis);
            st.setString(3, kelas);
            st.setString(4, wali_kelas);
            st.setString(5, jurusan);
            st.setString(6, jenis_studi);
            st.setString(7, tahun_ajaran);
            
            int rowInserted = st.executeUpdate();
            if (rowInserted >0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
                resetForm();
                getData();
            }
            st.close();
        }catch (Exception e) {
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }
//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        int selectedRow = tbl_data.getSelectedRow();
        if (selectedRow ==-1){
            JOptionPane.showMessageDialog(this,"Pilih baris yang akan di perbarui");
            return;
        }
        String id = tbl_data.getValueAt(selectedRow,0).toString();
        String nama= t_nama.getText();
        String nis= t_nis.getText();
        String kelas= t_kelas.getSelectedItem().toString();
        String wali_kelas= t_wali_kelas.getText();
        String jurusan= t_jurusan.getSelectedItem().toString();
        String jenis_studi= t_jenis_studi.getSelectedItem().toString();
        String tahun_ajaran= t_tahun_ajaran.getSelectedItem().toString();
        
        if(nama.isEmpty() || nis.isEmpty() || kelas.isEmpty() || wali_kelas.isEmpty() || tahun_ajaran.isEmpty() ){
            JOptionPane.showMessageDialog(this,"Semua Kolom Harus Diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
       return;
        }
        
        try {
            String sql ="UPDATE siswa SET nama=?, nis=?, kelas=?, wali_kelas=?, jurusan=?, jenis_studi=?, tahun_ajaran=? WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nama);
            st.setString(2, nis);
            st.setString(3, kelas);
            st.setString(4, wali_kelas);
            st.setString(5, jurusan);
            st.setString(6, jenis_studi);
            st.setString(7, tahun_ajaran);
            st.setString(8, id);
            
            int rowUpdate= st.executeUpdate();
            if (rowUpdate >0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui");
                resetForm();
                getData();
            }
            st.close();
        }catch (Exception e) {
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
       int selectedRow = tbl_data.getSelectedRow();
       if (selectedRow !=-1) {
           String nama = tbl_data.getValueAt(selectedRow, 1).toString();
           String nis = tbl_data.getValueAt(selectedRow, 2).toString();
           String kelas = String.valueOf(tbl_data.getValueAt(selectedRow, 3)).toString();
           String wali_kelas = tbl_data.getValueAt(selectedRow, 4).toString();
           String jurusan = String.valueOf(tbl_data.getValueAt(selectedRow, 5)).toString();
           String jenis_studi = String.valueOf(tbl_data.getValueAt(selectedRow, 6)).toString();
           String tahun_ajaran = String.valueOf(tbl_data.getValueAt(selectedRow, 7)).toString();
           
           t_nama.setText(nama);
           t_nis.setText(nis);
           t_kelas.setSelectedItem(kelas);
           t_wali_kelas.setText(wali_kelas);
           t_jurusan.setSelectedItem(jurusan);
           t_jenis_studi.setSelectedItem(jenis_studi);
           t_tahun_ajaran.setSelectedItem(tahun_ajaran);
           
       }
       btn_perbarui.setEnabled(true);
       btn_tambah.setEnabled(false);
       btn_hapus.setEnabled(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        DefaultTableModel model =(DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        String cari = t_cari.getText();
        try {
            String sql = "Select * From Siswa WHERE nama LIKE ? OR nis LIKE ? OR kelas LIKE ? OR wali_kelas LIKE ? OR jurusan LIKE ? OR jenis_studi LIKE ? OR tahun_ajaran LIKE ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"%" + cari + "%" );
            st.setString(2,"%" + cari + "%" );
            st.setString(3,"%" + cari + "%" );
            st.setString(4,"%" + cari + "%" );
            st.setString(5,"%" + cari + "%" );
            st.setString(6,"%" + cari + "%" );
            st.setString(7,"%" + cari + "%" );
            
            ResultSet rs= st.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String nis = rs.getString("nis");
                String kelas = rs.getString("kelas");
                String wali_kelas = rs.getString("wali_kelas");
                String jurusan = rs.getString("jurusan");
                String jenis_studi = rs.getString("jenis_studi");
                String tahun_ajaran = rs.getString("tahun_ajaran");
                
                Object[] rowData = {id,nama,nis,kelas,wali_kelas,jurusan,jenis_studi,tahun_ajaran};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
        }catch (Exception e){ 
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cariMouseClicked
        t_cari.setText("");
    }//GEN-LAST:event_t_cariMouseClicked

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariActionPerformed

    private void t_nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nisActionPerformed

    private void t_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kelasActionPerformed
       try {
            String kelas = t_kelas.getSelectedItem().toString();
            String sql = "SELECT kelas.wali_kelas " +
                         "FROM kelas "+
                         "INNER JOIN siswa ON kelas.kelas = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,kelas);
            
            ResultSet rs= st.executeQuery();
            
            
            while(rs.next()){
              String hasil = rs.getString("wali_kelas") ;
              t_wali_kelas.setText(hasil);
            }
            rs.close();
            st.close();
        }catch (Exception e){ 
            Logger.getLogger(FormSiswa.class.getName()).log(Level.SEVERE,null, e);
        }
    }//GEN-LAST:event_t_kelasActionPerformed

    private void t_kelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_kelasMouseClicked
     
    }//GEN-LAST:event_t_kelasMouseClicked

    private void t_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namaActionPerformed

    private void t_nisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nisKeyTyped
        if (Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_t_nisKeyTyped

    private void t_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_jurusanActionPerformed
        
    }//GEN-LAST:event_t_jurusanActionPerformed

    /**
     * @param args the command linet_jurusan  */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the deft_jurusanfeel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField t_cari;
    private javax.swing.JComboBox<String> t_jenis_studi;
    private javax.swing.JComboBox<String> t_jurusan;
    private javax.swing.JComboBox<String> t_kelas;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_nis;
    private javax.swing.JComboBox<String> t_tahun_ajaran;
    private javax.swing.JLabel t_wali_kelas;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
       t_nama.setText("");
       t_nis.setText("");
       t_kelas.setSelectedItem("");
       t_tahun_ajaran.setSelectedItem("");
       t_wali_kelas.setText("");
       t_jurusan.setSelectedItem("");
       t_jenis_studi.setSelectedItem("");
    }

    private void nonAktifButton() {
      btn_perbarui.setEnabled(false);
      
      btn_hapus.setEnabled(false);
      
    }

    private void aktifButton() {
     btn_tambah.setEnabled(true);
     btn_batal.setEnabled(true);
    }

    
}
