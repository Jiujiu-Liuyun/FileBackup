package com.zhangyun.tools.filebackup.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/22 23:35
 * @since: 1.0
 */
@ConfigurationProperties(prefix = "app.monitor")
@Data
public class FileMonitorProperty {

    private String sourcePath;

    private String targetPath;

    private Integer interval;

}
