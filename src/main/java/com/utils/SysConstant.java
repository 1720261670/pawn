package com.utils;

public class SysConstant {
    public static final String CAPTCHA_KEY="code";
    public static final String JOB_KEY_PREFIX="MyJob_";
    public static final String TRIGGER_KEY_PREFIX="MyTrigger_";
    public static final String GROUP_KEY_PREFIX="MyGroup_";
    public static final String SCHEDULE_DATA_KEY="schedule_data_key";
    public enum ScheduleStatus {
        NOMAL((byte)0),
        PAUSE((byte)1);
        private byte value;
        ScheduleStatus(byte value){
            this.value=value;
        }

        public byte getValue() {
            return value;
        }
    }
}
