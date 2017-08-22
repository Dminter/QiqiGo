package com.zncm.dminter.java;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MyDate {
    public abstract String formatDate(Date date);
    public @NotNull String formatTime( @NotNull Date date){
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }
}
