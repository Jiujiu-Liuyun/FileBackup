package com.zhangyun.tools.filebackup.monitor;

import com.zhangyun.tools.filebackup.property.FileMonitorProperty;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * description: 定义文件监视器，可用来实现热更配置文件/监听文件场景
 *
 * @author: zhangyun
 * @date: 2022/7/22 00:55
 * @since: 1.0
 */
@Service
public class FileMonitor implements ApplicationRunner {

    @Autowired
    private FileAlterationListenerAdaptor listener;    // 事件处理类对象

    @Autowired
    private FileMonitorProperty monitorProperty;

    /***
     * 开启监听
     */
    public void start() {
        String sourcePath = monitorProperty.getSourcePath();
        if (sourcePath == null) {
            throw new IllegalStateException("Listen path must not be null");
        }
        if (listener == null) {
            throw new IllegalStateException("Listener must not be null");
        }

        // 设定观察者，监听文件
        FileAlterationObserver observer = new FileAlterationObserver(sourcePath);

        // 给观察者添加监听事件
        observer.addListener(listener);

        // 开启一个监视器，监听频率是interval
        // FileAlterationMonitor本身实现了 Runnable，是单独的一个线程，按照设定的时间间隔运行
        FileAlterationMonitor monitor = new FileAlterationMonitor(monitorProperty.getInterval());

        monitor.addObserver(observer);

        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        start();
    }
}
