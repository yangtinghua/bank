package com.yth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

/**
 * Main
 * @author yth
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.yth"})
public class DemoMain {

    public static void main(String[] args) {
        SpringApplication.run(DemoMain.class, args);
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
    }


}
