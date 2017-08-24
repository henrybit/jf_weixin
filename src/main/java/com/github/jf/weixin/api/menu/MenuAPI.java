package com.github.jf.weixin.api.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.github.jf.weixin.api.material.MediaAPI;
import com.github.jf.weixin.entity.model.menu.MenuButton;
import com.github.jf.weixin.entity.model.other.NewsInfo;
import com.github.jf.weixin.entity.response.menu.GetMenuConfigResponse;
import com.github.jf.weixin.enums.MenuType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.model.menu.Menu;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.menu.GetMenuResponse;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.CollectionUtil;
import com.github.jf.weixin.util.JSONUtil;

/**
 * 菜单相关API<br>
 * <ul>
 *     <li>自定义菜单创建接口(createMenu):https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN</li>
 *     <li>自定义菜单查询接口(getAPIMenu):https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN</li>
 *     <li>自定义菜单删除接口(deleteMenu):https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN</li>
 *     <li>创建个性化菜单接口(createMenu-参数Menu的Matchrule不为空):https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN</li>
 *     <li>删除个性化菜单接口(deleteConditionalMenu):https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN</li>
 *     <li>测试个性化菜单接口(tryMatchMenu):https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN</li>
 *     <li>获取自定义菜单配置接口(getAllMenu):https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN</li>
 * </ul>
 * 1.3.7支持个性化菜单
 * @author henrybit
 * @since 1.2
 * @version 2.0
 */
public class MenuAPI extends BaseAPI {

    /**private static start*/
    private static final Logger LOG = LoggerFactory.getLogger(MenuAPI.class);
    /**private static end*/


    public MenuAPI(ApiConfig config) {
        super(config);
    }

    public MenuAPI(String accessToken) {
        super(accessToken);
    }

    /**
     * 创建菜单
     * 1.3.7开始支持个性化菜单
     *
     * @param menu 菜单对象
     * @return 调用结果
     */
    public ResultType createMenu(Menu menu) {
        BeanUtil.requireNonNull(menu, "menu is null");
        String url = APIAddress.BASE_API_URL;
        if (BeanUtil.isNull(menu.getMatchrule())) {
            //普通菜单
            LOG.debug("创建普通菜单.....");
            url = APIAddress.MENU_CREATE_API;
        } else {
            //个性化菜单
            LOG.debug("创建个性化菜单.....");
            url = APIAddress.MENU_CUSTOM_API;
        }
        BaseResponse response = executePost(url, menu.toJsonString());
        return ResultType.get(response.getErrcode());
    }

    /**
     * 获取API设置的所有菜单
     *
     * @return 菜单列表对象
     */
    public GetMenuResponse getAPIMenu() {
        GetMenuResponse response;
        LOG.debug("获取最新一个菜单信息.....");
        String url = APIAddress.MENU_QUERY_API;
        BaseResponse r = executeGet(url);
        if (isSuccess(r.getErrcode())) {
            JSONObject jsonObject = JSONUtil.getJSONFromString(r.getErrmsg());
            //通过jsonpath不断修改type的值，才能正常解析- -
            List buttonList = (List) JSONPath.eval(jsonObject, "$.menu.button");
            if (CollectionUtil.isNotEmpty(buttonList)) {
                for (Object button : buttonList) {
                    List subList = (List) JSONPath.eval(button, "$.sub_button");
                    if (CollectionUtil.isNotEmpty(subList)) {
                        for (Object sub : subList) {
                            Object type = JSONPath.eval(sub, "$.type");
                            JSONPath.set(sub, "$.type", type.toString().toUpperCase());
                        }
                    } else {
                        Object type = JSONPath.eval(button, "$.type");
                        JSONPath.set(button, "$.type", type.toString().toUpperCase());
                    }
                }
            }
            response = JSONUtil.parse(jsonObject.toJSONString(), GetMenuResponse.class);
        } else {
            response = JSONUtil.parse(r.toJsonString(), GetMenuResponse.class);
        }
        return response;
    }
    
    /**
     * 本接口将会提供公众号当前使用的自定义菜单的配置，如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，而如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置。
     * <h3 style="color:red">注意：与查询接口最大区别在于可以查询到用户在微信公众号平台运营设置的菜单和API设置的菜单，还有个性化菜单，而 getAPIMenu()只能提取API设置的菜单信息</h3>
     * <pre style="font-stretch: normal; font-size: 12px; font-family: 'MicroSoft YaHei', 'Courier New', 'Andale Mono', monospace; padding: 5px 10px; border: 1px solid rgb(204, 204, 204); color: rgb(51, 51, 51); line-height: 20px; white-space: pre-wrap; word-wrap: break-word; border-radius: 3px; margin-left: 10px; widows: auto;">
     * 1、第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自定义菜单配置，并通过接口再次给公众号设置好自动回复规则，以提升公众号运营者的业务体验。
     * 2、本接口与自定义菜单查询接口的不同之处在于，本接口无论公众号的接口是如何设置的，都能查询到接口，而自定义菜单查询接口则仅能查询到使用API设置的菜单配置。
     * 3、认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
     * 4、从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
     * 5、本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，3天内有效，通过素材管理-获取临时素材接口来获取这些素材），本接口返回的图文消息为永久素材素材（通过素材管理-获取永久素材接口来获取这些素材）。</pre>
     * @see #getAPIMenu()
     */
    public GetMenuConfigResponse getAllMenu(){
    	LOG.debug("获取自定义菜单配置....");
    	String url = APIAddress.MENU_GET_CURRENT_SELFMENU_API;
    	BaseResponse baseResponse = executeGet(url);
    	if (isSuccess(baseResponse.getErrcode())) {
            //获取成功
            JSONObject jsonObject = JSONUtil.getJSONFromString(baseResponse.getErrmsg());
            //通过jsonpath不断修改type的值，才能正常解析- -
            List buttonList = (List) JSONPath.eval(jsonObject, "$.selfmenu_info.button");
            if (CollectionUtil.isNotEmpty(buttonList)) {
                for (Object button : buttonList) {
                    List subList = (List) JSONPath.eval(button, "$.sub_button.list");
                    if (CollectionUtil.isNotEmpty(subList)) {
                        for (Object sub : subList) {
                            Object type = JSONPath.eval(sub, "$.type");
                            JSONPath.set(sub, "$.type", type.toString().toUpperCase());
                        }
                    } else {
                        Object type = JSONPath.eval(button, "$.type");
                        JSONPath.set(button, "$.type", type.toString().toUpperCase());
                    }
                }
            }
            GetMenuConfigResponse response = JSONUtil.parse(jsonObject.toJSONString(), GetMenuConfigResponse.class);
            HashMap<String, List<MenuButton>> map = new HashMap<String, List<MenuButton>>();
            HashMap<String, List<NewsInfo>> newsMap = new HashMap<String, List<NewsInfo>>();
            //解析sub_button中list
            try {
                JSONArray btnArray = jsonObject.getJSONObject("selfmenu_info").getJSONArray("button");
                for (int i=0; btnArray!=null&&i<btnArray.size(); i++) {
                    JSONObject btnObj = btnArray.getJSONObject(i);
                    if (btnObj == null) continue;
                    String btnName = btnObj.getString("name");
                    List<MenuButton> menuButtonList = new ArrayList<MenuButton>();
                    JSONObject subBtnRoot = btnObj.getJSONObject("sub_button");
                    if (subBtnRoot == null) continue;
                    JSONArray subArray = subBtnRoot.getJSONArray("list");
                    for (int j=0; subArray!=null&&j<subArray.size(); j++) {
                        JSONObject subObj = subArray.getJSONObject(j);
                        if (subObj == null) continue;
                        MenuButton menuButton = JSONUtil.parse(subObj.toJSONString(), MenuButton.class);
                        if (menuButton != null)
                            menuButtonList.add(menuButton);
                        JSONObject newsRoot = subObj.getJSONObject("news_info");
                        if (newsRoot != null) {
                            String subKey = subObj.getString("value");
                            JSONArray newsArray = newsRoot.getJSONArray("list");
                            List<NewsInfo> newsInfoList = new ArrayList<NewsInfo>();
                            for (int q=0; newsArray!=null&&q<newsArray.size(); q++) {
                                JSONObject newsObj = newsArray.getJSONObject(q);
                                if (newsObj == null) continue;
                                NewsInfo newsInfo = JSONUtil.parse(newsObj.toJSONString(), NewsInfo.class);
                                newsInfoList.add(newsInfo);
                            }
                            newsMap.put(subKey, newsInfoList);
                        }
                    }

                    map.put(btnName, menuButtonList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //设置button中的sub_button和sub_button中的news_info
            try {
                Menu menu = response.getMenu();
                if (menu == null) return null;
                List<MenuButton> btnList = menu.getButtons();
                for (int i = 0; btnList != null && i < btnList.size(); i++) {
                    MenuButton menuButton = btnList.get(i);
                    if (menuButton == null) continue;
                    String name = menuButton.getName();
                    List<MenuButton> sonMenuButtons = map.get(name);
                    for (int j=0; sonMenuButtons!=null&&j<sonMenuButtons.size(); j++) {
                        MenuButton sonMenuBtn = sonMenuButtons.get(j);
                        if (sonMenuBtn == null) continue;
                        if (MenuType.NEWS == sonMenuBtn.getType()) {
                            //设置sub_button中的news_info
                            String sonKey = sonMenuBtn.getValue();
                            sonMenuBtn.setNewsInfos(newsMap.get(sonKey));
                        }
                    }
                    menuButton.setSubButton(sonMenuButtons);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        } else {
            //获取失败
        }
    	return null;
    }
    
    /**
     * 删除所有菜单，包括个性化菜单
     *
     * @return 调用结果
     */
    public ResultType deleteMenu() {
        LOG.debug("删除菜单.....");
        String url = APIAddress.MENU_DELETE_API;
        BaseResponse response = executeGet(url);
        return ResultType.get(response.getErrcode());
    }

    /**
     * 删除个性化菜单
     *
     * @param menuId 个性化菜单ID
     * @return 调用结果
     * @since 1.3.7
     */
    public ResultType deleteConditionalMenu(String menuId) {
        BeanUtil.requireNonNull(menuId, "menuid is null");
        LOG.debug("删除个性化菜单.....");
        String url = APIAddress.MENU_CUSTOM_DELETE_API;
        Map<String, String> params = new HashMap<String, String>();
        params.put("menuid", menuId);
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 测试个性化菜单
     *
     * @param userId 可以是粉丝的OpenID，也可以是粉丝的微信号
     * @return 该用户可以看到的菜单
     * @since 1.3.7
     */
    public GetMenuResponse tryMatchMenu(String userId) {
        BeanUtil.requireNonNull(userId, "userId is null");
        LOG.debug("测试个性化菜单.....");
        GetMenuResponse response;
        String url = APIAddress.MENU_CUSTOM_TEST_API;
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_id", userId);
        BaseResponse r = executePost(url, JSONUtil.toJson(params));
        if (isSuccess(r.getErrcode())) {
            JSONObject jsonObject = JSONUtil.getJSONFromString(r.getErrmsg());
            //通过jsonpath不断修改type的值，才能正常解析- -
            List buttonList = (List) JSONPath.eval(jsonObject, "$.menu.button");
            if (CollectionUtil.isNotEmpty(buttonList)) {
                for (Object button : buttonList) {
                    List subList = (List) JSONPath.eval(button, "$.sub_button");
                    if (CollectionUtil.isNotEmpty(subList)) {
                        for (Object sub : subList) {
                            Object type = JSONPath.eval(sub, "$.type");
                            JSONPath.set(sub, "$.type", type.toString().toUpperCase());
                        }
                    } else {
                        Object type = JSONPath.eval(button, "$.type");
                        JSONPath.set(button, "$.type", type.toString().toUpperCase());
                    }
                }
            }
            response = JSONUtil.parse(jsonObject.toJSONString(), GetMenuResponse.class);
        } else {
            response = JSONUtil.parse(r.toJsonString(), GetMenuResponse.class);
        }
        return response;
    }
}
