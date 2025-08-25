package com.pony.backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pony.backend.model.dto.picture.PictureEditRequest;
import com.pony.backend.model.dto.picture.PictureQueryRequest;
import com.pony.backend.model.dto.picture.PictureUploadReuqest;
import com.pony.backend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pony.backend.model.entity.User;
import com.pony.backend.model.vo.picture.PictureVo;

/**
* @author mtx
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-08-25 14:57:34
*/
public interface PictureService extends IService<Picture> {

    /**
     * 校验图片
     * @param picture
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     * @param inputSource
     * @param pictureUploadReuqest
     * @param user
     * @return
     */
    PictureVo uploadPicture(Object inputSource, PictureUploadReuqest pictureUploadReuqest, User user);

    /**
     *  获取查询对象
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);


    /**
     * 删除图片
     * @param pictureId
     * @param user
     */
    void deletePicture(long pictureId, User user);

    /**
     * 修改图片信息
     * @param pictureEditRequest
     * @param user
     */
    void editPicture(PictureEditRequest pictureEditRequest, User user);
}
