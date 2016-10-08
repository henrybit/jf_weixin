package com.github.jf.weixin.config;

/**
 * 行业编号表<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="380px">
 *     <tbody>
 *         <tr><th style="width:120px">主行业</th><th style="width:140px">副行业</th><th>代码</th></tr>
 *         <tr><td> IT科技</td><td> 互联网/电子商务</td><td> 1</td></tr>
 *         <tr><td> IT科技</td><td> IT软件与服务</td><td> 2</td></tr>
 *         <tr><td> IT科技</td><td> IT硬件与设备</td><td> 3</td></tr>
 *         <tr><td> IT科技</td><td> 电子技术</td><td> 4</td></tr>
 *         <tr><td> IT科技</td><td> 通信与运营商</td><td> 5</td></tr>
 *         <tr><td> IT科技</td><td> 网络游戏</td><td> 6</td></tr>
 *         <tr><td> 金融业</td><td> 银行</td><td> 7</td></tr>
 *         <tr><td> 金融业</td><td>基金|理财|信托</td><td> 8</td></tr>
 *         <tr><td> 金融业</td><td> 保险</td><td> 9</td></tr>
 *         <tr><td> 餐饮</td><td> 餐饮</td><td> 10</td></tr>
 *         <tr><td> 酒店旅游</td><td> 酒店</td><td> 11</td></tr>
 *         <tr><td> 酒店旅游</td><td> 旅游</td><td> 12</td></tr>
 *         <tr><td> 运输与仓储</td><td> 快递</td><td> 13</td></tr>
 *         <tr><td> 运输与仓储</td><td> 物流</td><td> 14</td></tr>
 *         <tr><td> 运输与仓储</td><td> 仓储</td><td> 15</td></tr>
 *         <tr><td> 教育</td><td> 培训</td><td> 16</td></tr>
 *         <tr><td> 教育</td><td> 院校</td><td> 17</td></tr>
 *         <tr><td> 政府与公共事业</td><td> 学术科研</td><td> 18</td></tr>
 *         <tr><td> 政府与公共事业</td><td> 交警</td><td> 19</td></tr>
 *         <tr><td> 政府与公共事业</td><td> 博物馆</td><td> 20</td></tr>
 *         <tr><td> 政府与公共事业</td><td>公共事业|非盈利机构</td><td> 21</td></tr>
 *         <tr><td> 医药护理</td><td> 医药医疗</td><td> 22</td></tr>
 *         <tr><td> 医药护理</td><td> 护理美容</td><td> 23</td></tr>
 *         <tr><td> 医药护理</td><td> 保健与卫生</td><td> 24</td></tr>
 *         <tr><td> 交通工具</td><td> 汽车相关</td><td> 25</td></tr>
 *         <tr><td> 交通工具</td><td> 摩托车相关</td><td> 26</td></tr>
 *         <tr><td> 交通工具</td><td> 火车相关</td><td> 27</td></tr>
 *         <tr><td> 交通工具</td><td> 飞机相关</td><td> 28</td></tr>
 *         <tr><td> 房地产</td><td>建筑</td><td> 29</td></tr>
 *         <tr><td> 房地产</td><td> 物业</td><td> 30</td></tr>
 *         <tr><td> 消费品</td><td> 消费品</td><td> 31</td></tr>
 *         <tr><td> 商业服务</td><td> 法律</td><td> 32</td></tr>
 *         <tr><td> 商业服务</td><td>会展</td><td> 33</td></tr>
 *         <tr><td> 商业服务</td><td> 中介服务</td><td> 34</td></tr>
 *         <tr><td> 商业服务</td><td>认证</td><td> 35</td></tr>
 *         <tr><td> 商业服务</td><td>审计</td><td> 36</td></tr>
 *         <tr><td> 文体娱乐</td><td>传媒</td><td> 37</td></tr>
 *         <tr><td> 文体娱乐</td><td> 体育</td><td> 38</td></tr>
 *         <tr><td> 文体娱乐</td><td> 娱乐休闲</td><td> 39</td></tr>
 *         <tr><td> 印刷</td><td>印刷</td><td> 40</td></tr>
 *         <tr><td> 其它</td><td> 其它</td><td> 41</td></tr>
 *    </tbody>
 * </table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public enum IndustryConfig {
    /**
     * 互联网/电子商务
     */
    INTERNET("互联网/电子商务", 1),

    /**
     * IT软件与服务
     */
    IT_SOFT("IT软件与服务",2),

    /**
     * IT硬件与设备
     */
    IT_HARDWARE("IT硬件与设备",3),

    /**
     * 电子技术
     */
    ELECTRONIC("电子技术",4),

    /**
     * 通信与运营商
     */
    COMMUNICATION_OPERATORS("通信与运营商",5),

    /**
     * 网络游戏
     */
    NETWORK_GAME("网络游戏",6),

    /**
     * 银行
     */
    BANK("银行",7),

    /**
     * 金融
     */
    FINANCE("金融", 8),

    /**
     * 保险
     */
    INSURANCE("保险", 9),

    /**
     *餐饮
     */
    RESTAURANT("餐饮", 10),

    /**
     * 酒店
     */
    HOTEL("酒店", 11),

    /**
     * 旅游
     */
    TRAVEL("旅游",12),

    /**
     * 快递
     */
    DELIVER("快递",13),

    /**
     * 物流
     */
    LOGISTICS("物流", 14),

    /**
     * 仓储
     */
    STORAGE("仓储", 15),

    /**
     * 培训
     */
    TRAIN("培训", 16),

    /**
     * 院校
     */
    COLLEGES("院校", 17),

    /**
     * 学术科研
     */
    ACADEMIC_RESEARCH("学术科研", 18),

    /**
     * 交警
     */
    TRAFFIC_POLICE("交警",19),

    /**
     * 博物馆
     */
    MUSEUM("博物馆", 20),

    /**
     *公共事业|非盈利机构
     */
    PUBLIC_UTILITIES("公共事业|非盈利机构", 21),

    /**
     * 医药医疗
     */
    MEDICAL_TREATMENT("医药医疗", 22),

    /**
     * 护理美容
     */
    BEAUTY_CARE("护理美容", 23),

    /**
     * 保健与卫生
     */
    HEALTH_CARE("保健与卫生", 24),

    /**
     * 汽车相关
     */
    CAR_RELATED("汽车相关", 25),

    /**
     * 摩托车相关
     */
    MOTORCYCLE_RELATED("摩托车相关", 26),

    /**
     * 火车相关
     */
    TRAIN_RELATED("火车相关", 27),

    /**
     * 飞机相关
     */
    AIRCRAFT_RELATED("飞机相关", 28),

    /**
     *建筑
     */
    BUILDING("建筑", 29),

    /**
     * 物业
     */
    PROPERTY("物业", 30),

    /**
     * 消费品
     */
    CONSUMERGOODS("消费品", 31),

    /**
     * 法律
     */
    LAWER("法律", 32),

    /**
     * 会展
     */
    EXHIBITION("会展", 33),

    /**
     * 中介服务
     */
    INTERMEDIARY_SERVICE("中介服务", 34),

    /**
     * 认证
     */
    AUTHENTICATION("认证",35),

    /**
     * 审计
     */
    ADUIT("审计", 36),

    /**
     * 传媒
     */
    MEDIA("传媒", 37),

    /**
     *体育
     */
    SPORTS("体育", 38),

    /**
     * 娱乐休闲
     */
    FUN("娱乐休闲", 39),

    /**
     * 印刷
     */
    PRINT("印刷", 40),

    /**
     * 其它
     */
    OTHER("其它", 41);


    String value;
    int code;
    IndustryConfig(String _value, int _code) {
        this.value = _value;
        this.code = _code;
    }
}
