package com.omarea.krscript.model;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class ShellHandlerBase extends Handler {
    public static final int EVENT_EXIT = -2;
    public static final int EVENT_READ_ERROR = 4;
    public static final int EVENT_REDE = 2;
    public static final int EVENT_START = 0;
    public static final int EVENT_WRITE = 6;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == -2) {
            onExit(message.obj);
            return;
        }
        if (i == 0) {
            onStart(message.obj);
            return;
        }
        if (i == 2) {
            onReaderMsg(message.obj);
        } else if (i == 4) {
            onError(message.obj);
        } else {
            if (i != 6) {
                return;
            }
            onWrite(message.obj);
        }
    }

    protected void onError(Object obj) {
        updateLog(obj, "#ff0000");
    }

    protected abstract void onExit(Object obj);

    protected abstract void onProgress(int i, int i2);

    protected void onReader(Object obj) {
        updateLog(obj, "#00cc55");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReaderMsg(Object obj) {
        if (obj != null) {
            String trim = obj.toString().trim();
            if (!Pattern.matches("^progress:\\[[\\-0-9\\\\]{1,}/[0-9\\\\]{1,}]$", trim)) {
                onReader(obj);
            } else {
                String[] split = trim.substring(10, trim.indexOf("]")).split("/");
                onProgress(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            }
        }
    }

    protected abstract void onStart(Object obj);

    public abstract void onStart(Runnable runnable);

    protected void onWrite(Object obj) {
        updateLog(obj, "#808080");
    }

    protected abstract void updateLog(SpannableString spannableString);

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLog(Object obj, int i) {
        if (obj != null) {
            String obj2 = obj.toString();
            SpannableString spannableString = new SpannableString(obj2);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, obj2.length(), 33);
            updateLog(spannableString);
        }
    }

    protected void updateLog(Object obj, String str) {
        if (obj != null) {
            String obj2 = obj.toString();
            SpannableString spannableString = new SpannableString(obj2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str)), 0, obj2.length(), 33);
            updateLog(spannableString);
        }
    }
}
