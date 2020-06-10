package service.impl;

import mapper.TbCommentMapper;
import mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.CustomPO.CommentExt;
import po.TbComment;
import po.TbCommentExample;
import po.TbUser;
import service.CommentService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @description: 回复信息 服务接口实现
 *
 */
@Service
public class CommentServiceImpl implements CommentService {
    // 注入
    @Autowired
    private TbCommentMapper commentMapper;
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public List<CommentExt> findCommentByBookId(int bookId) {
        // 创建 条件查询对象
        TbCommentExample commentExample = new TbCommentExample();
        // 设置 查询条件
        commentExample.createCriteria().andBookIdEqualTo(bookId);

        // 获取 查询的图书信息
        List<TbComment> comments = commentMapper.selectByExampleWithBLOBs(commentExample);

        // 创建 扩展图书集合
        List<CommentExt> commentExts = new ArrayList<>();

        // 遍历图书 列表
        for (TbComment comment : comments) {
            // 创建 Comment 对象
            CommentExt commentExt = new CommentExt();

            // 设置图书信息
            commentExt.setComment(comment);

            // 通过 comment 中的 userId 来获取 用户信息
            TbUser user = userMapper.selectByPrimaryKey(comment.getUserId());

            // 将 时间戳 转换为  页面显示字符串
            Long commentDate = comment.getCommentdate();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formatDate = simpleDateFormat.format(new Date(commentDate * 1000));

            commentExt.setFormatDate(formatDate);
            commentExt.setUser(user);

            // 添加到 扩展类集合中
            commentExts.add(commentExt);
        }
        return commentExts;
    }
}
