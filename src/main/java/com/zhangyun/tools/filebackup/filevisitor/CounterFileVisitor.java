package com.zhangyun.tools.filebackup.filevisitor;

import cn.hutool.core.util.ObjectUtil;
import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.annotation.TraceLog;
import com.zhangyun.tools.filebackup.exception.BlankArgumentsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
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
public class CounterFileVisitor extends SimpleFileVisitor {

    private Long dirCounter = 0L;

    private Long fileCounter = 0L;

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {

        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        fileCounter++;
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        dirCounter++;
        return super.postVisitDirectory(dir, exc);
    }

    public Long getDirCounter() {
        return dirCounter;
    }

    public void setDirCounter(Long dirCounter) {
        this.dirCounter = dirCounter;
    }

    public Long getFileCounter() {
        return fileCounter;
    }

    public void setFileCounter(Long fileCounter) {
        this.fileCounter = fileCounter;
    }

    /**
     * 文件和文件夹计数器
     * @param path
     * @throws IOException
     */
    @TraceLog
    public void getFileAndDirCounter(String path) throws IOException {
        if (ObjectUtil.isEmpty(path)) {
            log.error("文件目录计数器异常，路径位为空： {}", path);
            throw new BlankArgumentsException("空参数异常！");
        }
        setFileCounter(0L);
        setDirCounter(0L);
        Files.walkFileTree(Paths.get(path), this);
    }
}
