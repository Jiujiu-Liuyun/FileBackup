package com.zhangyun.tools.filebackup.monitor;

import com.zhangyun.tools.filebackup.annotation.FBFileFilter;
import com.zhangyun.tools.filebackup.annotation.InfoLog;
import com.zhangyun.tools.filebackup.service.FBFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class FBFileAlterationListenerAdaptor extends FileAlterationListenerAdaptor {

    @Autowired
    private FBFileService fileService;

    @Override
    @InfoLog
    @FBFileFilter
    public void onFileChange(File source) {
        try {
            File target = fileService.sourceMapToTarget(source);
            fileService.fileCopy(source,target);
            super.onFileChange(source);
        } catch (Exception e) {
            log.error("文件 {} 更改，复制发生错误， {}", source, e.getMessage(), e);
        }
    }

    @Override
    @InfoLog
    @FBFileFilter
    public void onFileCreate(File source) {
        try {
            File target = fileService.sourceMapToTarget(source);
            fileService.fileCopy(source,target);
            super.onFileCreate(source);
        } catch (Exception e) {
            log.error("文件 {} 创建，复制发生错误， {}", source, e.getMessage(), e);
        }
    }

    @Override
    @InfoLog
    @FBFileFilter
    public void onFileDelete(File source) {
        try {
            File target = fileService.sourceMapToTarget(source);
            fileService.fileAndDirDelete(target);
            super.onFileDelete(source);
        } catch (Exception e) {
            log.error("源文件 {} 删除，目标文件删除发生错误， {}", source, e.getMessage(), e);
        }
    }

    @Override
    @InfoLog
    @FBFileFilter
    public void onDirectoryCreate(File source) {
        try {
            File target = fileService.sourceMapToTarget(source);
            fileService.dirCopy(source, target);
            super.onDirectoryCreate(source);
        } catch (Exception e) {
            log.error("源目录 {} 创建，目标目录创建发生错误， {}", source, e.getMessage(), e);
        }
    }

    @Override
    @InfoLog
    @FBFileFilter
    public void onDirectoryDelete(File source) {
        try {
            File target = fileService.sourceMapToTarget(source);
            fileService.fileAndDirDelete(target);
            super.onDirectoryCreate(source);
        } catch (Exception e) {
            log.error("源目录 {} 创建，目标目录创建发生错误， {}", source, e.getMessage(), e);
        }
    }

//    @Override
//    public void onStart(FileAlterationObserver observer) {
//        log.info("on start...");
//        super.onStart(observer);
//    }
//
//    @Override
//    public void onStop(FileAlterationObserver observer) {
//        log.info("on stop...");
//        super.onStop(observer);
//    }
}
