package com.github.jf.fastweixin;

import com.github.jf.fastweixin.config.ConfigChangeNotice;
import com.github.jf.fastweixin.handle.AbstractApiConfigChangeHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author peiyu
 */
public class TestConfigChangeHandle extends AbstractApiConfigChangeHandle {

    private static final Logger LOG = LoggerFactory.getLogger(TestConfigChangeHandle.class);

    @Override
    public void configChange(ConfigChangeNotice notice) {
        LOG.debug("收到通知.....");
        LOG.debug(notice.toJsonString());
    }
}
