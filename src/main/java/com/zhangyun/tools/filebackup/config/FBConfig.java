package com.zhangyun.tools.filebackup.config;

import com.zhangyun.tools.filebackup.property.FBFileMonitorProperty;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * description: 配置累
 *
 * @author: zhangyun
 * @date: 2022/7/22 01:09
 * @since: 1.0
 */
@EnableConfigurationProperties(FBFileMonitorProperty.class)
@SpringBootConfiguration
public class FBConfig {

}
