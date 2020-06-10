package utils;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class UploadFileUtilsByUser {
    public static String updateLibrary(MultipartFile uploadFile, HttpServletRequest request, String FILE_SAVE_PATH) throws IOException {
        // 获取 文件名
        String realFileName = uploadFile.getOriginalFilename();
        // ext 为 文件扩展名
        String ext = realFileName.substring(realFileName.lastIndexOf(".") + 1);
        // 随机文件名
        String randomName = UUIDUtils.getUUID();
        // 拼接 文件名 与 扩展名
        String saveFileName = randomName + "." + ext;

        // 获取 文件流
        InputStream inputStream = uploadFile.getInputStream();
        // 创建 文件保存目录
        String basePath = request.getSession().getServletContext().getRealPath("/upload/user");
        File file = new File(basePath);

        if (!file.exists()) {   // 若存储文件目录不存在则 进行创建
            file.mkdirs();
        }
        // 写入磁盘
        FileUtils.copyInputStreamToFile(inputStream, new File(file + "/" + saveFileName));

        // 返回 文件的 存储路径
        return "/upload/user/" + saveFileName;
    }
}
