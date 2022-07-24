package com.zhangyun.tools.filebackup.service;

import cn.hutool.core.util.ObjectUtil;
import com.zhangyun.tools.filebackup.annotation.TraceLog;
import com.zhangyun.tools.filebackup.exception.BlankArgumentsException;
import com.zhangyun.tools.filebackup.exception.FBBusinessException;
import com.zhangyun.tools.filebackup.property.FBFileMonitorProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 09:19
 * @since: 1.0
 */
@Service
@Slf4j
public class FBFileService {

    @Autowired
    private FBFileMonitorProperty monitorProperty;

    /**
     * 复制文件，同时复制文件的最后修改时间
     *
     * @param source
     * @param target
     * @throws IOException
     */
    @TraceLog
    public void fileCopy(File source, File target) throws IOException {
        if (ObjectUtil.isEmpty(source) || ObjectUtil.isEmpty(target)) {
            throw new BlankArgumentsException("文件为空");
        }
        FileUtils.copyFile(source, target);
        log.info("文件{} 已被复制到 文件{}", source, target);
    }

    /**
     * 复制文件，同时复制文件的最后修改时间
     *
     * @param source
     * @param target
     * @throws IOException
     */
    @TraceLog
    public void dirCopy(File source, File target) throws IOException {
        if (ObjectUtil.isEmpty(source) || ObjectUtil.isEmpty(target)) {
            throw new BlankArgumentsException("目录为空");
        }
        FileUtils.copyDirectory(source, target);
        log.info("目录{} 已被复制到 目录{}", source, target);
    }

    @TraceLog
    public void fileAndDirDelete(File target) throws IOException {
        if (ObjectUtil.isEmpty(target)) {
            throw new BlankArgumentsException("目标文件为空，删除异常！");
        }
        FileUtils.delete(target);
        log.info("{} 已被删除", target);
    }

    @TraceLog
    public File sourceMapToTarget(File source) {
        if (ObjectUtil.isEmpty(source)) {
            throw new BlankArgumentsException("目标文件为null，删除异常！");
        }
        if (!source.getPath().startsWith(monitorProperty.getSourcePath())) {
            throw new FBBusinessException("文件不在 "
                    + monitorProperty.getSourcePath() + " 目录下！");
        }
        String targetPath = source.getPath().replace(
                monitorProperty.getSourcePath(), monitorProperty.getTargetPath());
        File target = new File(targetPath);
        log.info("{} 已被映射到 {}", source, target);
        return target;
    }

}
