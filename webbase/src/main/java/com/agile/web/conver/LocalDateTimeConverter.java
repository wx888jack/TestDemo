/**
 * @Project Name :  mainserver
 * @Package Name :  com.agile.web.conver
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 11:40 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.web.conver;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author :  panduanduan
 * @Description :  request 时间类型转化
 * @Creation Date:  2018-01-26 11:40 AM
 */
public final class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    private final DateTimeFormatter formatter;

    public LocalDateTimeConverter(String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalDateTime convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        return LocalDateTime.parse(source, formatter);
    }
}