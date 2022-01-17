package controller;

import dataAccesLayer.SQL;
import exceptions.OurException;
import model.AftaleListe;
import model.EkgData;
import model.EkgSession;
import model.EkgSessionList;

import java.sql.SQLException;

public class EkgController {

    private EkgController() {
    }

    static private final EkgController EkgControllerObj = new EkgController();

    static public EkgController  getEkgControllerObj() {
        return EkgControllerObj;
    }

    public void insertPythonData(EkgSession ekgSession,EkgData ekgData){
        try {
            SQL.getSqlOBJ().insertSessionSQL(ekgSession);
            SQL.getSqlOBJ().creatDataSQL(ekgSession);
            SQL.getSqlOBJ().insertDataSQL(ekgSession,ekgData);
        } catch (OurException e) {
            e.printStackTrace();
        }
    }

    public EkgSession insertHttpHeaders(String cpr, String session, String timestart){
        EkgSession ekgSession = new EkgSession();
        ekgSession.setCpr(cpr);
        ekgSession.setSession(session);
        ekgSession.setTimestart(timestart);
        return ekgSession;
    }


    public EkgSessionList cprSearchEkg(String cpr) throws SQLException, OurException {
        if (cpr == null) {
            return SQL.getSqlOBJ().getEkgSessionList();
        }
        if (cprCheck(cpr)) {
            return SQL.getSqlOBJ().getEkgSessionListCpr(cpr);
        }
        return new EkgSessionList();
    }

    public boolean cprCheck(String name) {
        try {
            double test = Double.parseDouble(name);
            return name.length() == 10;
        } catch (Exception e) {
            return false;
        }
    }

}
