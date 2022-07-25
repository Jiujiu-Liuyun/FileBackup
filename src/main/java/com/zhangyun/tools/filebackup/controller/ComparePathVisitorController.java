package com.zhangyun.tools.filebackup.controller;

import com.zhangyun.tools.filebackup.annotation.Timer;
import com.zhangyun.tools.filebackup.filevisitor.ComparePathVisitor;
import com.zhangyun.tools.filebackup.filevisitor.CounterFileVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/23 17:50
 * @since: 1.0
 */
@RestController
@RequestMapping("/comparePath")
public class ComparePathVisitorController {

    @Autowired
    private ComparePathVisitor comparePathVisitor;

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compare(@PathParam("source") String source,
                          @PathParam("target") String target) throws IOException {
        comparePathVisitor.comparePath(Paths.get(source), Paths.get(source));

        return "比较完毕！";
    }

}
