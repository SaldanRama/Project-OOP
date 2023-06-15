package com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;

public class EditProduc {
    private DataAccessor dataAccessor;

    public EditProduc(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void editData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan Nama Baru: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan Harga Baru: ");
        double price = scanner.nextDouble();

        System.out.print("Masukkan Jumlah Baru: ");
        int stock = scanner.nextInt();

        try {
            String query = "UPDATE `tb_produc` SET `NAMA` = '" + name + "', `HARGA` = " + price + ", `JUMLAH` = " + stock + " WHERE `tb_product`.`ID` = " + id;
            dataAccessor.executeUpdate(query);
            System.out.println("Data berhasil diperbarui");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
            scanner.close();
        }
    }
}

