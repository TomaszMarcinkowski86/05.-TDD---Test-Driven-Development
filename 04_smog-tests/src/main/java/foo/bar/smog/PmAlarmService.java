package foo.bar.smog;

public class PmAlarmService {

    public PmAlarmService() { }

    public AlarmLevel getAlarmMessage(int measurement, Country country) {
        switch (country) {
            case ITALY:
                if (measurement > 0 && measurement < 50 ) {
                    return AlarmLevel.NONE;
                } else if(measurement >= 50 && measurement < 75) {
                    return AlarmLevel.INFO;
                } else {
                    return AlarmLevel.WARNING;
                }
            case FINLAND:
                if (measurement > 0 && measurement < 50 ) {
                    return AlarmLevel.NONE;
                } else if(measurement < 80) {
                    return AlarmLevel.INFO;
                } else {
                    return AlarmLevel.WARNING;
                }
            case FRANCE:
                if (measurement > 0 && measurement < 80 ) {
                    return AlarmLevel.NONE;
                } else if(measurement == 80) {
                    return AlarmLevel.INFO;
                } else {
                    return AlarmLevel.WARNING;
                }
            case POLAND:
                if (measurement > 0 && measurement < 200 ) {
                    return AlarmLevel.NONE;
                } else if(measurement < 300) {
                    return AlarmLevel.INFO;
                } else {
                    return AlarmLevel.WARNING;
                }
        }
        return AlarmLevel.NONE;
    }

}
