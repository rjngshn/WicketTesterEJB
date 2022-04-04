/*
 * FooterPanel.java
 *
 * Created on 29 March 2022, 12:10
 */
 
package uk.ac.ox.ndph.ckb;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/** 
 *
 * @author rajanis
 * @version 
 */

public final class FooterPanel extends Panel {

    public FooterPanel(String wicketId) {
        super(wicketId);
        add(new Label("footerpanel_text", "© China Kadoorie Biobank (CKB) 2016"));
    }

}
