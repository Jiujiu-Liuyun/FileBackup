package com.zhangyun.tools.filebackup.monitor;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * description: 文件变动事件处理器类
 *
 * @author: zhangyun
 * @date: 2022/7/22 00:51
 * @since: 1.0
 */
@Service
public class FBFileAlterationListenerAdaptor extends FileAlterationListenerAdaptor {

    @Override
    public void onFileChange(File file) {
        System.out.println("change..." + file.getPath());
        super.onFileChange(file);
    }

    @Override
    public void onFileCreate(File file) {
        System.out.println("create..." + file.getPath());
        super.onFileCreate(file);
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("delete..." + file.getPath());
        super.onFileDelete(file);
    }

    @Override
    public void onStart(FileAlterationObserver observer) {
        System.out.println("start");
        super.onStart(observer);
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        System.out.println("stop");
        super.onStop(observer);
    }

    @Override
    public void onDirectoryChange(File directory) {
        System.out.println("dir change..." + directory.getPath());
        super.onDirectoryChange(directory);
    }

    @Override
    public void onDirectoryCreate(File directory) {
        System.out.println("dir create..." + directory.getPath());
        super.onDirectoryCreate(directory);
    }

    @Override
    public void onDirectoryDelete(File directory) {
        System.out.println("dir delete..." + directory.getPath());
        super.onDirectoryCreate(directory);
    }

}
