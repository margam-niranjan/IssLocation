package com.example.issLocation.apiResponse;

public class UserInfo {
    private String ipAddress;
    private String hostname;
    private String browserInfo;
    private String sessionId;
    private String deviceName;

    // Constructor
    public UserInfo(String ipAddress, String hostname, String browserInfo, String sessionId, String deviceName) {
        this.ipAddress = ipAddress;
        this.hostname = hostname;
        this.browserInfo = browserInfo;
        this.sessionId = sessionId;
        this.deviceName = deviceName;
    }

    // Getters and Setters
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(String browserInfo) {
        this.browserInfo = browserInfo;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


}
