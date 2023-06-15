package com.Layouts;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataAccesor.DataAccessor;
import com.Models.Product;

public class ReadProduc {
    private DataAccessor dataAccessor;

    public ReadProduc(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void readData() {
        try {
            ResultSet resultSet = dataAccessor.executeQuery("SELECT NAMA, HARGA, JUMLAH FROM `tb_produc` ORDER BY ID DESC");

            while (resultSet.next()) {
                String name = resultSet.getString("NAMA");
                double price = resultSet.getDouble("HARGA");
                int stock = resultSet.getInt("JUMLAH");

                Product product = new Product(0, name, price, stock);
                System.out.println(product.getName() + ": Rp." + product.getPrice() + " (" + product.getStock() + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
        }
    }
}
