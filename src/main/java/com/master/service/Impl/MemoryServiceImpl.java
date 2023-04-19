package com.master.service.Impl;

import com.master.dao.MemoryDao;
import com.master.entity.Memory;
import com.master.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 忆往昔业务层接口实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Service
public class MemoryServiceImpl implements MemoryService {


    @Autowired
    private MemoryDao memoryDao;

    @Override
    @Cacheable(value = "memoryList", key = "'memory'")       // redis缓存
    public List<Memory> listMemory() {
        return memoryDao.listMemory();
    }

    @Override
    public int saveMemory(Memory memory) {
        return memoryDao.saveMemory(memory);
    }

    @Override
    public Memory getMemory(Long id) {
        return memoryDao.getMemory(id);
    }

    @Override
    public int updateMemory(Memory memory) {
        return memoryDao.updateMemory(memory);
    }

    @Override
    public void deleteMemory(Long id) {
        memoryDao.deleteMemory(id);
    }
}
