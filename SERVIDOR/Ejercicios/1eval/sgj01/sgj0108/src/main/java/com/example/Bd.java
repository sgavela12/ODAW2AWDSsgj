package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Bd {

    public Bd() {

    }

    public static void altaEmpleado(int id, String nombre, int salario) {
        String sql = "INSERT INTO empleados VALUES(?,?,?)";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db", "usuario", "contraseña");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setFloat(3, salario);
            int rs = ps.executeUpdate();
            System.out.println("He insertado " + rs + " filas");

            System.out.println("conexion okay");
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                    "SLQState: " + e.getSQLState() + "\n" +
                    "Mensaje: " + e.getMessage() + "\n");
        }
    }


    public static void cargaEmpleados(){
        for (String [] empleado : leeCSV()) {
            
            altaEmpleado(Integer.parseInt(empleado[0]), empleado[1],Integer.parseInt( empleado[2]));
        }
        
    }

    public static void enseñaEmpleados() {

        String sql = "SELECT id, nombre, salario FROM empleados";
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:sqlite:empleados.db", "usuario", "contraseña");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            System.out.println("Lista de empleados:");
            while (rs.next()) {
                System.out.println("Empleado número " + rs.getRow());
                System.out.println("\t Id: " + rs.getInt(1));
                System.out.println("\t Nombre: " + rs.getString(2));
                System.out.println("\t Salario: " + rs.getFloat(3));

            }
            System.out.println("conexion okay");
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                    "SLQState: " + e.getSQLState() + "\n" +
                    "Mensaje: " + e.getMessage() + "\n");
        }

    }

    public static void bajaEmpleado(int id) {
        String sql = "DELETE from empleados where id =?";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db", "usuario", "contraseña");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            System.out.println("Se ha borrado correctamente");

        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                    "SLQState: " + e.getSQLState() + "\n" +
                    "Mensaje: " + e.getMessage() + "\n");
        }
    }

    public static void modificarEmpleado(int id, String nombre, int salario) {
        String sql = "update empleados set nombre=?, salario=? where id=?";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db", "usuario", "contraseña");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(3, id);
            ps.setString(1, nombre);
            ps.setFloat(2, salario);
            int rs = ps.executeUpdate();

            System.out.println("conexion okay");
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                    "SLQState: " + e.getSQLState() + "\n" +
                    "Mensaje: " + e.getMessage() + "\n");
        }
    }

    public static void consulta(int minimo, int maximo) {
        String sql = "SELECT id, nombre, salario FROM empleados WHERE salario BETWEEN ? and ?";
        try (Connection conexion = DriverManager.getConnection(
                "jdbc:sqlite:empleados.db", "usuario", "contraseña");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, minimo);
            ps.setInt(2, maximo);
            ResultSet rs = ps.executeQuery();
            System.out.println("Lista de empleados:");
            while (rs.next()) {
                System.out.println("Empleado número " + rs.getRow());
                System.out.println("\t Id: " + rs.getInt(1));
                System.out.println("\t Nombre: " + rs.getString(2));
                System.out.println("\t Salario: " + rs.getFloat(3));

            }
            System.out.println("conexion okay");
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                    "SLQState: " + e.getSQLState() + "\n" +
                    "Mensaje: " + e.getMessage() + "\n");
        }

    }

    public static ArrayList<String[]> leeCSV()  {
        String SEPARATOR = ",";
        String[] fields;
        ArrayList<String[]>output = new ArrayList<>();

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader("empleados.csv"));
            String line = br.readLine();
            while (null != line) {
                fields = line.split(SEPARATOR);
                System.out.println(Arrays.toString(fields));
                System.out.println(fields);
                fields = removeTrailingQuotes(fields);
                output.add(fields);
                line = br.readLine();
                
            }

        } catch (Exception e) {
            System.out.println("Error");
        } 
            return output;
            

        
        

    }

    private static String[] removeTrailingQuotes(String[] fields) {
        String QUOTE = "\"";

        String result[] = new String[fields.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }
}