package com.github.jf.weixin.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

import com.github.jf.weixin.annotation.XmlField;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.util.logging.Level;

/**
 * XML操作解析工具
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class XMLUtil {
	
	private final static Logger LOG = Logger.getLogger(XMLUtil.class.getName());
	
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
	
	/**
	 * 根据XML解析成指定的对象<br>
	 * <h6 style="color:red;">注意：当解析失败时，将会返回NULL</h6>
	 * @param cls 需要解析成的类Class
	 * @param xml 待解析的XML字符格式
	 * @return T
	 */
	public static <T> T parse(Class<T> cls, String xml) {
		try {
			Document document = DocumentHelper.parseText(xml);
			//获取根节点元素对象  
        	Element root = document.getRootElement();
        	TreeMap<String, Object> treeMap = listNodes(root);
        	if (treeMap == null)
        		throw new Exception("XML解析失败:TreeMap is null");
        	return parse(cls, treeMap);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return null;
	}

	/**
	 * 解析Xml对象，转化为特定实体对象<br>
	 * TODO 待完善
	 * @param cls 对象class
	 * @param treeMap 对象的TreeMap结构
	 * @return T
	 * @throws Exception
	 */
    public static <T> T parse(Class<T> cls, TreeMap<String, Object> treeMap) throws Exception{
        try {
            T obj = cls.newInstance();
            
            List<Field> filedList = getAllFields(cls);
            for (int i=0; i<filedList.size(); i++) {
                Field field = filedList.get(i);
                if (field == null) continue;
                field.setAccessible(true);
                if (field.isAnnotationPresent(XmlField.class)) {
                    Class type = field.getType();
                    String name = field.getName();
                    String aliasName = field.getAnnotation(XmlField.class).name();
                    Object value = treeMap.get(name);
                    value = treeMap.get(aliasName);
                    if (type == int.class) {
                        field.set(obj, NumberUtil.objToint(value));
                    } else if (type == long.class) {
                        field.set(obj, NumberUtil.objTolong(value));
                    } else if (type == float.class) {
                        field.set(obj, NumberUtil.objTofloat(value));
                    } else if (type == double.class) {
                        field.set(obj, NumberUtil.objTodouble(value));
                    } else if (type == char.class) {
                        field.set(obj, ((Character)value).charValue());
                    } else if (type == byte.class) {
                        field.set(obj, ((Byte)value).byteValue());
                    } else if (type == boolean.class) {
                        field.set(obj, ((Boolean)value).booleanValue());
                    } else if (type == short.class) {
                        field.set(obj, ((Short)value).shortValue());
                    } else if (type.isArray()) {
                    	//TODO
                    } else if (type == Collection.class) {
                    	//TODO
                    } else if (type == List.class) {
                    	//TODO
                    } else if (type == String.class){
                        field.set(obj, (String)value);
                    } else if (type == Integer.class) {
                        field.set(obj, (Integer)value);
                    } else if (type == Long.class) {
                    	field.set(obj, (Long)value);
                    } else if (type == Short.class) {
                    	field.set(obj, (Short)value);
                    } else if (type == Float.class) {
                    	field.set(obj, (Float)value);
                    } else if (type == Double.class) {
                    	field.set(obj, (Double)value);
                    } else if (type == Character.class) {
                    	field.set(obj, (Character)value);
                    }
                }
            }
            return (T)obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
    /**
     * 递归获取所有该类的变量属性<br>
     * @param cls 该类的Class
     * @return List<Field>
     */
    private static List<Field> getAllFields(Class cls) {
    	if (cls == null) return null;
    	Field[] superFields = cls.getDeclaredFields();
        List<Field> fieldList = new ArrayList<Field>();
        for (int i=0; superFields!=null&&i<superFields.length; i++) {
        	Field field = superFields[i];
        	if (field == null) continue;
        	fieldList.add(field);
        }
        List<Field> superFieldList = getAllFields(cls.getSuperclass());
        if (superFieldList != null)
        	fieldList.addAll(superFieldList);
        return fieldList;
    }
	  
    /**
     * 遍历当前节点下所有子节点，并封装成TreeMap结构返回<br>
     * @param node 当前节点
     * @return TreeMap<String,Object>-返回Xml树状结构
     */
    private static TreeMap<String, Object> listNodes(Element node){
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
    
    //Test
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
