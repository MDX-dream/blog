package com.master.service;

import com.master.entity.Message;

import java.util.List;

/**
 * <p>
 * 留言业务层接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
public interface MessageService {

    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message, Message parentMessage);

    //删除留言
    void deleteMessage(Long id);


    Message getEmailByParentId(Long parentId);
}
