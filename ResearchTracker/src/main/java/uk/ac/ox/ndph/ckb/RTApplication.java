package uk.ac.ox.ndph.ckb;

import org.apache.wicket.Session;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.wicketstuff.javaee.injection.JavaEEComponentInjector;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see uk.ac.ox.ndph.ckb.Start#main(String[])
 */
public class RTApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
            return UserPage1.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

                getComponentInstantiationListeners().add(new JavaEEComponentInjector(this));

		// needed for the styling used by the quickstart
		getCspSettings().blocking()
			.add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF)
			.add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com/css")
			.add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com");

		// add your configuration here
	}

    @Override
    public Session newSession(Request request, Response response) {
        return new AppSession(request); //To change body of generated methods, choose Tools | Templates.
    }
}
