/*
 * HeaderPanel.java
 *
 * Created on 29 March 2022, 12:10
 */
 
package uk.ac.ox.ndph.ckb;           

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.PackageResourceReference;

/** 
 *
 * @author rajanis
 * @version 
 */

public class HeaderPanel extends Panel {
    private static final String CKBRT_IMAGE = "ckbrtImg";
    private static final String SYSTEM_NAME = "system_name";
    /**
     * Construct.
     * @param wicketId
     */

    public HeaderPanel(String wicketId)
    {
        super(wicketId);
    }
    
    @Override
    protected void onInitialize() 
    {
        super.onInitialize();
        System.out.println("Header panel initialize");
        add(new Image(CKBRT_IMAGE, new PackageResourceReference(HeaderPanel.class, "Research.jpg")));
        System.out.println("Header panel - Images added");
        System.out.println("Header panel - reading system property");
        String siteAddress = System.getProperty("CKBRT_SiteAddress");
        System.out.println("Header panel - read system property");
        if (siteAddress == null)
            System.out.println("Header panel - System property was null");
        boolean isDev = siteAddress.contains("_dev");
        String systemName = getString(SYSTEM_NAME) + "(1.0.2)";
        System.out.println("Header panel - got SystemName");
        Label lblSystem = new Label(SYSTEM_NAME, systemName);
        add(lblSystem);
        System.out.println("Header panel - label added");
    }

}
