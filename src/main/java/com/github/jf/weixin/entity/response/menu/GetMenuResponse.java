package com.github.jf.weixin.entity.response.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.menu.Menu;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 自定义菜单查询接口-返回结果<br>
 * <ul>
 * 	<label>范例:</label>
 * 	<li>
 * 		<h3>返回说明（无个性化菜单时）</h3>
 *      {@code
 *      {"menu": 
			{"button": 
			[{
                "type": "click", 
                "name": "今日歌曲", 
                "key": "V1001_TODAY_MUSIC", 
                "sub_button": [ ]
            }, 
            {
                "type": "click", 
                "name": "歌手简介", 
                "key": "V1001_TODAY_SINGER", 
                "sub_button": [ ]
            }, 
            {
                "name": "菜单", 
                "sub_button": [
                    {
                        "type": "view", 
                        "name": "搜索", 
                        "url": "http://www.soso.com/", 
                        "sub_button": [ ]
                    }, 
                    {
                        "type": "view", 
                        "name": "视频", 
                        "url": "http://v.qq.com/", 
                        "sub_button": [ ]
                    }, 
                    {
                        "type": "click", 
                        "name": "赞一下我们", 
                        "key": "V1001_GOOD", 
                        "sub_button": [ ]
                     }
                   ]
           	   }]
    	      }
		   }//menu
 *      }
 * 	</li>
 *  <li>
 *	<h3>返回说明（有个性化菜单时）</h3>
 *      {@code
 *           {
			    "menu": {
			        "button": [
			            {
			                "type": "click", 
			                "name": "今日歌曲", 
			                "key": "V1001_TODAY_MUSIC", 
			                "sub_button": [ ]
			            }
			        ], 
			        "menuid": 208396938
			    }, 
			    "conditionalmenu": [
			        {
			            "button": [
			                {
			                    "type": "click", 
			                    "name": "今日歌曲", 
			                    "key": "V1001_TODAY_MUSIC", 
			                    "sub_button": [ ]
			                }, 
			                {
			                    "name": "菜单", 
			                    "sub_button": [
			                        {
			                            "type": "view", 
			                            "name": "搜索", 
			                            "url": "http://www.soso.com/", 
			                            "sub_button": [ ]
			                        }, 
			                        {
			                            "type": "view", 
			                            "name": "视频", 
			                            "url": "http://v.qq.com/", 
			                            "sub_button": [ ]
			                        }, 
			                        {
			                            "type": "click", 
			                            "name": "赞一下我们", 
			                            "key": "V1001_GOOD", 
			                            "sub_button": [ ]
			                        }
			                    ]
			                }
			            ], 
			            "matchrule": {
			                "group_id": 2, 
			                "sex": 1, 
			                "country": "中国", 
			                "province": "广东", 
			                "city": "广州", 
			                "client_platform_type": 2
			            }, 
			            "menuid": 208396993
			        }
			    ]
			}
 *      }
 *  </li>
 * </ul>
 * @author peiyu, henrybit
 * @since 1.3
 * @version 2.0
 */
public class GetMenuResponse extends BaseResponse {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1243495601532394243L;
	@JSONField(name="menu")
	private Menu menu;
	@JSONField(name="conditionalmenu")
	private Menu conditionalMenu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

	public Menu getConditionalMenu() {
		return conditionalMenu;
	}

	public void setConditionalMenu(Menu conditionalMenu) {
		this.conditionalMenu = conditionalMenu;
	}
}
