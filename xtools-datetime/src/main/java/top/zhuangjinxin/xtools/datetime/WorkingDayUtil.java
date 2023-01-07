package top.zhuangjinxin.xtools.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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
     * 节假日、调休日 等特殊日期的 Map
     * Key： 日期 yyyy-MM-dd
     * Value 是否是工作日
     */
    private static final Map<String, Boolean> SPECIAL_DAYS = new HashMap<>();
    /**
     * 日期格式化 yyyy-MM-dd
     */
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static {
        initSpecialDays();
    }

    /**
     * 根据 开始日期 + 工作日天数，返回 结束日期
     *
     * @param startDate 开始日期
     * @param days      工作日天数
     * @return 结束日期
     */
    public static LocalDate getEndDate(LocalDate startDate, int days) {
        if (days < 0) {
            throw new IllegalArgumentException("输入的工作日天数不合法");
        }
        LocalDate currentDate = startDate;
        for (int i = days; i > 0; i--) {
            currentDate = currentDate.plusDays(1);
            if (!isWorkingDay(currentDate)) {
                i = i + 1;
            }
        }
        return currentDate;
    }

    /**
     * 根据 开始日期 + 结束日期，返回 工作日天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 工作日天数
     */
    public static int getDays(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("开始时间晚于结束时间，参数不合法。");
        }

        int days = 0;
        for (LocalDate currentDate = startDate; currentDate.isBefore(endDate) || currentDate.isEqual(endDate); currentDate = currentDate.plusDays(1)) {
            if (isWorkingDay(currentDate)) {
                days = days + 1;
            }
        }
        return days;
    }

    /**
     * 判断一个日期是否是工作日
     *
     * @param date 指定日期
     * @return 是不是工作日
     */
    public static boolean isWorkingDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dateString = date.atStartOfDay().format(FORMATTER);
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return SPECIAL_DAYS.getOrDefault(dateString, false);
        } else {
            return SPECIAL_DAYS.getOrDefault(dateString, true);
        }
    }

    /**
     * 判断今天是否是工作日
     *
     * @return 今天是不是工作日
     */
    public static boolean isWorkingDay() {
        return isWorkingDay(LocalDate.now());
    }

    /**
     * 初始化 节假日
     */
    private static void initSpecialDays() {
        // 2023年 节假日安排
        SPECIAL_DAYS.put("2022-12-31", false);
        SPECIAL_DAYS.put("2023-01-01", false);
        SPECIAL_DAYS.put("2023-01-02", false);
        SPECIAL_DAYS.put("2023-01-21", false);
        SPECIAL_DAYS.put("2023-01-22", false);
        SPECIAL_DAYS.put("2023-01-23", false);
        SPECIAL_DAYS.put("2023-01-24", false);
        SPECIAL_DAYS.put("2023-01-25", false);
        SPECIAL_DAYS.put("2023-01-26", false);
        SPECIAL_DAYS.put("2023-01-27", false);
        SPECIAL_DAYS.put("2023-01-28", true);
        SPECIAL_DAYS.put("2023-01-29", true);
        SPECIAL_DAYS.put("2023-04-05", false);
        SPECIAL_DAYS.put("2023-04-23", true);
        SPECIAL_DAYS.put("2023-04-29", false);
        SPECIAL_DAYS.put("2023-04-30", false);
        SPECIAL_DAYS.put("2023-05-01", false);
        SPECIAL_DAYS.put("2023-05-02", false);
        SPECIAL_DAYS.put("2023-05-03", false);
        SPECIAL_DAYS.put("2023-05-06", true);
        SPECIAL_DAYS.put("2023-06-22", false);
        SPECIAL_DAYS.put("2023-06-23", false);
        SPECIAL_DAYS.put("2023-06-24", false);
        SPECIAL_DAYS.put("2023-09-29", false);
        SPECIAL_DAYS.put("2023-09-30", false);
        SPECIAL_DAYS.put("2023-10-01", false);
        SPECIAL_DAYS.put("2023-10-02", false);
        SPECIAL_DAYS.put("2023-10-03", false);
        SPECIAL_DAYS.put("2023-10-04", false);
        SPECIAL_DAYS.put("2023-10-05", false);
        SPECIAL_DAYS.put("2023-10-06", false);
        SPECIAL_DAYS.put("2023-10-07", true);
        SPECIAL_DAYS.put("2023-10-08", true);
    }
}