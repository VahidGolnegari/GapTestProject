package com.vahidglngy.testproject.utl.EventBus;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class AdapterModel {

    private boolean isFirstItemClicked = false;

    public AdapterModel(boolean isFirstItemClicked) {
        this.isFirstItemClicked = isFirstItemClicked;
    }

    public boolean isFirstItemClicked() {
        return isFirstItemClicked;
    }

    public void setFirstItemClicked(boolean firstItemClicked) {
        isFirstItemClicked = firstItemClicked;
    }
}
