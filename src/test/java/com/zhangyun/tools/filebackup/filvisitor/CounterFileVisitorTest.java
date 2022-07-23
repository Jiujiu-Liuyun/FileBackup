package com.zhangyun.tools.filebackup.filvisitor;

import com.zhangyun.tools.filebackup.filevisitor.CounterFileVisitor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 16:29
 * @since: 1.0
 */
public class CounterFileVisitorTest {

    @Test
    public void counter() throws IOException {
        Path path = Paths.get("/Users/zhangyun/Library/CloudStorage/OneDrive-hust.edu.cn");
        Files.walkFileTree(path, new CounterFileVisitor());
    }

}
