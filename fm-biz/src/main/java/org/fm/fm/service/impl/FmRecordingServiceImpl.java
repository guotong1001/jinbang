package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmRecordingBO;
import org.fm.fm.dao.FmRecordingDao;
import org.fm.fm.service.FmRecordingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 录音表(FmRecording)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 14:56:12
 */
@Service("fmRecordingService")
@Transactional
public class FmRecordingServiceImpl extends ServiceImpl<FmRecordingDao, FmRecordingBO> implements FmRecordingService {

    /**
     * 数据访问对象
     */
    @Resource
    private FmRecordingDao fmRecordingDao;

    @Override
    public PageResult<FmRecordingBO> findPageForMap(IPage<FmRecordingBO> page, Map<String, Object> filter) {
        IPage<FmRecordingBO> iPage = fmRecordingDao.findPageForMap(page, filter);
        return PageResult.<FmRecordingBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<FmRecordingBO> findListForMap(Map<String, Object> filter) {
        List<FmRecordingBO> result = fmRecordingDao.findListForMap(filter);
        return result;
    }
}