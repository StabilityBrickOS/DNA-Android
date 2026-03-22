package c.f.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f747b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f748c;
    private final int f;
    private final int g;
    private final String h;
    private final Object a = new Object();

    /* renamed from: e, reason: collision with root package name */
    private Handler.Callback f750e = new a();

    /* renamed from: d, reason: collision with root package name */
    private int f749d = 0;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c.this.a();
                return true;
            }
            if (i != 1) {
                return true;
            }
            c.this.b((Runnable) message.obj);
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Callable f751e;
        final /* synthetic */ Handler f;
        final /* synthetic */ d g;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Object f752e;

            a(Object obj) {
                this.f752e = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.g.a(this.f752e);
            }
        }

        b(c cVar, Callable callable, Handler handler, d dVar) {
            this.f751e = callable;
            this.f = handler;
            this.g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f751e.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f.post(new a(obj));
        }
    }

    /* renamed from: c.f.i.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0031c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicReference f753e;
        final /* synthetic */ Callable f;
        final /* synthetic */ ReentrantLock g;
        final /* synthetic */ AtomicBoolean h;
        final /* synthetic */ Condition i;

        RunnableC0031c(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f753e = atomicReference;
            this.f = callable;
            this.g = reentrantLock;
            this.h = atomicBoolean;
            this.i = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f753e.set(this.f.call());
            } catch (Exception unused) {
            }
            this.g.lock();
            try {
                this.h.set(false);
                this.i.signal();
            } finally {
                this.g.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void c(Runnable runnable) {
        synchronized (this.a) {
            if (this.f747b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.f747b = handlerThread;
                handlerThread.start();
                this.f748c = new Handler(this.f747b.getLooper(), this.f750e);
                this.f749d++;
            }
            this.f748c.removeMessages(0);
            this.f748c.sendMessage(this.f748c.obtainMessage(1, runnable));
        }
    }

    void a() {
        synchronized (this.a) {
            if (this.f748c.hasMessages(1)) {
                return;
            }
            this.f747b.quit();
            this.f747b = null;
            this.f748c = null;
        }
    }

    void b(Runnable runnable) {
        runnable.run();
        synchronized (this.a) {
            this.f748c.removeMessages(0);
            this.f748c.sendMessageDelayed(this.f748c.obtainMessage(0), this.f);
        }
    }

    public <T> void d(Callable<T> callable, d<T> dVar) {
        c(new b(this, callable, new Handler(), dVar));
    }

    public <T> T e(Callable<T> callable, int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        c(new RunnableC0031c(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
