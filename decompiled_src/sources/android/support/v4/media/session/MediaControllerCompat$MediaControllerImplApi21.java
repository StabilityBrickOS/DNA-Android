package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21 {
    final Object a;

    /* renamed from: b, reason: collision with root package name */
    private final List<c> f16b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<c, a> f17c;

    /* renamed from: d, reason: collision with root package name */
    final MediaSessionCompat.Token f18d;

    /* loaded from: classes.dex */
    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f19e;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f19e.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.a) {
                mediaControllerCompat$MediaControllerImplApi21.f18d.g(b.a.p(androidx.core.app.d.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.f18d.h(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                mediaControllerCompat$MediaControllerImplApi21.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends c.BinderC0002c {
        a(c cVar) {
            super(cVar);
        }

        @Override // android.support.v4.media.session.c.BinderC0002c, android.support.v4.media.session.a
        public void a(List<MediaSessionCompat.QueueItem> list) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0002c, android.support.v4.media.session.a
        public void b(CharSequence charSequence) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0002c, android.support.v4.media.session.a
        public void c() {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0002c, android.support.v4.media.session.a
        public void d(Bundle bundle) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0002c, android.support.v4.media.session.a
        public void g(MediaMetadataCompat mediaMetadataCompat) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0002c, android.support.v4.media.session.a
        public void o(ParcelableVolumeInfo parcelableVolumeInfo) {
            throw new AssertionError();
        }
    }

    void a() {
        if (this.f18d.f() == null) {
            return;
        }
        for (c cVar : this.f16b) {
            a aVar = new a(cVar);
            this.f17c.put(cVar, aVar);
            cVar.f26b = aVar;
            try {
                this.f18d.f().f(aVar);
                cVar.i(13, null, null);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
            }
        }
        this.f16b.clear();
    }
}
