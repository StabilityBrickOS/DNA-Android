package com.omarea.krscript.model;

import android.text.InputFilter;
import android.text.Spanned;
import e.p.d.i;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class ParamInfoFilter implements InputFilter {
    private final ActionParamInfo paramInfo;

    public ParamInfoFilter(ActionParamInfo actionParamInfo) {
        i.d(actionParamInfo, "paramInfo");
        this.paramInfo = actionParamInfo;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        i.d(spanned, "dest");
        if (this.paramInfo.getMaxLength() >= 0 && this.paramInfo.getMaxLength() - (spanned.length() - (i4 - i3)) <= 0) {
            return "";
        }
        if (this.paramInfo.getType() == null || !(!i.a(this.paramInfo.getType(), "")) || charSequence == null) {
            return null;
        }
        if (i.a(this.paramInfo.getType(), "int")) {
            if (Pattern.compile("^[0-9]{0,}$").matcher(charSequence.toString()).matches()) {
                return null;
            }
            return "";
        }
        if (!i.a(this.paramInfo.getType(), "number") || Pattern.compile("^[\\-.,0-9]{0,}$").matcher(charSequence.toString()).matches()) {
            return null;
        }
        return "";
    }
}
