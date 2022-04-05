/*
 * BasePage.java
 *
 * Created on 29 March 2022, 12:10
 */
 
package uk.ac.ox.ndph.ckb;

import javax.ejb.EJB;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/** 
 *
 * @author rajanis
 * @version 
 */

public abstract class BasePage extends WebPage {
    @EJB(name = "ControllerRts")
    private ControllerRts mControllerRts;

    public BasePage() { super(); }
    
    @Override
    protected void onInitialize() 
    {
        super.onInitialize();
        System.out.println("Base page initialize");
        add(new HeaderPanel("headerpanel")); 
        System.out.println("HeaderPanel done");
        add(new FooterPanel("footerpanel"));
        add(new Label("helpMessage", mControllerRts.getContactMail()));
        System.out.println("Returning from base page initialize");
    } 
}
