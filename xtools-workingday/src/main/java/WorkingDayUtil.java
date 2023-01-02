import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 工作日计算工具类
 *
 * @author zhuangjinxin
 * @since 2023/1/1
 */
public class WorkingDayUtil {

    private WorkingDayUtil() {
    }

    /**
     * 根据 开始日期 + 工作日天数，返回 结束日期
     *
     * @param startDate 开始日期
     * @param days      工作日天数
     * @return 结束日期
     */
    public static LocalDate getEndDate(LocalDate startDate, long days) {
        return startDate.plusDays(days);
    }

    /**
     * 根据 开始日期 + 结束日期，返回 工作日天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 工作日天数
     */
    public static long getDays(LocalDate startDate, LocalDate endDate) {
        return Duration.between(startDate, endDate).get(ChronoUnit.DAYS);
    }
}