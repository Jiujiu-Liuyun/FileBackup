package com.zhangyun.tools.filebackup.config;

import com.zhangyun.tools.filebackup.property.FileMonitorProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * description: 配置累
 *
 * @author: zhangyun
 * @date: 2022/7/22 01:09
 * @since: 1.0
 */
@EnableConfigurationProperties(FileMonitorProperty.class)
@SpringBootConfiguration
public class FileBackupConfig {

}
