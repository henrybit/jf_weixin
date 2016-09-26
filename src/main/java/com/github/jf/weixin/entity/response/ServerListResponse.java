package com.github.jf.weixin.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 服务列表反馈信息<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *         成功:<br>
 *         {@code
 *          {"ip_list":["127.0.0.1","127.0.0.1"]}
 *         }
 *     </li>
 *     <li>
 *         失败:<br>
 *         {@code
 *          {"errcode":40013,"errmsg":"invalid appid"}
 *         }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class ServerListResponse extends BaseResponse{
    @JSONField(name="ip_list")
    private List<String> ipList;

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }
}
