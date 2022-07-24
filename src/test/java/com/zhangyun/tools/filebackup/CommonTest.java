package com.zhangyun.tools.filebackup;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Date;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 00:39
 * @since: 1.0
 */
public class CommonTest {

    @Test
    public void fileTest() throws IOException {
//        File file = new File("/Users/zhangyun/test/source/t");
//        System.out.println(DateTime.of(file.lastModified()));
//        System.out.println(Files.readAttributes(Paths.get("/Users/zhangyun/test/source/t"), BasicFileAttributes.class).creationTime());
//        System.out.println(file.setLastModified(new DateTime("2022-07-01").getTime()));

//        File file = new File("/Users/zhangyun/test/source/dirc/file1");
//        System.out.println(file);
//        System.out.println(file.isDirectory());
//        System.out.println(Arrays.toString(file.list()));
//        System.out.println(Arrays.toString(file.listFiles()));

//        File source = new File("/Users/zhangyun/test/source/dirc/socks");
//        File target = new File("/Users/zhangyun/test/target/dirc/socks");
//
//        FileUtils.copyDirectory(source,target);

        File file = new File("/Users/zhangyun/test/source/demo/.DS_Store");
        System.out.println(file.getName());
    }

    @Test
    public void timeTest() {
        System.out.println(new DateTime("2022-07-01").getTime());
    }

}
