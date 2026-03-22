package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class h implements Iterable<Intent> {

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<Intent> f332e = new ArrayList<>();
    private final Context f;

    /* loaded from: classes.dex */
    public interface a {
        Intent f();
    }

    private h(Context context) {
        this.f = context;
    }

    public static h d(Context context) {
        return new h(context);
    }

    public h a(Intent intent) {
        this.f332e.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h b(Activity activity) {
        Intent f = activity instanceof a ? ((a) activity).f() : null;
        if (f == null) {
            f = f.a(activity);
        }
        if (f != null) {
            ComponentName component = f.getComponent();
            if (component == null) {
                component = f.resolveActivity(this.f.getPackageManager());
            }
            c(component);
            a(f);
        }
        return this;
    }

    public h c(ComponentName componentName) {
        int size = this.f332e.size();
        try {
            Context context = this.f;
            while (true) {
                Intent b2 = f.b(context, componentName);
                if (b2 == null) {
                    return this;
                }
                this.f332e.add(size, b2);
                context = this.f;
                componentName = b2.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f332e.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f332e;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (c.f.d.a.d(this.f, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f332e.iterator();
    }
}
