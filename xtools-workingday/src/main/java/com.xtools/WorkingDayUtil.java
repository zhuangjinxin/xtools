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
     * 节假日 Map
     * Key： 日期
     * Value 是否是节假日
     */
    private static Map<String, Boolean> holidays = new HashMap<>;
    /**
     * 调休日 Map
     * Key： 日期
     * Value 是否是调休日
     */
    private static Map<String, Boolean> workingDays = new HashMap<>;

    static {
        Properties p = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("db.properties");
        p.load(is);
        System.out.println(p);
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

    /**
     * 判断一个日期是否是工作日
     *
     * @param date 指定日期
     * @return 是不是工作日
     */
    public static boolean isWorkingDay(LocalDate date) {
        return true;
    }

    /**
     * 判断今天是否是工作日
     *
     * @return 今天是不是工作日
     */
    public static boolean isWorkingDay() {
        return true;
    }
}