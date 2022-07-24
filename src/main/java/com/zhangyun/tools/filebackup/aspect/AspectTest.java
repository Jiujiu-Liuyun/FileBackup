package com.zhangyun.tools.filebackup.aspect;

import com.zhangyun.tools.filebackup.annotation.FBExceptionHandler;
import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.annotation.TraceLog;
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
public class AspectTest {

    @Timer
    public void test () throws InterruptedException {
        Thread.sleep(1234);
    }

    @FBExceptionHandler
    @TraceLog
    public String testExceptionHandler (String str) throws BlankArgumentsException {
        throw new BlankArgumentsException();
    }

}
