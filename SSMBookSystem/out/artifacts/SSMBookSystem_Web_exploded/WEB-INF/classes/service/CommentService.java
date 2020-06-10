package service;

import po.CustomPO.CommentExt;

import java.util.List;

/**
 * @description: 回复 服务接口
 * @date 2018/4/12 11:00
 */

public interface CommentService {
    List<CommentExt> findCommentByBookId(int bookId);
}
