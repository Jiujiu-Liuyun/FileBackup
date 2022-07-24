package com.zhangyun.tools.filebackup.controller;

import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.filevisitor.CounterFileVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 17:50
 * @since: 1.0
 */
@RestController
@RequestMapping("/counterFileVisitor")
public class CounterFileVisitorController {

    @Autowired
    private CounterFileVisitor counterFileVisitor;

    @RequestMapping(value = "/counterFile", method = RequestMethod.GET)
    @Timer
    public String counterFile(@PathParam("path") String path)
            throws InterruptedException, IOException {
        counterFileVisitor.getFileAndDirCounter(path);

        return "查询完毕! fileCounter: " + counterFileVisitor.getFileCounter()
                + ", dirCounter: " + counterFileVisitor.getDirCounter();
    }

}
