package uz.java.spring_boot_application.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
@Component
@RequiredArgsConstructor
public class Translator {
    private final ResourceBundleMessageSource messageSource;

    public String toLocale(String msgCode) {
        Locale lang = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, null, lang);
    }
}
