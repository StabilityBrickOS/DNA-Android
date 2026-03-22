package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.a = (IconCompat) aVar.v(remoteActionCompat.a, 1);
        remoteActionCompat.f313b = aVar.l(remoteActionCompat.f313b, 2);
        remoteActionCompat.f314c = aVar.l(remoteActionCompat.f314c, 3);
        remoteActionCompat.f315d = (PendingIntent) aVar.r(remoteActionCompat.f315d, 4);
        remoteActionCompat.f316e = aVar.h(remoteActionCompat.f316e, 5);
        remoteActionCompat.f = aVar.h(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.a, 1);
        aVar.D(remoteActionCompat.f313b, 2);
        aVar.D(remoteActionCompat.f314c, 3);
        aVar.H(remoteActionCompat.f315d, 4);
        aVar.z(remoteActionCompat.f316e, 5);
        aVar.z(remoteActionCompat.f, 6);
    }
}
