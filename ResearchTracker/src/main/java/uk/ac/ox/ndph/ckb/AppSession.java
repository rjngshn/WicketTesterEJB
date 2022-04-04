/*
 * Copyright 2022 rajanis.
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package uk.ac.ox.ndph.ckb;

import java.io.Serializable;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * @date 2022-03-31
 * @author rajanis
 */
public class AppSession extends WebSession implements Serializable{
    String userName;
    public AppSession(Request request) {
        super(request);
        if (request.getRequestParameters().getParameterValue("userName") != null)
            userName = request.getRequestParameters().getParameterValue("userName").toString();
        else 
            userName = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
