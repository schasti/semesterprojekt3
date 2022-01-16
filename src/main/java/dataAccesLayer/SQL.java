package dataAccesLayer;

import exceptions.OurException;
import model.Aftale;
import model.AftaleListe;
import model.EkgData;
import model.EkgSession;

import java.sql.*;

public class SQL {

    private SQL() {
    }

    static private final SQL SQLOBJ = new SQL();

    static public SQL getSqlOBJ() {
        return SQLOBJ;
    }

    private final String url = "jdbc:mysql://130.225.170.242:3306/sp3";
    private final String DatabaseUser = "naveed";
    private final String DatabasePassword = "1234";//System.getenv("fanta2020"); //tomcat system startups

    private Connection myConn;
    public Statement myStatement;

    public void makeConnectionSQL() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        myConn = DriverManager.getConnection(url, DatabaseUser, DatabasePassword);
        myStatement = myConn.createStatement();
    }

    public void removeConnectionSQL() {
        try {
            if (!myConn.isClosed()) {
                myConn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public AftaleListe getAftaleListeDateTime(String fra, String til) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        AftaleListe aftaleListe = new AftaleListe();
        try {
            PreparedStatement pp = myConn.prepareStatement("SELECT * FROM sp3.aftaler WHERE TimeStart BETWEEN ? and ?;");
            pp.setString(1, fra);
            pp.setString(2, til);

            ResultSet rs = pp.executeQuery();

            while (rs.next()) {
                Aftale aftale = new Aftale();
                aftale.setCPR(String.valueOf(rs.getInt(1)));
                aftale.setTimeStart(rs.getString(2));
                aftale.setTimeEnd(rs.getString(3));
                aftale.setNotat(rs.getString(4));
                aftale.setID(rs.getString(5));
                aftale.setKlinikID(rs.getString(6));


                aftaleListe.addAftaler(aftale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();

        return aftaleListe;
    }

    public void insertAftaleSQL(Aftale aftale) throws OurException {

        try {
            makeConnectionSQL();
            PreparedStatement pp = myConn.prepareStatement("INSERT INTO sp3.aftaler (CPR, TimeStart, TimeEnd, Notat, KlinikId) values(?,?,?,?,?);");

            pp.setString(1, aftale.getCPR());  //CPR
            pp.setString(2, aftale.getTimeStart());  //starttime
            pp.setString(3, aftale.getTimeEnd());  //endtime
            pp.setString(4, aftale.getNotat());  //note
            pp.setString(5, aftale.getKlinikID()); //klinikif

            pp.execute();

            removeConnectionSQL();
        } catch (SQLException throwables) {
            OurException ex = new OurException();
            ex.setMessage("Tiden er allerede optaget.");
            throw ex;
        }
    }

    public AftaleListe getAftalerListe() throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        AftaleListe aftaleListe = new AftaleListe();
        String query = "SELECT * FROM aftaler";
        try {
            ResultSet rs = SQL.getSqlOBJ().myStatement.executeQuery(query);

            while (rs.next()) {
                Aftale aftale = new Aftale();
                aftale.setCPR(String.valueOf(rs.getInt(1)));
                aftale.setTimeStart(rs.getString(2));
                aftale.setTimeEnd(rs.getString(3));
                aftale.setNotat(rs.getString(4));
                aftale.setID(rs.getString(5));
                aftale.setKlinikID(rs.getString(6));

                aftaleListe.addAftaler(aftale);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();

        return aftaleListe;
    }

    public String hentBrugerListe(String bruger) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        PreparedStatement preparedStatement = myConn.prepareStatement("SELECT * FROM sp3.Login WHERE user = ?;");
        preparedStatement.setString(1, bruger);
        String svar = "";
        try {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                svar = svar + rs.getString(1);
                svar = svar + "|" + rs.getString(2);
                svar = svar + "|" + rs.getString(3);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();
        return svar;
    }

    public AftaleListe cprSearch(String cpr) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        PreparedStatement pp = myConn.prepareStatement("SELECT * FROM sp3.aftaler WHERE CPR = ?;");
        AftaleListe aftaleListe = new AftaleListe();
        try {
            pp.setString(1, cpr);
            ResultSet rs = pp.executeQuery();

            while (rs.next()) {
                Aftale aftale = new Aftale();
                aftale.setCPR(String.valueOf(rs.getInt(1)));
                aftale.setTimeStart(rs.getString(2));
                aftale.setTimeEnd(rs.getString(3));
                aftale.setNotat(rs.getString(4));
                aftale.setID(rs.getString(5));
                aftale.setKlinikID(rs.getString(6));

                aftaleListe.addAftaler(aftale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();
        return aftaleListe;
    }

    public void insertSessionSQL(EkgSession ekgSession) throws OurException {

        try {
            makeConnectionSQL();

            PreparedStatement pp = myConn.prepareStatement("INSERT INTO sp3.ekgSessions (cpr, sessionID, timeStart) values(?,?,?);");
            pp.setString(1, ekgSession.getCpr());  //CPR
            pp.setString(2, ekgSession.getSession());  //starttime
            pp.setString(3, ekgSession.getTimestart());  //endtime
            pp.execute();
            removeConnectionSQL();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatDataSQL(EkgSession ekgSession){

        try {
            makeConnectionSQL();

            PreparedStatement pp = myConn.prepareStatement(

                    "CREATE TABLE sp3.cpr"+ekgSession.getCpr()+"session"+ekgSession.getSession()+" (measurement INT NOT NULL AUTO_INCREMENT,"+"value VARCHAR(45) NULL,"+" PRIMARY KEY (measurement))"
            );
            pp.execute();
            removeConnectionSQL();


        } catch (SQLException throwables) {
            OurException ex = new OurException();
            ex.setMessage("Denne person har haft den angivede session");
            try {
                throw ex;
            } catch (OurException e) {
                e.printStackTrace();
            }
        }
    }
    public void insertDataSQL(EkgSession ekgSession, EkgData ekgData) throws OurException {

        try {
            makeConnectionSQL();

                for (int i = 0; i < ekgData.getData().size() - 1; i ++) {
                    String write_to_measurement = "INSERT INTO sp3.cpr"+ekgSession.getCpr()+"session"+ekgSession.getSession()+" (value) values(?);";
                    PreparedStatement PP = myConn.prepareStatement(write_to_measurement);
                    PP.setString(1, String.valueOf(ekgData.getData().get(i)));
                    PP.execute();
                }
                System.out.println("Done SQL");
                removeConnectionSQL();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

