package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.e;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements IBinder.DeathRecipient {
    a a;

    /* renamed from: b, reason: collision with root package name */
    android.support.v4.media.session.a f26b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {
    }

    /* loaded from: classes.dex */
    private static class b implements e.a {
        private final WeakReference<c> a;

        b(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        @Override // android.support.v4.media.session.e.a
        public void a(List<?> list) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.e(MediaSessionCompat.QueueItem.g(list));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void b(CharSequence charSequence) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.f(charSequence);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void c() {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.g();
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void d(Bundle bundle) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.b(bundle);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void e(Object obj) {
            c cVar = this.a.get();
            if (cVar == null || cVar.f26b != null) {
                return;
            }
            cVar.d(PlaybackStateCompat.f(obj));
        }

        @Override // android.support.v4.media.session.e.a
        public void f(Object obj) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.c(MediaMetadataCompat.f(obj));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void g(int i, int i2, int i3, int i4, int i5) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.a(new d(i, i2, i3, i4, i5));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void h(String str, Bundle bundle) {
            c cVar = this.a.get();
            if (cVar != null) {
                if (cVar.f26b == null || Build.VERSION.SDK_INT >= 23) {
                    cVar.h(str, bundle);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.support.v4.media.session.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class BinderC0002c extends a.AbstractBinderC0000a {
        private final WeakReference<c> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BinderC0002c(c cVar) {
            this.a = new WeakReference<>(cVar);
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(5, list, null);
            }
        }

        public void b(CharSequence charSequence) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(6, charSequence, null);
            }
        }

        public void c() {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(8, null, null);
            }
        }

        public void d(Bundle bundle) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(7, bundle, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void e(boolean z) {
        }

        public void g(MediaMetadataCompat mediaMetadataCompat) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(3, mediaMetadataCompat, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void h(int i) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(9, Integer.valueOf(i), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void i(boolean z) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(11, Boolean.valueOf(z), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void j(int i) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(12, Integer.valueOf(i), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void k() {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(13, null, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void l(PlaybackStateCompat playbackStateCompat) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(2, playbackStateCompat, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void m(String str, Bundle bundle) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(1, str, bundle);
            }
        }

        public void o(ParcelableVolumeInfo parcelableVolumeInfo) {
            c cVar = this.a.get();
            if (cVar != null) {
                cVar.i(4, parcelableVolumeInfo != null ? new d(parcelableVolumeInfo.f23e, parcelableVolumeInfo.f, parcelableVolumeInfo.g, parcelableVolumeInfo.h, parcelableVolumeInfo.i) : null, null);
            }
        }
    }

    public c() {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(new b(this));
        } else {
            this.f26b = new BinderC0002c(this);
        }
    }

    public void a(d dVar) {
    }

    public void b(Bundle bundle) {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        i(8, null, null);
    }

    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void d(PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<MediaSessionCompat.QueueItem> list) {
    }

    public void f(CharSequence charSequence) {
    }

    public void g() {
    }

    public void h(String str, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i, Object obj, Bundle bundle) {
        a aVar = this.a;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(i, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }
}
