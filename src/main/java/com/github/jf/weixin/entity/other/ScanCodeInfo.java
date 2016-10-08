package com.github.jf.weixin.entity.other;

import com.github.jf.weixin.annotation.XmlField;

import java.io.Serializable;

/**
 * 扫描信息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class ScanCodeInfo implements Serializable {
    @XmlField(name="ScanType")
    private String scanType;
    @XmlField(name="ScanResult")
    private String scanResult;
    public String getScanType() {
        return scanType;
    }
    public void setScanType(String scanType) {
        this.scanType = scanType;
    }
    public String getScanResult() {
        return scanResult;
    }
    public void setScanResult(String scanResult) {
        this.scanResult = scanResult;
    }
}
