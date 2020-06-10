package service;

import po.CustomPO.CommentExt;

import java.util.List;

/**
 *
 * @description: 回复 服务接口
 *
 */

public interface CommentService {
    List<CommentExt> findCommentByBookId(int bookId);
}
