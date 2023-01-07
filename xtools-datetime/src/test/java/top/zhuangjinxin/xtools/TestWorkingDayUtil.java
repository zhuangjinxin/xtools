package top.zhuangjinxin.xtools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestWorkingDayUtil {

    @Test
    public void test() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = WorkingDayUtil.getEndDate(startDate, 7);
        LocalDate exceptEndDate = LocalDate.of(2023, 1, 8);
        Assertions.assertEquals(endDate, exceptEndDate);
    }
}
