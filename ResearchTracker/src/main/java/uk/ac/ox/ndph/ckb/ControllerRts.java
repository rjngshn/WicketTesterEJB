/*
 * Copyright 2022 rajanis.
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package uk.ac.ox.ndph.ckb;

import jakarta.enterprise.context.ApplicationScoped;


/**
 * @date 2022-04-01
 * @author rajanis
 */
@ApplicationScoped
public class ControllerRts {
    private static int appId;
    private static String rtsPojo;
    public static final String contactMail = "contactMail";
    public void init(String rtsServiceData){
        rtsPojo = rtsServiceData;
        appId = 2;
    } 

    public static int getAppId() {
        return appId;
    }
    
    public static String getContactMail()  {
        return "ContactEmail";
    }
    
    public static String getLoginMessage() {
        return "LoginMessage";
    }

}
