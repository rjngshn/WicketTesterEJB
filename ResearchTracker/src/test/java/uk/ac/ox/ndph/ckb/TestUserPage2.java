package uk.ac.ox.ndph.ckb;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Simple test using the WicketTester
 */
public class TestUserPage2
{
    private WicketTester tester;

    @BeforeEach
    public void setUp()
    {
        tester = new WicketTester(new RTApplication());
    }
// https://stackoverflow.com/questions/70258881/wicket-9-unit-testing-mockito-httpsession
    @Test
    public void userPage2RendersSuccessfully()
    {
        System.out.println("Testing userPage2RendersSuccessfully ");
        System.out.println("Getting AppSession");
        // https://stackoverflow.com/questions/71675884/accessing-attributes-of-session-throws-nullpointerexception-error-when-using-wi        
        WebSession webSession = (WebSession)tester.getSession();
        AppSession appSession = (AppSession)webSession;
        appSession.setUserName("Test user 1");
        System.out.println("Uesr name in session:" + appSession.getUserName());
        //https://stackoverflow.com/questions/71708685/wickettester-fails-if-wicket-page-accesses-system-properties
        System.setProperty("CKBRT_SiteAddress", "ResearchTracker_dev");
        //start and render the test page
        tester.startPage(UserPage2.class);
        //assert rendered page class
        tester.assertRenderedPage(UserPage2.class);
        tester.assertModelValue("txtUserName", "Test user 1");
        webSession = (WebSession)tester.getSession();
        appSession = (AppSession)webSession;
        appSession.setUserName("Test user 2");
        tester.startPage(UserPage2.class);
        //assert rendered page class
        tester.assertRenderedPage(UserPage2.class);
        tester.assertModelValue("txtUserName", "Test user 2");
        System.out.println("Complete testing userPage2RendersSuccessfully ");
    }
}
