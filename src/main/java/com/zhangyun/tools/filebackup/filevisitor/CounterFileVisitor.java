package com.zhangyun.tools.filebackup.filevisitor;

import cn.hutool.core.util.ObjectUtil;
import com.zhangyun.tools.filebackup.annotation.FBFileFilter;
import com.zhangyun.tools.filebackup.annotation.InfoLog;
import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.exception.BlankArgumentsException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * description: 对指定目录下的文件和文件夹计数
 *
 * @author: zhangyun
 * @date: 2022/7/23 16:22
 * @since: 1.0
 */
@Service
@Slf4j
@Data
public class CounterFileVisitor extends SimpleFileVisitor<Path> {

    private Long dirCounter = 0L;

    private Long fileCounter = 0L;

    @Override
    @FBFileFilter
    public FileVisitResult visitFile(Path source, BasicFileAttributes attrs) throws IOException {
        fileCounter++;
        return super.visitFile(source, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        log.error("visit file {} failed! error message: {}", file, exc.getMessage(), exc);
        return super.visitFileFailed(file, exc);
    }

    @Override
    @FBFileFilter
    public FileVisitResult postVisitDirectory(Path source, IOException exc) throws IOException {
        dirCounter++;
        return super.postVisitDirectory(source, exc);
    }

    /**
     * 文件和文件夹计数器
     * @param path
     * @throws IOException
     */
    @InfoLog
    @Timer
    public void getFileAndDirCounter(String path) throws IOException {
        if (ObjectUtil.isEmpty(path)) {
            log.error("文件目录计数器异常，路径位为空： {}", path);
            throw new BlankArgumentsException("空参数异常！");
        }
        setFileCounter(0L);
        setDirCounter(0L);
        Files.walkFileTree(Paths.get(path), this);
        log.info("文件个数以及目录查询成功，file: {}个, dir: {}个", fileCounter, dirCounter);
    }
}
