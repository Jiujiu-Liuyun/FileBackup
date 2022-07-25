package com.zhangyun.tools.filebackup.aspect;

import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.annotation.InfoLog;
import com.zhangyun.tools.filebackup.exception.BlankArgumentsException;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 17:30
 * @since: 1.0
 */
@Service
@Deprecated
public class AspectTest {

    @Timer
    public void test() throws InterruptedException {
        Thread.sleep(1234);
    }

    @InfoLog
    public void testExceptionHandler(String str) {
        tt();
    }

    public void tt() {
        throw new BlankArgumentsException();
    }

}
