package com.hycxkj.sensitivewdfilter.config;

import com.hycxkj.sensitivewdfilter.WordFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈少平
 * @description
 * @create in 2018/4/1 15:48
 */
@Configuration
public class SensitiveWordFilterConfig {

    @Bean
    public WordFilter wordFilter() {
        return new WordFilter();
    }
}
