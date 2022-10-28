package project.hospital.model;

import java.sql.*;
import java.util.ArrayList;

public class NurseDAO {
    private static final String DB_URL = "jdbc:postgresql://surus.db.elephantsql.com/kgoicfvc";
    private static final String DB_USER = "kgoicfvc";
    private static final String DB_PASSWD = "X1ljbK7jBcrct6TtLDWiQPmmTg14LjO9";


    //Consultar los datos de los/las enfermeros/as
    public static ArrayList<Nurse> getHospitalNurse() {
        ArrayList<Nurse> nurses = new ArrayList<>();
        Connection dbconnection = null;
        Statement statement = null;
        ResultSet result = null;
        String sql;

        try {
            dbconnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = dbconnection.createStatement();
            sql = "SELECT * FROM Nurse";
            result = statement.executeQuery(sql);

            while (result.next()) {
                Nurse nurse = new Nurse();
                nurse.setDni(result.getString("DniNurse"));
                nurse.setName(result.getString("Name"));
                nurse.setSurname(result.getString("Surname"));
                nurse.setEmail(result.getString("Email"));
                nurse.setTimeTable(result.getString("TimeTable"));
                nurse.setPhone(result.getInt("Phone"));

                nurses.add(nurse);
            }

            result.close();
            statement.close();
            dbconnection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return nurses;
    }


    //Añadir un/a nuevo/a enfermero/a
    public static boolean addNurse(Nurse nurse) {

        boolean check = false;
        Connection dbconnection = null;
        Statement statement = null;
        String sql;
        int nrows = 0;

        try {
            dbconnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = dbconnection.createStatement();
            sql = "INSERT INTO Nurse(DniNurse, Name, Surname, Email, TimeTable, Phone)" +
                    " VALUES ('" + nurse.getDni().replaceAll("'", "@") + "'," +
                    "'" + nurse.getName().replaceAll("'", "@") + "'," +
                    "'" + nurse.getSurname().replaceAll("'", "@") + "'," +
                    "'" + nurse.getEmail().replaceAll("'", "@") + "'," +
                    "'" + nurse.getTimeTable().replaceAll("'", "@") + "'," +
                    "'" + nurse.getPhone() + ");";

            System.out.println(sql);

            nrows = statement.executeUpdate(sql);

            statement.close();
            dbconnection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        if (nrows == 1) {
            check = true;
            return check;
        } else {
            return check;
        }

    }

    public static boolean deleteNurse(String dniNurse) {
        Connection dbconection = null;
        Statement statement = null;
        String sql;
        int nrows = 0;
        try {
            dbconection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = dbconection.createStatement();
            sql = "DELETE FROM Nurse WHERE DniNurse = " + dniNurse + ";";
            nrows = statement.executeUpdate(sql);
            statement.close();
            dbconection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        if (nrows > 0) {
            return true;
        } else {
            return false;
        }
    }

}