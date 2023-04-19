package com.master.dao;

import com.master.entity.Memory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 记忆 Mapper 接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Mapper
@Repository
public interface MemoryDao {
    // 查询忆往昔
    List<Memory> listMemory();

    int saveMemory(Memory memory);

    Memory getMemory(Long id);

    int updateMemory(Memory memory);

    void deleteMemory(Long id);
}
