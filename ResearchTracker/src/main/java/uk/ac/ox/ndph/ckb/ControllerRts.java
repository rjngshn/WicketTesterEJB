/*
 * Copyright 2022 rajanis.
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package uk.ac.ox.ndph.ckb;

import javax.ejb.Stateless;

/**
 * @date 2022-04-01
 * @author rajanis
 */
@Stateless
public class ControllerRts {
    private static int appId;
    private static String rtsPojo;
    public void init(String rtsServiceData){
        rtsPojo = rtsServiceData;
        appId = 2;
    } 

    public static int getAppId() {
        return appId;
    }
    
    public String getContactMail()  {
        return "ContactEmail";
    }
    
    public String getLoginMessage() {
        return "LoginMessage";
    }

}
