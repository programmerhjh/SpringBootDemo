package prv.hjh.boot.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/11.
 * 定时任务1
 */
@Component
public class Scheduler1Task {

    private int count=0;

    /*
        一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。
        按顺序依次为
        秒（0~59）
        分钟（0~59）
        小时（0~23）
        天（月）（0~31，但是你需要考虑你月的天数）
        月（0~11）
        天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT(SAT为一个星期的最后一天)）
        年份（1970－2099）
        有些子表达式能包含一些范围或列表
        例如：子表达式（天（星期））可以为 “MON-FRI”，“MON，WED，FRI”，“MON-WED,SAT”
        “*”字符代表所有可能的值
        因此，“*”在子表达式（月）里表示每个月的含义，“*”在子表达式（天（星期））表示星期的每一天
        “/”字符用来指定数值的增量
        例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟
        在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样
        “？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值
        当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
        “L” 字符仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写
        但是它在两个子表达式里的含义是不同的。
        在天（月）子表达式中，“L”表示一个月的最后一天
        在天（星期）自表达式中，“L”表示一个星期的最后一天，也就是SAT
        如果在“L”前有具体的内容，它就具有其他的含义了
        例如：“6L”表示这个月的倒数第６天，“FRIL”表示这个月的最一个星期五
        注意：在使用“L”参数时，不要指定列表或范围，因为这会导致问题
    */
    // @Scheduled 参数可以接受两种定时的设置，一种是我们常用的cron="*/6 * * * * ?"
    // 一种是 fixedRate = 6000，两种都表示每隔六秒打印一下内容。
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running  "+(count++));
    }
}
