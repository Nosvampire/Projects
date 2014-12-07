/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Niko
 */
public class DateTimeConverters {

    public static java.util.Date localDateToDate(LocalDate ld) {
        //  java.util.Date date = new Date();
        Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }

}
