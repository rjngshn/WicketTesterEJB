/*
 * BasePage.java
 *
 * Created on 29 March 2022, 12:10
 */
 
package uk.ac.ox.ndph.ckb;

import java.text.MessageFormat;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.PackageResourceReference;

/** 
 *
 * @author rajanis
 * @version 
 */

public abstract class BasePage extends WebPage {

    public BasePage() { super(); }
    
    @Override
    protected void onInitialize() 
    {
        super.onInitialize();
        System.out.println("Base page initialize");
        add(new HeaderPanel("headerpanel")); 
        System.out.println("HeaderPanel done");
        add(new FooterPanel("footerpanel"));
        System.out.println("Returning from base page initialize");
    } 
}
