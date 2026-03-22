package c.f.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import c.f.d.c.c;
import c.f.i.b;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class i extends j {
    @Override // c.f.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        c.C0027c[] a = bVar.a();
        int length = a.length;
        FontFamily.Builder builder = null;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                break;
            }
            c.C0027c c0027c = a[i2];
            try {
                Font.Builder weight = new Font.Builder(resources, c0027c.b()).setWeight(c0027c.e());
                if (!c0027c.f()) {
                    i3 = 0;
                }
                Font build = weight.setSlant(i3).setTtcIndex(c0027c.c()).setFontVariationSettings(c0027c.d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i2++;
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // c.f.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        int i2;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        int length = fVarArr.length;
        FontFamily.Builder builder = null;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                if (builder == null) {
                    return null;
                }
                return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
            }
            b.f fVar = fVarArr[i2];
            try {
                openFileDescriptor = contentResolver.openFileDescriptor(fVar.c(), "r", cancellationSignal);
            } catch (IOException unused) {
                continue;
            }
            if (openFileDescriptor != null) {
                try {
                    Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(fVar.d());
                    if (!fVar.e()) {
                        i3 = 0;
                    }
                    Font build = weight.setSlant(i3).setTtcIndex(fVar.b()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                    if (openFileDescriptor == null) {
                    }
                } catch (Throwable th) {
                    if (openFileDescriptor != null) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                    break;
                }
            } else {
                i2 = openFileDescriptor == null ? i2 + 1 : 0;
            }
            openFileDescriptor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.f.e.j
    public Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // c.f.e.j
    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.f.e.j
    public b.f h(b.f[] fVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
