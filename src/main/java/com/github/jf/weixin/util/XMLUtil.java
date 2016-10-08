package com.github.jf.weixin.util;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

import com.github.jf.weixin.annotation.XmlField;
import com.github.jf.weixin.entity.message.recevice.EventMessage;
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
        xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName><FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName><CreateTime>1408090651</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[pic_sysphoto]]></Event><EventKey><![CDATA[6]]></EventKey><SendPicsInfo><Count>1</Count><PicList><item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum></item></PicList></SendPicsInfo></xml>";
        //xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName><FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName><CreateTime>1408090651</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[pic_sysphoto]]></Event><EventKey><![CDATA[6]]></EventKey><SendPicsInfo><Count>1</Count><PicList><item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum></item><item><PicMd5Sum><![CDATA[352fdsf4354354332343243243212321]]></PicMd5Sum></item></PicList></SendPicsInfo></xml>";
        //遍历
        EventMessage eventMessage = parse(EventMessage.class, xml);
        System.out.println(toXml(eventMessage));
	}

    /**
     * 将对象转化成XML格式数据<br>
     * @param obj
     * @return
     */
    public static <T> String toXml(T obj) {
        return toXml(obj, "xml");
    }


    /**
     * 将对象转化成XML格式数据<br>
     * @param obj 待转化对象
     * @return String
     */
    public static <T> String toXml(T obj, String labelName) {
        if (obj != null) {
            StringBuilder xml = new StringBuilder("<").append(labelName).append(">");
            Class cls = obj.getClass();
            if (cls == Map.class || cls == TreeMap.class || cls == HashMap.class) {
                Map map = ((Map)obj);
                Iterator<String> iterator = map.keySet().iterator();

                while(iterator.hasNext()) {
                    String key = iterator.next();
                    Object value = map.get(key);
                    if (value instanceof String) {
                        xml.append("<").append(key).append(">").append((String)value)
                                .append("</").append(key).append(">");
                    } else if (value instanceof Map) {
                        String subXml = toXml(value, key);
                        xml.append(subXml);
                    }

                }
                return xml.toString();
            } else {
                List<Field> filedList = getAllFields(cls);
                for (int i = 0; filedList != null && i < filedList.size(); i++) {
                    Field field = filedList.get(i);
                    if (field == null) continue;
                    field.setAccessible(true);
                    XmlField annotation = field.getAnnotation(XmlField.class);
                    String aliasName = field.getName();
                    if (annotation != null)
                        aliasName = annotation.name();
                    if ("serialVersionUID".equals(aliasName)) continue;
                    Class type = field.getType();
                    if (type == int.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldInt(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == long.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldLong(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == float.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldFloat(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == double.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldDouble(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == char.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldChar(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == byte.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldByte(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == boolean.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldBoolean(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == short.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldShort(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type.isArray()) {
                        //TODO
                    } else if (type == Map.class) {
                        //TODO
                    } else if (type == List.class) {
                        List list = getFieldList(obj, field);
                        for (int j = 0; list != null && j < list.size(); j++) {
                            String subXml = toXml(list.get(j), aliasName);
                            xml.append(subXml);
                        }
                    } else if (type == String.class) {
                        String value = getFieldString(obj, field);
                        if (!StringUtil.isBlank(value))
                            xml.append("<").append(aliasName).append("><![CDATA[").append(value).append("]]></").append(aliasName).append(">");
                    } else if (type == Integer.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldInt(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == Long.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldLong(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == Short.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldShort(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == Float.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldFloat(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == Double.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldDouble(obj, field)).append("</").append(aliasName).append(">");
                    } else if (type == Character.class) {
                        xml.append("<").append(aliasName).append(">").append(getFieldChar(obj, field)).append("</").append(aliasName).append(">");
                    } else {
                        String subXml = toXml(getFieldObject(obj, field), aliasName);
                        if (!StringUtil.isBlank(subXml))
                            xml.append(subXml);
                    }
                }
                xml.append("</").append(labelName).append(">");
                return xml.toString();
            }
        }
        return "";
    }

    /**
     * Field取Map
     * @param obj
     * @param field
     * @return
     */
    private static Map getFieldMap(Object obj, Field field) {
        try {
            return (Map) field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Field取List<br>
     * @param obj
     * @param field
     * @return
     */
    private static List getFieldList(Object obj, Field field) {
        try {
            return (List)field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Field取Object<br>
     * @param obj
     * @param field
     * @return
     */
    private static Object getFieldObject(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Field取String<br>
     * @param obj
     * @param field
     * @return
     */
    private static String getFieldString(Object obj, Field field) {
        try {
            return (String)field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Field取Int<br>
     * @param obj
     * @param field
     * @return
     */
    private static int getFieldInt(Object obj, Field field) {
        try {
            int value = field.getInt(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Field取Long<br>
     * @param obj
     * @param field
     * @return
     */
    private static long getFieldLong(Object obj, Field field) {
        try {
            long value = field.getLong(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1L;
    }

    /**
     * Field取char<br>
     * @param obj
     * @param field
     * @return
     */
    private static char getFieldChar(Object obj, Field field) {
        try {
            char c = field.getChar(obj);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ' ';
    }

    /**
     * Field取byte<br>
     * @param obj
     * @param field
     * @return
     */
    private static byte getFieldByte(Object obj, Field field) {
        try {
            byte b = field.getByte(obj);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Field取Short<br>
     * @param obj
     * @param field
     * @return
     */
    private static short getFieldShort(Object obj, Field field) {
        try {
            short value = field.getShort(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Field取Float<br>
     * @param obj
     * @param field
     * @return
     */
    private static float getFieldFloat(Object obj, Field field) {
        try {
            float value = field.getFloat(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1.0f;
    }

    /**
     * Field取Double<br>
     * @param obj
     * @param field
     * @return
     */
    private static double getFieldDouble(Object obj, Field field) {
        try {
            double value = field.getDouble(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1.0d;
    }

    /**
     * Field取Boolean<br>
     * @param obj
     * @param field
     * @return
     */
    private static boolean getFieldBoolean(Object obj, Field field) {
        try {
            boolean f = field.getBoolean(obj);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        if (treeMap == null || treeMap.size() <= 0)
            return null;
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
                    XmlField annotation = field.getAnnotation(XmlField.class);
                    String aliasName = name;
                    if (annotation != null)
                        aliasName = annotation.name();
                    Object value = treeMap.get(aliasName);
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
                        if (value instanceof List) {
                            field.set(obj, (List) value);
                        } else {
                            List list = new ArrayList();
                            list.add(value);
                            field.set(obj, list);
                        }
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
                    } else {
                        if (value instanceof Map) {
                            Object valueObj = parse(type, (TreeMap) value);
                            if (valueObj != null)
                                field.set(obj, valueObj);
                        }
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
        if ( !node.isRootElement() && (node.elements()==null || node.elements().size()<=0)) {
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
                String subKey = e.getName();
                TreeMap<String, Object> subInfoMap = listNodes(e);
                if (subMap.get(subKey) != null) {
                    Object subRoot = subMap.get(subKey);
                    if (subRoot instanceof List) {
                        ((List)subRoot).add(subInfoMap);
                        subMap.put(subKey, subRoot);
                    } else {
                        List list = new ArrayList();

                        list.add(subRoot);
                        list.add(subInfoMap.get(subKey));
                        subMap.put(subKey, list);
                    }
                } else {
                    subMap.putAll(subInfoMap);
                }
            }
            Map oldMap = (Map)map.get(name);
            if (oldMap != null)
                subMap.putAll(oldMap);
            map.put(name, subMap);
        }
        return map;
    }
}
