package org.stc.clinicservice.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodes {
    public static class Appointment {
        public static final Map<String, String> SAVE_FAILED = new HashMap<String, String>() {{
            put("en", "Failed To Add Appointment");
            put("ar", "خطـا أثنـاء اضافه موعد جديد");
        }};
        public static final Map<String, String> Appointment_Should_Belong_To_Patient = new HashMap<String, String>() {{
            put("en", "Appointment Should Belong To Patient");
            put("ar", "لابد من اختيار المريض اولا ");
        }};
        public static final Map<String, String> Not_Exsiting_Appointment = new HashMap<String, String>() {{
            put("en", "Appointment Not Exist");
            put("ar", "هذا الميعاد غير موجود ");
        }};
    }
}
