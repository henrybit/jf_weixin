CREATE TABLE weixin_message (
  id NUMBER(22) NOT NULL primary key,
  ori_content clob NULL,
  msg_type VARCHAR2(45) NULL,
  to_user VARCHAR2(64) NULL,
  from_user VARCHAR2(64) NULL,
  create_time TIMESTAMP NULL,
  data_status NUMBER(3,0) DEFAULT 1
);


CREATE TABLE weixin_material (
  id NUMBER(22) NOT NULL primary key,
  media_id VARCHAR2(256) NULL unique,
  media_type VARCHAR2(18) NULL,
  media_attr NUMBER(3,0) NULL,
  media_content clob NULL,
  res_content clob NULL,
  status number(3,0) default 1,
  create_time TIMESTAMP NULL,
  data_status NUMBER(3,0) DEFAULT 1
);


CREATE TABLE weixin_message_reply (
  id NUMBER(22) NOT NULL primary key,
  wx_msg_id NUMBER(22) NOT NULL,
  reply_content clob NULL,
  res_content clob NULL,
  status number(3,0) default 1,
  create_time TIMESTAMP NULL,
  data_status NUMBER(3,0) DEFAULT 1
 );


CREATE TABLE weixin_message_auto_reply (
  id NUMBER(22) NOT NULL primary key,
  reply_content clob NULL,
  reply_type NUMBER(3,0) NULL,
  reply_rule VARCHAR2(1024) NULL,
  create_time TIMESTAMP NULL,
  update_time TIMESTAMP NULL,
  data_status NUMBER(3,0) DEFAULT 1
);


CREATE SEQUENCE wx_msg_sequence INCREMENT BY 1 START WITH 1 NOMAXVALUE NOCYCLE NOCACHE;
CREATE SEQUENCE wx_material_sequence INCREMENT BY 1 START WITH 1 NOMAXVALUE NOCYCLE NOCACHE;
CREATE SEQUENCE wx_msg_rly_sequence INCREMENT BY 1 START WITH 1 NOMAXVALUE NOCYCLE NOCACHE;
CREATE SEQUENCE wx_msg_auto_rly_sequence INCREMENT BY 1 START WITH 1 NOMAXVALUE NOCYCLE NOCACHE;


CREATE index wx_msg_fu_index on weixin_message (from_user);
CREATE index wx_msg_ct_index on weixin_message (create_time);

COMMENT ON TABLE weixin_message IS '微信公众号接收到的消息和事件表';
COMMENT ON TABLE weixin_material IS '微信公众号素材表';
COMMENT ON TABLE weixin_message_reply IS '微信公众号消息发送表';
COMMENT ON TABLE weixin_message_auto_reply IS '微信公众号自动处理消息和事件配置表';

COMMENT ON COLUMN weixin_message.ori_content IS '接收到的消息内容(XML格式)-base64编码，防止特殊字符'; 
COMMENT ON COLUMN weixin_message.msg_type IS '消息类型:clob-文本,image-图片,voice-语音,video-视频,shortvideo-短视频,location-定位,link-超链接,event-事件'; 
COMMENT ON COLUMN weixin_message.to_user IS '消息接收者'; 
COMMENT ON COLUMN weixin_message.from_user IS '消息发送者'; 
COMMENT ON COLUMN weixin_message.create_time IS '创建时间'; 
COMMENT ON COLUMN weixin_message.data_status IS '数据状态:1-有效,0-无效'; 


COMMENT ON COLUMN weixin_material.media_id IS '微信的素材ID'; 
COMMENT ON COLUMN weixin_material.media_type IS '素材类型：image-图片，voice-语音，video-视频，thumb-缩略图，news-图文'; 
COMMENT ON COLUMN weixin_material.media_attr IS '素材性质：1-永久素材,2-临时素材'; 
COMMENT ON COLUMN weixin_material.media_content IS '素材请求内容-base64编码防止特殊字符'; 
COMMENT ON COLUMN weixin_material.res_content IS '返回内容-base64编码防止特殊字符'; 
COMMENT ON COLUMN weixin_material.status IS '处理结果：1-成功,-1-失败'; 
COMMENT ON COLUMN weixin_material.create_time IS '创建时间'; 
COMMENT ON COLUMN weixin_material.data_status IS '数据状态:1-有效,0-无效'; 



COMMENT ON COLUMN weixin_message_reply.wx_msg_id IS '回复的消息ID'; 
COMMENT ON COLUMN weixin_message_reply.reply_content IS '回复的消息-base64编码，防止特殊字符'; 
COMMENT ON COLUMN weixin_message_reply.res_content IS '返回内容-base64编码防止特殊字符'; 
COMMENT ON COLUMN weixin_message_reply.status IS '处理结果：1-成功,-1-失败'; 
COMMENT ON COLUMN weixin_message_reply.create_time IS '创建时间'; 
COMMENT ON COLUMN weixin_message_reply.data_status IS '数据状态:1-有效,0-无效'; 


COMMENT ON COLUMN weixin_message_auto_reply.reply_content IS '自动回复内容-base64编码防止特殊字符'; 
COMMENT ON COLUMN weixin_message_auto_reply.reply_type IS '回复规则类型：1-事件回复;2-关键字回复'; 
COMMENT ON COLUMN weixin_message_auto_reply.reply_rule IS '回复规则：关键字列表(,分割)或事件规则内容'; 
COMMENT ON COLUMN weixin_message_auto_reply.create_time IS '创建时间'; 
COMMENT ON COLUMN weixin_message_auto_reply.update_time IS '更新时间'; 
COMMENT ON COLUMN weixin_message_auto_reply.data_status IS '数据状态:1-有效,0-无效'; 

