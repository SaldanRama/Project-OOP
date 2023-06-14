/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eiraxa.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class MainFrame extends javax.swing.JFrame {

    private int totalHarga; // Deklarasikan totalHarga sebagai variabel kelas

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        loadData();
        setTitle("EIRAXA.NET -KASIR");
        setLocationRelativeTo(null);
    }

    private void loadData() {
        // Konfigurasi koneksi database
        String url = "jdbc:mysql://localhost:3306/tb_produk";
        String username = "root";
        String password = "";

        // Koneksi ke database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Statement untuk menjalankan query
            Statement stmt = conn.createStatement();

            // Query untuk mengambil data dari tabel
            String query = "SELECT NAMA, HARGA, STOCK FROM tb_table";

            // Eksekusi query dan ambil hasilnya
            ResultSet rs = stmt.executeQuery(query);

            // Buat model tabel
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Hapus semua baris yang ada di tabel
            model.setRowCount(0);

            // Reset total harga
            totalHarga = 0;

            // Loop melalui hasil query dan tambahkan data ke dalam model tabel
            while (rs.next()) {
                String nama = rs.getString("NAMA");
                long harga = rs.getLong("HARGA");
                int stock = rs.getInt("STOCK");
                long total = harga * stock;

                // Tambahkan data ke dalam baris baru pada model tabel
                model.addRow(new Object[] { nama, harga, stock, total });

                // Hitung total harga
                totalHarga += total;
            }

            // Tutup statement dan result set
            stmt.close();
            rs.close();

            // Update total harga
            updateTotalHarga();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateTotalHarga() {
        txtTotalHarga.setText("Rp. " + totalHarga);
    }

    private void deleteDataFromDatabase(int id, int hargaBarang) {
        String url = "jdbc:mysql://localhost:3306/tb_produk";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM tb_table WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        txtHargaBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        buttonInput = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtTotalHarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotalBayar = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        buttonExit = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        buttonReset = new javax.swing.JToggleButton();
        buttonHapus = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("NAMA BARANG");

        txtNamaBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtHargaBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("HARGA");

        txtJumlah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("JUMLAH");

        buttonInput.setBackground(new java.awt.Color(153, 153, 153));
        buttonInput.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonInput.setText("INPUT");
        buttonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 153, 153));

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Nama Barang", "Harga Barang", "Jumlah", "Total"
                }));
        jScrollPane1.setViewportView(table);

        txtTotalHarga.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL HARGA :  ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL BAYAR :  ");

        txtTotalBayar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtKembalian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("KEMBALIAN    ");

        buttonExit.setBackground(new java.awt.Color(0, 153, 153));
        buttonExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(255, 255, 255));
        buttonExit.setText("EXIT");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(0, 153, 153));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setText("BAYAR");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        buttonReset.setBackground(new java.awt.Color(0, 153, 153));
        buttonReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonReset.setText("RESET");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        buttonHapus.setBackground(new java.awt.Color(0, 153, 153));
        buttonHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonHapus.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapus.setText("HAPUS");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jToggleButton3, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addGroup(jPanel3Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel7,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        160,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(txtTotalBayar))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel6,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        160,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(txtTotalHarga))
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                        .addComponent(jLabel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                160,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel3Layout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(buttonHapus,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                82,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(buttonReset,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                84,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(buttonExit,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                84,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addComponent(txtKembalian)))))
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel3,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtNamaBarang,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 259,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel4,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtHargaBarang))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel5,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtJumlah,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 138,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(buttonInput,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addComponent(jSeparator1)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                                Short.MAX_VALUE))))
                                .addContainerGap(31, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonInput))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonExit)
                                        .addComponent(buttonReset)
                                        .addComponent(buttonHapus))
                                .addContainerGap(88, Short.MAX_VALUE)));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 70));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EIRAXA");
        jLabel1.setToolTipText("");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NET");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(106, 106, 106)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInputActionPerformed(java.awt.event.ActionEvent evt) {
        // Mendapatkan data dari inputan
        String NamaBarang = txtNamaBarang.getText();
        int HargaBarang = Integer.parseInt(txtHargaBarang.getText());
        int Jumlah = Integer.parseInt(txtJumlah.getText());
        int Total = HargaBarang * Jumlah;

        // Menambahkan data ke dalam tabel
        DefaultTableModel tbl = (DefaultTableModel) table.getModel();
        tbl.addRow(new Object[] { NamaBarang, "Rp. " + HargaBarang, Jumlah, "Rp. " + Total });

        // Menghitung total harga dari semua data di tabel
        int TotalHarga = calculateTotalHargaFromTable();
        txtTotalHarga.setText("Rp. " + TotalHarga);

        // Menyimpan data ke dalam database
        String url = "jdbc:mysql://localhost:3306/tb_produk";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO tb_table (NAMA, HARGA, STOCK) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, NamaBarang);
            statement.setInt(2, HargaBarang);
            statement.setInt(3, Jumlah);

            statement.executeUpdate();
            statement.close();

            // Pesan berhasil disimpan ke database
            System.out.println("Data berhasil disimpan ke database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Mengosongkan inputan
        txtNamaBarang.setText("");
        txtHargaBarang.setText("");
        txtJumlah.setText("");
    }

    private int calculateTotalHargaFromTable() {
        int totalHarga = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, 3).toString();
            if (value.startsWith("Rp. ")) {
                int harga = Integer.parseInt(value.substring(4));
                totalHarga += harga;
            }
        }
        return totalHarga;
    }

    private void retrieveDataFromDatabase() {
        // Mengambil data dari database
        String url = "jdbc:mysql://localhost:3306/tb_produk";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM tb_table";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            // Menambahkan data dari database ke dalam tabel
            DefaultTableModel tbl = (DefaultTableModel) table.getModel();
            while (result.next()) {
                String namaBarang = result.getString("NAMA");
                int hargaBarang = result.getInt("HARGA");
                int jumlah = result.getInt("STOCK");
                int total = hargaBarang * jumlah;

                tbl.addRow(new Object[] { namaBarang, "Rp. " + hargaBarang, jumlah, "Rp. " + total });
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Panggil metode retrieveDataFromDatabase() saat aplikasi dimulai atau tabel
    // diinisialisasi
    public void initializeTable() {
        // Menghapus semua baris yang ada dalam tabel
        DefaultTableModel tbl = (DefaultTableModel) table.getModel();
        tbl.setRowCount(0);

        // Mengambil data dari database dan menambahkannya ke dalam tabel
        retrieveDataFromDatabase();

        // Menghitung total harga dari semua data di tabel
        int TotalHarga = calculateTotalHargaFromTable();
        txtTotalHarga.setText("Rp. " + TotalHarga);
    }

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Membuat Fungsi Bayar
        int TotalHarga = Integer.parseInt(txtTotalHarga.getText().substring(4));
        int TotalBayar = Integer.parseInt(txtTotalBayar.getText());

        // Untuk Mengatur Kembalian
        int Kembalian = TotalBayar - TotalHarga;
        txtKembalian.setText("-Rp." + Kembalian);
    }

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {
        // Membuat Sistem Exit
        System.exit(0);
    }

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {
        // Mengosongkan Text Field
        txtNamaBarang.setText("");
        txtHargaBarang.setText("");
        txtJumlah.setText("");
        txtTotalHarga.setText("");
        txtTotalBayar.setText("");
        txtKembalian.setText("");

        // Mengosongkan Tabel
        DefaultTableModel tbl = (DefaultTableModel) table.getModel();
        int rowCount = tbl.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tbl.removeRow(i);
        }

        // Menghapus semua data dari tabel di database
        String url = "jdbc:mysql://localhost:3306/tb_produk";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Statement untuk menjalankan query DELETE
            Statement stmt = conn.createStatement();

            // Query untuk menghapus semua data dari tabel
            String query = "DELETE FROM tb_table";

            // Eksekusi query DELETE
            stmt.executeUpdate(query);

            // Tutup statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel tbl = (DefaultTableModel) table.getModel();
            int totalHargaBarang = getTotalHargaBarangFromRow(selectedRow);
            tbl.removeRow(selectedRow);

            // Menghitung kembali total harga setelah baris dihapus
            int totalHarga = calculateTotalHarga();
            txtTotalHarga.setText("Rp. " + totalHarga);

            // Menghapus data dari database berdasarkan ID
            int id = getIdFromRow(selectedRow);
            deleteDataFromDatabase(id, totalHargaBarang);
        }
    }

    private int getTotalHargaBarangFromRow(int row) {
        String value = table.getValueAt(row, 3).toString();
        if (value.startsWith("Rp. ")) {
            return Integer.parseInt(value.substring(4));
        }
        return 0;
    }

    private int calculateTotalHarga() {
        int totalHarga = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = table.getValueAt(i, 3).toString();
            if (value.startsWith("Rp. ")) {
                int harga = Integer.parseInt(value.substring(4));
                totalHarga += harga;
            }
        }
        return totalHarga;
    }

    private int getIdFromRow(int row) {
        return (int) table.getValueAt(row, 0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonExit;
    private javax.swing.JToggleButton buttonHapus;
    private javax.swing.JToggleButton buttonInput;
    private javax.swing.JToggleButton buttonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtHargaBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtTotalBayar;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
