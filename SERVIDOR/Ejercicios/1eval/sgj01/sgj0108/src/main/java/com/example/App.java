package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws IOException {
        Menu miMenu = new Menu();

    }

    public static void consultar() {
        String sql = "SELECT id, nombre, salario FROM empleados";
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:sqlite:empleados.db", "usuario", "contraseña");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            // while (rs.next()) {
            // System.out.println("Fila número: " + rs.getRow());
            // System.out.println("\t nombre: " + rs.getString(1));
            // System.out.println("\t precio: " + rs.getFloat(2));
            // }
            System.out.println("conexion okay");
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                    "SLQState: " + e.getSQLState() + "\n" +
                    "Mensaje: " + e.getMessage() + "\n");
        }

    }

    public static void insertar(int id, String nombre, float salario) {
        String sql = "INSERT INTO empleados VALUES(?,?,?)";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db", "usuario", "contraseña");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setFloat(3, salario);
            int rs = ps.executeUpdate();
            System.out.println("Se ha insertado correctamente");

            System.out.println("conexion okay");
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                    "SLQState: " + e.getSQLState() + "\n" +
                    "Mensaje: " + e.getMessage() + "\n");
        }

    }

}
