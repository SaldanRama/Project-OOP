package com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;

public class Delete {
    private DataAccessor dataAccessor;

    public Delete(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void deleteData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();

        try {
            String query = "DELETE FROM `tb_produc` WHERE `ID` = " + id;
            dataAccessor.executeUpdate(query);
            System.out.println("berhasil menghapus data");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
            scanner.close();
        }
    }
}
