package controller;

import dataAccesLayer.SQL;
import exceptions.OurException;
import model.EkgData;
import model.EkgSession;

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




}
