package com.zhangyun.tools.filebackup.monitor;

import cn.hutool.core.util.ObjectUtil;
import com.zhangyun.tools.filebackup.annotation.FBFileFilter;
import com.zhangyun.tools.filebackup.annotation.TraceLog;
import com.zhangyun.tools.filebackup.property.FBFileMonitorProperty;
import com.zhangyun.tools.filebackup.service.FBFileService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

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
    @TraceLog
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
    @TraceLog
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
    @TraceLog
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
    @TraceLog
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
    @TraceLog
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

}
