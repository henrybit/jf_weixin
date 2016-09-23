package com.github.jf.weixin.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

import com.github.jf.weixin.annotation.XmlField;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * XML操作解析工具
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class XMLUtil<T> {
	
	/**
	 *  <xml>
		 <ToUserName><![CDATA[toUser]]></ToUserName>
		 <FromUserName><![CDATA[fromUser]]></FromUserName> 
		 <CreateTime>1348831860</CreateTime>
		 <MsgType><![CDATA[text]]></MsgType>
		 <Content><![CDATA[this is a test]]></Content>
		 <MsgId>1234567890123456</MsgId>
		</xml>
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
        //读取文件 转换成Document  
        String xml = "<xml><ToUserName><![CDATA[henrybit]]></ToUserName><FromUserName><![CDATA[lilly]]></FromUserName> <CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";

        Document document = DocumentHelper.parseText(xml);
        //获取根节点元素对象  
        Element root = document.getRootElement();  
        //遍历  
        TreeMap<String, Object> treeMap = listNodes(root);
		Text t = parse(Text.class, treeMap);
        System.out.println(t.toUser);
        System.out.println(t.fromUser);
        System.out.println(t.createTime);
	}

    public static <T> T parse(Class<T> cls, TreeMap<String, Object> treeMap) throws Exception{
        try {
            T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (int i=0; i<fields.length; i++) {
                Field field = fields[i];
                if (field == null) continue;
                if (field.isAnnotationPresent(XmlField.class)) {
                    Class type = field.getType();
                    String name = field.getName();
                    String aliasName = field.getAnnotation(XmlField.class).name();
                    Object value = treeMap.get(name);
                    value = treeMap.get(aliasName);
                    if (type == int.class) {
                        field.set(obj, Integer.parseInt((String)value));
                    } else if (type == long.class) {
                        field.set(obj, Long.parseLong((String)value));
                    } else if (type == float.class) {
                        field.set(obj, ((Float)value).floatValue());
                    } else if (type == double.class) {
                        field.set(obj, ((Double)value).doubleValue());
                    } else if (type == char.class) {
                        field.set(obj, ((Character)value).charValue());
                    } else if (type == byte.class) {
                        field.set(obj, ((Byte)value).byteValue());
                    } else if (type == boolean.class) {
                        field.set(obj, ((Boolean)value).booleanValue());
                    } else if (type == short.class) {
                        field.set(obj, ((Short)value).shortValue());
                    } else if (type.isArray()) {

                    } else if (type == Collection.class) {

                    } else if (type == List.class) {

                    } else if (type == String.class){
                        field.set(obj, (String)value);
                    } else if (type == Integer.class) {
                        field.set(obj, (Integer)value);
                    }
                }
            }
            return (T)obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	//遍历当前节点下的所有节点  
    public static TreeMap<String, Object> listNodes(Element node){
        TreeMap<String, Object> map = new TreeMap<String, Object>();
        String name = node.getName();
        if ( !node.isRootElement() && (node.elements()==null || node.elements().size()<=1)) {
            map.put(name, node.getText());
        } else if (node.isRootElement()){
            //使用递归迭代当前节点下面的所有子节点
            Iterator<Element> iterator = node.elementIterator();

            while (iterator.hasNext()) {
                Element e = iterator.next();
                TreeMap<String, Object> subMap = listNodes(e);
                map.putAll(subMap);
            }
        } else {
            Iterator<Element> iterator = node.elementIterator();

            TreeMap<String, Object> subMap = new TreeMap<String, Object>();
            while (iterator.hasNext()) {
                Element e = iterator.next();
                TreeMap<String, Object> subInfoMap = listNodes(e);
                subMap.put(e.getName(), subInfoMap);
            }
            map.put(name, subMap);
        }
        return map;
    }
    
    public static class Text {
        @XmlField(name="ToUserName")
    	protected String toUser;
        @XmlField(name="FromUserName")
    	protected String fromUser;
        @XmlField(name="CreateTime")
        protected long createTime;

        public String getToUser() {
            return toUser;
        }

        public void setToUser(String toUser) {
            this.toUser = toUser;
        }

        public String getFromUser() {
            return fromUser;
        }

        public void setFromUser(String fromUser) {
            this.fromUser = fromUser;
        }

//        public long getCreateTime() {
//            return createTime;
//        }
//
//        public void setCreateTime(long createTime) {
//            this.createTime = createTime;
//        }
    }
}
