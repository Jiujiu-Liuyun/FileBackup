package com.zhangyun.tools.filebackup.controller;

import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.aspect.TimerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 17:33
 * @since: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TimerTest timerTest;

    @RequestMapping(value = "/timerTest", method = RequestMethod.GET)
    public void timerTest() throws InterruptedException {
        timerTest.test();
    }

    @Timer
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() throws InterruptedException {
        Thread.sleep(2000);
        return "test";
    }

}