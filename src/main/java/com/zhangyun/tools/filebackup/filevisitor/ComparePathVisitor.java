package com.zhangyun.tools.filebackup.filevisitor;

import cn.hutool.core.util.ObjectUtil;
import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.annotation.InfoLog;
import com.zhangyun.tools.filebackup.service.FBFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 比较两个路径下的文件是否一样（文件名，修改时间，文件大小）
 *
 * @author: zhangyun
 * @date: 2022/7/24 20:03
 * @since: 1.0
 */
@Service
@Slf4j
public class ComparePathVisitor extends SimpleFileVisitor<Path> {

    @Autowired
    private FBFileService fileService;

    private Path source;

    private Path target;

    /**
     * 比较两个文件夹是否一致
     * @param dir
     * @param attrs
     * @return
     * @throws IOException
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        File sour = new File(dir.toUri());
        File targ = fileService.sourceMapToTarget(sour);
        if (!targ.exists()) {
            log.warn("source dir: {} exist, but target dir {} does not exist", sour, targ);
        } else if (targ.isFile()) {
            log.warn("source: {} is a dir, but target {} is a file", sour, targ);
        } else if (ObjectUtil.notEqual(sour.lastModified(), targ.lastModified())) {
            // 最后修改日期不相等
            log.warn("source dir {} and target dir {} do not match!", sour, targ);
        }
        // 比较文件目录 - 将source目录下与target目录对应的文件删除
        // 剩下的target就是source中不存在的文件
        String[] sourceFileList = sour.list();
        List<String> targetFileList = Arrays.stream(targ.list())
                .filter(targetFile -> {
                    for (String sourceFile : sourceFileList) {
                        if(ObjectUtil.equal(targetFile, sourceFile)) {
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());
        // 打印target中存在但source中不存在的文件或目录
        if (ObjectUtil.isNotEmpty(targetFileList)) {
            log.warn("target dir {} 中存在，但source dir {} 中不存在的文件或目录：{}",
                    targ, sour, targetFileList);
        }
        return super.preVisitDirectory(dir, attrs);
    }

    /**
     * 比较两个文件是否相等
     * @param file
     * @param attrs
     * @return
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File sour = new File(file.toUri());
        File targ = fileService.sourceMapToTarget(sour);
        if (!targ.exists()) {
            log.warn("source file: {} exist, but target file {} does not exist", sour, targ);
        } else if (targ.isDirectory()) {
            log.warn("source file: {} is a file, but target file {} is a directory", sour, targ);
        } else if (ObjectUtil.notEqual(sour.lastModified(), targ.lastModified())
                || ObjectUtil.notEqual(sour.length(), targ.length())) {
            // 最后修改日期不相等或者文件大小不想等
            log.warn("source file {} and target file {} do not match!", sour, targ);
        }

        return super.visitFile(file, attrs);
    }

    /**
     * 比较两个路径的文件是否一致
     *
     * @param source
     * @param target
     * @throws IOException
     */
    @InfoLog
    @Timer
    public void comparePath(Path source, Path target) throws IOException {
        this.source = source;
        this.target = target;
        Files.walkFileTree(source, this);
        log.info("比较完成！");
    }
}
