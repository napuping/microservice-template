package com.nap.up.common.standard.session;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @creator napuping
 * @createTime 2020/3/3
 * @description
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "system.session")
public class SessionConfig {
    private String type;
}
