package controller;

import dataAccesLayer.SQL;
import model.LoginData;
import model.User;

import javax.ws.rs.WebApplicationException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;

public class LoginController {

    private LoginController() {
    }

    static private final LoginController loginControllerOBJ = new LoginController();

    static public LoginController getLoginControllerOBJ() {
        return loginControllerOBJ;
    }

    public String doLogin(LoginData loginData) {
        try {
            // sql kald der kontrollere om brugeren eksitere
            String brugerListe = SQL.getSqlOBJ().hentBrugerListe(loginData.getUsername());

            // kontrol af login og generer token
            if (loginVal(brugerListe, loginData.getPassword())) {
                User user = new User(loginData);
                return JWTHandler.generateJwtToken(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new WebApplicationException("fejl", 401);
    }

    public boolean loginVal(String brugerliste, String pass) {
        if (brugerliste.length() > 1) {
            String[] opdelt = brugerliste.split("\\|");
            int salt = Integer.parseInt(opdelt[2]);
            String hashcheck = generateHash(pass, salt);
            if (opdelt[1].equals(hashcheck)) {
                return true;
            }
        }
        return false;
    }

    public static String generateHash(String pass, int salt) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            pass += String.valueOf(salt);
            md5.update(StandardCharsets.UTF_8.encode(pass));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pass;
    }

    public static int getSalt() {
        byte[] salt = new byte[20];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(salt);
        int saltint = salt[4];
        return saltint;
    }
}

