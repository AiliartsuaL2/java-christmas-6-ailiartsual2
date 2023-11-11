package christmas.domain;

public enum VisitDate {
    DAY_1(1, false, true),
    DAY_2(2, false, true),
    DAY_3(3, true, false),
    DAY_4(4, false, false),
    DAY_5(5, false, false),
    DAY_6(6, false, false),
    DAY_7(7, false, false),
    DAY_8(8, false, true),
    DAY_9(9, false, true),
    DAY_10(10, true, false),
    DAY_11(11, false, false),
    DAY_12(12, false, false),
    DAY_13(13, false, false),
    DAY_14(14, false, false),
    DAY_15(15, false, true),
    DAY_16(16, false, true),
    DAY_17(17, true, false),
    DAY_18(18, false, false),
    DAY_19(19, false, false),
    DAY_20(20, false, false),
    DAY_21(21, false, false),
    DAY_22(22, false, true),
    DAY_23(23, false, true),
    DAY_24(24, true, false),
    DAY_25(25, true, false),
    DAY_26(26, false, false),
    DAY_27(27, false, false),
    DAY_28(28, false, false),
    DAY_29(29, false, true),
    DAY_30(30, false, true),
    DAY_31(31, true, false);
    private final int day;
    private final boolean isSpecialDay;
    private final boolean isWeekend;

    VisitDate(int day, boolean isSpecialDay, boolean isWeekend) {
        this.day = day;
        this.isSpecialDay = isSpecialDay;
        this.isWeekend = isWeekend;
    }
}
