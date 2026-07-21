package com.fpts.fitint.logging;

import ch.qos.logback.core.PropertyDefinerBase;
import java.net.InetAddress;

public class HostIpPropertyDefiner extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return "0.0.0.0";
        }
    }
}