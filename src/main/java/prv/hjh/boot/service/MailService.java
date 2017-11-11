package prv.hjh.boot.service;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/11.
 * SpringBoot 邮件开发接口
 */
public interface MailService {

    /**
     * 发送邮件
     * @param toEmail 收件人邮箱
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String toEmail,String subject,String content);

    /**
     * 发送HTML邮件
     * @param toEmail 收件人邮箱
     * @param subject 主题
     * @param content 内容
     */
    void sendHtmlMail(String toEmail,String subject,String content) throws MessagingException;

    /**
     * 发送添加附件邮件
     * @param toEmail 收件人邮箱
     * @param subject 主题
     * @param content 内容
     * @param filePath 文件路径
     */
    void sendAttachmentsMail(String toEmail,String subject,String content,String filePath);
}
