/*
 * Copyright 2021 China kadoorie biobank.
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package uk.ac.ox.ndph.ckb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Timeout;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerService;
/**
 * @date 2021-03-29
 * @author rajanis
 */
@Singleton
@Startup
public class RTInitializer {
    static int MIN_TO_MICRO_SEC = 60 * 1000;
    @Resource
    private TimerService timerService;
    @EJB(name = "ControllerRts")
    private ControllerRts mControllerRts;

    // Default is 60 minutes
    private final int currentFrequency = 60;

    @PostConstruct
    void init() {
        System.out.println("RTInitializer... starting timer with default config");
        if (!isEnvironmentSet()) {
            System.out.println("RTInitializer:In Init:Environment not set");
            return;
        }
        System.out.println("RTInitializer .. Finished initializing");
        setTimer(currentFrequency);
    }

    /**
     * Specifying frequency of sending mails.
     * Method to initialize and
     *
     * @param dur
     */
    public void setTimer(int dur) {

        System.out.println("RTInitializer: Setting a programmatic timeout for download sweep frequency to " + dur  + " minutes from now.");
        Timer timer = timerService.createIntervalTimer(dur * MIN_TO_MICRO_SEC, dur * MIN_TO_MICRO_SEC, 
                new TimerConfig("Created new interval for CDAScheduler", false));
    }

    /**
     * The actual timer method which calls the EJB function to pull email
     * requests and sends emails.
     *
     * @param timer
     */
    @Timeout
    public void sweepDownloadsAndEmail(Timer timer) {
    }
    
    private boolean isEnvironmentSet() {
        String rtsServiceData = "Some string to connnect to service";
        mControllerRts.init(rtsServiceData);
        return true;
    }
}
