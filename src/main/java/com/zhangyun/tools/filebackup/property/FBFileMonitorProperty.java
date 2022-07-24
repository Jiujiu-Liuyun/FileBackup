package com.zhangyun.tools.filebackup.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description:
 *
 * @author: zhangyun
 * @date: 2022/7/22 23:35
 * @since: 1.0
 */
@ConfigurationProperties(prefix = "app.monitor")
@Data
public class FBFileMonitorProperty {

    private String sourcePath;

    private String targetPath;

    private Integer interval;

    private String ignoreFileList;

}
