package uk.ac.ox.ndph.ckb;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class UserPage1 extends WebPage {
    String userName;
    public UserPage1() {
        super();
    }
    
    @Override
    protected void onInitialize() 
    {
        super.onInitialize();
        AppSession session = (AppSession)getSession();
        userName = session.getUserName();
        System.out.println("UserPage: user is " + userName);
        if (userName == null)
            userName = "user name is null";
        add(new TextField<>("txtUserName", Model.of(userName)));
    } 
}

