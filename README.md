## 添加依赖

Maven：

```xml

<dependency>
    <groupId>top.zhuangjinxin</groupId>
    <artifactId>xtools-all</artifactId>
    <version>1.0.0</version>
</dependency>
```

Gradle：

```groovy
implementation 'top.zhuangjinxin:xtools-all:1.0.0'
```

## 模块介绍

| 模块名 | 介绍 |
|-----------------|-----------------------------|
| xtools-all | 所有模块的工具集。包含以下所有模块。 |
| xtools-datetime | 日期时间工具集。包含：工作日计算器等。 |
| xtools-message | 消息工具集。包含企业微信消息、钉钉消息、飞书消息工具类。 |

## 工作日计算器 WorkingDayUtil

| 用法                                                             | 作用                      |
|----------------------------------------------------------------|-------------------------|
| WorkingDayUtil.getEndDate(LocalDate startDate, int days);      | 根据开始日期、工作日天数，计算结束日期  |
| WorkingDayUtil.getDays(LocalDate startDate,LocalDate endDate); | 根据开始日期、结束日期，计算工作日天数     |
| WorkingDayUtil.isWorkingDay(LocalDate date);                   | 判断指定日期是不是工作日            |
| WorkingDayUtil.isWorkingDay();                                 | 判断今天是不是工作日              |