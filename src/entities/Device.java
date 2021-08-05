/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Mostafa
 */
public class Device {
    
    int deviceId;
    String deviceName;
    String devicePrice;
    private String devicemulti;
    

    public Device(int deviceId, String deviceName, String devicePrice, String devicemulti) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.devicePrice = devicePrice;
        this.devicemulti = devicemulti;
    }

    public Device(String deviceName, String devicePrice, String devicemulti) {
        this.deviceName = deviceName;
        this.devicePrice = devicePrice;
        this.devicemulti = devicemulti;
    }


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(String devicePrice) {
        this.devicePrice = devicePrice;
    }

   
    public String getDevicemulti() {
        return devicemulti;
    }

    
    public void setDevicemulti(String devicemulti) {
        this.devicemulti = devicemulti;
    }

    
    
    
}
