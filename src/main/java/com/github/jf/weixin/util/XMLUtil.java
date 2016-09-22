package com.github.jf.weixin.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * XML操作解析工具
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class XMLUtil {
	
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
		//创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document  
        String xml = " <xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName> <CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";
        
        Document document = reader.read(xml);  
        //获取根节点元素对象  
        Element root = document.getRootElement();  
        //遍历  
        listNodes(root);
		
        Class cls = Text.class;
        Field[] fields = cls.getDeclaredFields();
        for (int i=0; i<fields.length; i++) {
        	Field field = fields[i];
        	String type = fields[i].getType().getName();
        	String name = fields[i].getName();
        	
        	System.out.println(type+":"+name);
        }
	}
	
	//遍历当前节点下的所有节点  
    public static void listNodes(Element node){  
        System.out.println("当前节点的名称：" + node.getName());  
        //首先获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        //遍历属性节点  
        for(Attribute attribute : list){  
            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());  
        }  
        //如果当前节点内容不为空，则输出  
        if(!(node.getTextTrim().equals(""))){  
             System.out.println( node.getName() + "：" + node.getText());    
        }  
        //同时迭代当前节点下面的所有子节点  
        //使用递归  
        Iterator<Element> iterator = node.elementIterator();  
        while(iterator.hasNext()){  
            Element e = iterator.next();  
            listNodes(e);  
        }  
    }
    
    public static class Text {
    	private String title;
    	private String name;
    }
}
