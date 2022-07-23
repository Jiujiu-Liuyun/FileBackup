package com.zhangyun.tools.filebackup.service;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * description: FileService测试类
 *
 * @author: zhangyun
 * @date: 2022/7/23 09:36
 * @since: 1.0
 */
public class FileServiceTest {

    @Test
    public void fileCopyTest() throws IOException {
        FBFileService fileService = new FBFileService();
        fileService.fileCopy(new File("/Users/zhangyun/test/source/t"),
                new File("/Users/zhangyun/test/target/t"));
    }

}
