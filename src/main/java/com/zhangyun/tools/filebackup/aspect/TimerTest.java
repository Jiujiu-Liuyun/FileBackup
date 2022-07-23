package com.zhangyun.tools.filebackup.aspect;

import com.zhangyun.tools.filebackup.annotation.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 17:30
 * @since: 1.0
 */
@Service
public class TimerTest {

    @Timer
    public void test () throws InterruptedException {
        Thread.sleep(1234);
    }

}
