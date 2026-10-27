package org.abes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "NewPass_2026!";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("MySQL connected successfully!");

            // 1. INSERT
            String insert =
                    "INSERT INTO students (name, age) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1, "Rahul");
            ps.setInt(2, 21);
            ps.executeUpdate();

            System.out.println("Student inserted!");

            // 2. SELECT
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age")
                );
            }

            // 3. UPDATE
            st.executeUpdate(
                    "UPDATE students SET age = 22 WHERE id = 1"
            );

            System.out.println("Student updated!");

            // 4. DELETE
            st.executeUpdate(
                    "DELETE FROM students WHERE id = 1"
            );

            System.out.println("Student deleted!");

            // 1. INSERT
            String insert1 =
                    "INSERT INTO students (name, age) VALUES (?, ?)";

            PreparedStatement ps1 = con.prepareStatement(insert1);
            ps1.setString(1, "Rahul");
            ps1.setInt(2, 21);
            ps1.executeUpdate();

            System.out.println("Student inserted!");

            con.close();


        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}

