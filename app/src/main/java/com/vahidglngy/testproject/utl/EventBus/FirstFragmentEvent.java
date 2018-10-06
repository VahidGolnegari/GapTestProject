package com.vahidglngy.testproject.utl.EventBus;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class FirstFragmentEvent {

    private boolean isYahooLink;

    public FirstFragmentEvent(boolean isYahooLink) {
        this.isYahooLink = isYahooLink;
    }

    public boolean isYahooLink() {
        return isYahooLink;
    }

    public void setYahooLink(boolean yahooLink) {
        isYahooLink = yahooLink;
    }
}
