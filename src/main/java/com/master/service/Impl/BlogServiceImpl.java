package com.master.service.Impl;

import com.master.NotFoundException;
import com.master.dao.BlogDao;
import com.master.entity.Blog;
import com.master.queryvo.*;
import com.master.service.BlogService;
import com.master.util.MarkDownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 博客列表业务层接口实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Service
public class BlogServiceImpl implements BlogService {


    @Autowired
    private BlogDao blogDao;


    //保存新增博客
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    //查询文章管理列表
    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAllBlogQuery();
    }

    //删除博客
    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }

    //查询编辑修改的文章
    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    //编辑修改文章
    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }

    //搜索博客管理列表
    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogDao.searchByTitleAndType(searchBlog);
    }


    //查询首页最新博客列表信息
    @Override
    // @Cacheable(value = "blogList",key = "'blog'")       // redis缓存
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getFirstPageBlog();
    }

    //查询首页最新推荐信息
    @Override
    // @Cacheable(value = "commentblogList",key = "'commentblog'")       // redis缓存
    public List<RecommendBlog> getRecommendedBlog() {
//        List<RecommendBlog> allRecommendBlog = blogDao.getAllRecommendBlog();
//        return allRecommendBlog;
        return blogDao.getAllRecommendBlog();
    }

    //搜索博客列表
    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    //统计博客总数
    @Override
    public Integer getBlogTotal() {
        return blogDao.getBlogTotal();
    }

    //统计访问总数
    @Override
    public Integer getBlogViewTotal() {
        return blogDao.getBlogViewTotal();
    }

    //统计评论总数
    @Override
    public Integer getBlogCommentTotal() {
        return blogDao.getBlogCommentTotal();
    }

    //统计留言总数
    @Override
    public Integer getBlogMessageTotal() {
        return blogDao.getBlogMessageTotal();
    }

    //查询博客详情
    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogDao.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkDownUtils.markdownToHtmlExtensions(content));
        //文章访问数量自增
        blogDao.updateViews(id);
        //文章评论数量更新
        blogDao.getCommentCountById(id);
        return detailedBlog;
    }

    //分类页面查询
    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    //查询最新评论
    @Override
    // @Cacheable(value = "NewCommentList",key = "'NewComment'")      // redis缓存
    public List<NewComment> getNewComment() {
        return blogDao.getNewComment();
    }
}
