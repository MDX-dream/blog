package com.master.service;

import com.master.entity.Memory;

import java.util.List;

/**
 * <p>
 * 忆往昔业务层接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
public interface MemoryService {

    List<Memory> listMemory();

    int saveMemory(Memory memory);

    Memory getMemory(Long id);

    int updateMemory(Memory memory);

    void deleteMemory(Long id);
}
