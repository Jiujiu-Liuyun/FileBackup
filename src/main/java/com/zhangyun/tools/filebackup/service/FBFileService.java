package com.zhangyun.tools.filebackup.service;

import org.apache.commons.io.FileUtils;
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
public class FBFileService {

    /**
     * 复制文件，同时复制文件的最后修改时间
     * @param source
     * @param target
     * @throws IOException
     */
    public void fileCopy(File source, File target) throws IOException {
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException ioe) {
            throw new IOException("复制文件异常");
        }
    }

    public void fileDelete(File target) {

    }

}
