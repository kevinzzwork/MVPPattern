package com.android.kz.mvppattern.otto;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * User: Kevin
 * Date: 14/09/15
 * Time: 9:04 PM
 */
public class MVPBus extends Bus {

    private MVPBus(ThreadEnforcer enforcer) { super(enforcer);}

    private static class MVPBusHolder {
        private static final MVPBus MVP_BUS_HOLDER = new MVPBus(ThreadEnforcer.MAIN);
    }

    public static MVPBus getInstance() {
        return MVPBusHolder.MVP_BUS_HOLDER;
    }

}
