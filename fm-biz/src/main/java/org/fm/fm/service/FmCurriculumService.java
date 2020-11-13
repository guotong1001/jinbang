package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmCurriculumBO;

import java.util.List;
import java.util.Map;

/**
 * 课程分类表(FmCurriculum)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:55
 */
public interface FmCurriculumService extends IService<FmCurriculumBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<FmCurriculumBO> findPageForMap(IPage<FmCurriculumBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<FmCurriculumBO> findListForMap(Map<String, Object> filter);

}