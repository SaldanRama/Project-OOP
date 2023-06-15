package com.Layouts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;
import com.config.DBConnection;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("--------------------------------");
        System.out.println("SELAMAT DATANG DI UWAW ......");
        System.out.println("--------------------------------");
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("--------------------------------");

        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            DataAccessor dataAccessor = new DataAccessor(connection);

            while (true) {
                System.out.print("Pilih: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        ReadProduc productReader = new ReadProduc(dataAccessor);
                        productReader.readData();
                        break;
                    case 2:
                        WriteProduc productWriter = new WriteProduc(dataAccessor);
                        productWriter.insertData();
                        break;
                    case 3:
                        EditProduc productEditor = new EditProduc(dataAccessor);
                        productEditor.editData();
                        break;
                    case 4:
                        Delete productDeleter = new Delete(dataAccessor);
                        productDeleter.deleteData();
                        break;
                    default:
                        System.out.println("Tidak Ada Pilihan");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            input.close();
        }
    }
}
