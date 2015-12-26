package com.example.zahid.brtc.DataBase;

/**
 * Created by ZAHID on 11/23/2015.
 */
public class Helper {
    public int id;
    public String vehicleNo;
    public String tire;
    public String gearBox;
    public String Mobil;
    public String oil;
    public String engine;

    public Helper() {
    }

    public Helper(int id, String vehicleNo, String tire, String gearBox, String mobil, String oil, String engine) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.tire = tire;
        this.gearBox = gearBox;
        Mobil = mobil;
        this.oil = oil;
        this.engine = engine;
    }

    public Helper(String vehicleNo, String tire, String gearBox, String mobil, String oil, String engine) {
        this.vehicleNo = vehicleNo;
        this.tire = tire;
        this.gearBox = gearBox;
        Mobil = mobil;
        this.oil = oil;
        this.engine = engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getTire() {
        return tire;
    }

    public String getGearBox() {
        return gearBox;
    }

    public String getMobil() {
        return Mobil;
    }

    public String getOil() {
        return oil;
    }

    public String getEngine() {
        return engine;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public void setMobil(String mobil) {
        Mobil = mobil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Helper{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", tire='" + tire + '\'' +
                ", gearBox='" + gearBox + '\'' +
                ", Mobil='" + Mobil + '\'' +
                ", oil='" + oil + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
