## 工作日计算器 WorkingDayUtil

| 用法                                                            | 作用                      |
|---------------------------------------------------------------|-------------------------|
| WorkingDayUtil.getEndDate(LocalDate startDate, long days);    | 根据开始日期、增加的工作日天数，计算结束日期  |
| WorkingDayUtil.getDays(LocalDate startDate,LocalDate endDate); | 根据开始日期、结束日期，计算工作日天数     |
| WorkingDayUtil.isWorkingDay(LocalDate date);                  | 判断指定日期是不是工作日            |
| WorkingDayUtil.isWorkingDay();                         | 判断今天是不是工作日              |