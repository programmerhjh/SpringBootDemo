import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import prv.hjh.boot.Application;
import prv.hjh.boot.service.MailService;

import javax.mail.MessagingException;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/11.
 * 测试SpringBoot 集成对邮件的发送处理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootMailTests {

    /*
        发送失败
        因为各种原因，总会有邮件发送失败的情况，比如：邮件发送过于频繁、网络异常等。
        在出现这种情况的时候，我们一般会考虑重新重试发送邮件，会分为以下几个步骤来实现：
            1、接收到发送邮件请求，首先记录请求并且入库。
            2、调用邮件发送接口发送邮件，并且将发送结果记录入库。
            3、启动定时系统扫描时间段内，未发送成功并且重试次数小于3次的邮件，进行再次发送
        异步发送
        很多时候邮件发送并不是我们主业务必须关注的结果，比如通知类、提醒类的业务可以允许延时或者失败。
        这个时候可以采用异步的方式来发送邮件，加快主交易执行速度，
        在实际项目中可以采用MQ发送邮件相关参数，监听到消息队列之后启动发送邮件。
    */
    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

   /**
     * 简单的发送纯文本的邮件功能
     */
    @Test
    public void testSendEmail(){
        mailService.sendSimpleMail("605594106@qq.com","SpringBoot邮件测试","洪家豪测试");
    }

    /**
     * 发送 HTML 文本的邮件
     * @throws MessagingException
     */
    @Test
    public void sendHtmlEmail() throws MessagingException {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("605594106@qq.com","SpringBoot HTML邮件测试",content);
    }

    /**
     * 测试发送带附件的邮件
     */
    @Test
    public void sendFileEmail(){
        String content = "<html>\n" +
                "<body>\n" +
                    "<h3>hello world ! 这是一封带附件的邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        String filePath = "F:\\相片\\weather\\1辰时.jpg";
        mailService.sendAttachmentsMail("605594106@qq.com","SpringBoot 带附件邮件测试",content, filePath);
    }

    /**
     * 测试发送模板邮件
     * @throws MessagingException
     */
    @Test
    public void sendTemplateMail() throws MessagingException {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "1");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("605594106@qq.com","主题：这是模板邮件",emailContent);
    }

}
