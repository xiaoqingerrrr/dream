package web.quartz;

/**
 * @Auther: song biao wei
 * @Date: 2018/9/21 14:45
 * @Description: 模拟两个定时任务
 */
public class JobTest {
    // 检查状态
    public void checkStatus() {
        System.out.println("定时任务执行 --- checkStatus ");
    }

    // 统计
    public void statis() {
        System.out.println("定时任务执行 --- statis ");
    }
}
