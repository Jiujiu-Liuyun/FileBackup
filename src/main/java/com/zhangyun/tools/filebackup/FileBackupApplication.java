package com.zhangyun.tools.filebackup;

import com.zhangyun.tools.filebackup.filevisitor.CounterFileVisitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FileBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileBackupApplication.class, args);
        log.info("服务启动成功！");
        log.warn("this is warn message!");
        log.error("this is warn message!");
    }

}
