package d.c.b;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;

/* loaded from: classes.dex */
public class b {
    private Context a;

    public b(Context context) {
        this.a = context;
    }

    public String a() {
        int b2 = b();
        StringBuilder sb = new StringBuilder();
        sb.append("u");
        sb.append(b2);
        sb.append("_a");
        sb.append((Process.myUid() % 100000) - 10000);
        return sb.toString();
    }

    public int b() {
        try {
            return (int) ((UserManager) this.a.getSystemService("user")).getSerialNumberForUser(Process.myUserHandle());
        } catch (Exception unused) {
            return 0;
        }
    }
}
