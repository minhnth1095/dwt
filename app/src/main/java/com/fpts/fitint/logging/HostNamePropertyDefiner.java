package com.fpts.fitint.logging;

import ch.qos.logback.core.PropertyDefinerBase;
import java.net.InetAddress;

public class HostNamePropertyDefiner extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            return "unknown-host";
        }
    }
}