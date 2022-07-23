package com.zhangyun.tools.filebackup;

import com.zhangyun.tools.filebackup.filevisitor.CounterFileVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileBackupApplication.class, args);
    }

}
