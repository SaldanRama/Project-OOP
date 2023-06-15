# config

terdapat 1 class pada file ini yaitu `DBConnection.java`

# DBConnector.java

Class 'DBConnection.java' digunakan dalam proyek untuk mendapatkan koneksi ke database MySQL sehingga dapat digunakan dalam operasi pengolahan data.

# DataAccesor

terdapat 1 class pada file ini yaitu `DataAccessor.java`

##  DataAccessor.java

Class `DataAccessor.java`ini berguna dalam operasi pengolahan data di aplikasi, seperti menjalankan query SELECT untuk membaca data atau menjalankan query UPDATE untuk memperbarui data dalam database.


# Layouts

terdapat 5 class pada file ini yaitu `App.java` , `Delete.java` , `EditProduc.java` , 
`ReadProduc.java` , dan `WriteProduc.java`

# Main.java

`Main.java` adalah kelas yang berisi metode `main` untuk menjalankan aplikasi.

## Metode

- `main(String[] args)`: Metode utama yang menjalankan `App.main(args)` untuk memulai aplikasi.

### Metode

- `getConnection()`: Membuat koneksi dengan database menggunakan URL, username, dan password yang telah ditentukan.


### Metode

- `closeConnection()`: Menutup koneksi, pernyataan, dan hasil set data.
- `executeQuery(String query)`: Mengeksekusi pernyataan SQL untuk mengambil data dari database.
- `executeUpdate(String query)`: Mengeksekusi pernyataan SQL untuk memperbarui data dalam database.

## ReadProduc.java

`ReadProduc.java` adalah kelas yang bertanggung jawab untuk membaca dan mencetak data dari tabel `tb_product` ke konsol.

### Metode

- `readData()`: Mengeksekusi pernyataan SQL untuk mengambil data dari tabel `tb_product` dan mencetaknya ke konsol.

## EditProduc.java

`EditProduc.java` adalah kelas yang bertanggung jawab untuk mengubah data dalam tabel `tb_product`.

### Metode

- `editData()`: Meminta input pengguna untuk ID data yang akan diubah, serta nilai baru untuk NAMA, HARGA, dan JUMLAH. Mengeksekusi pernyataan SQL untuk mengubah data dalam tabel `tb_product`.

## WriteProduc.java

`WriteProduc.java` adalah kelas yang bertanggung jawab untuk memasukkan data baru ke dalam tabel `tb_product`.

### Metode

- `insertData()`: Meminta pengguna untuk memasukkan data baru, kemudian mengeksekusi pernyataan SQL untuk memasukkan data tersebut ke dalam tabel `tb_product`.

## DeleteProduc.java

`DeleteProduc.java` adalah kelas yang bertanggung jawab untuk menghapus data dari tabel `tb_product`.

### Metode

- `deleteData()`: Meminta input pengguna untuk ID data yang akan dihapus, kemudian mengeksekusi pernyataan SQL untuk menghapus data dari tabel `tb_product`.

## App.java

`App.java` adalah kelas utama yang berfungsi sebagai antarmuka pengguna untuk mengakses fitur-fitur CRUD pada tabel `tb_product`.

### Metode

- `main(String[] args)`: Metode utama yang berfungsi sebagai titik masuk program. Menampilkan menu pilihan dan menerima input pengguna untuk memilih operasi yang diinginkan.

# Models

terdapat 1 class dalam file ini yaitu `Product.java`

## Product.java

`Product.java` adalah kelas yang merepresentasikan objek produk dalam aplikasi.

### Properti

- `id`: ID produk.
- `name`: Nama produk.
- `price`: Harga produk.
- `stock`: Jumlah stok produk.

### Metode

- Metode setter dan getter untuk setiap properti.


