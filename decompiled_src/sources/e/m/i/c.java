package e.m.i;

import e.g;
import e.j;
import e.m.h;
import e.m.j.a.i;
import e.p.c.l;
import e.p.c.p;
import e.p.d.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static final class a extends i {
        final /* synthetic */ e.m.d $completion;
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e.m.d dVar, e.m.d dVar2, l lVar) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // e.m.j.a.a
        protected Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                g.b(obj);
                return obj;
            }
            this.label = 1;
            g.b(obj);
            l lVar = this.$this_createCoroutineUnintercepted$inlined;
            if (lVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            r.a(lVar, 1);
            return lVar.invoke(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e.m.j.a.c {
        final /* synthetic */ e.m.d $completion;
        final /* synthetic */ e.m.g $context;
        final /* synthetic */ l $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e.m.d dVar, e.m.g gVar, e.m.d dVar2, e.m.g gVar2, l lVar) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = lVar;
        }

        @Override // e.m.j.a.a
        protected Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                g.b(obj);
                return obj;
            }
            this.label = 1;
            g.b(obj);
            l lVar = this.$this_createCoroutineUnintercepted$inlined;
            if (lVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            r.a(lVar, 1);
            return lVar.invoke(this);
        }
    }

    /* renamed from: e.m.i.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0120c extends i {
        final /* synthetic */ e.m.d $completion;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0120c(e.m.d dVar, e.m.d dVar2, p pVar, Object obj) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // e.m.j.a.a
        protected Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                g.b(obj);
                return obj;
            }
            this.label = 1;
            g.b(obj);
            p pVar = this.$this_createCoroutineUnintercepted$inlined;
            if (pVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            r.a(pVar, 2);
            return pVar.invoke(this.$receiver$inlined, this);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends e.m.j.a.c {
        final /* synthetic */ e.m.d $completion;
        final /* synthetic */ e.m.g $context;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e.m.d dVar, e.m.g gVar, e.m.d dVar2, e.m.g gVar2, p pVar, Object obj) {
            super(dVar2, gVar2);
            this.$completion = dVar;
            this.$context = gVar;
            this.$this_createCoroutineUnintercepted$inlined = pVar;
            this.$receiver$inlined = obj;
        }

        @Override // e.m.j.a.a
        protected Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                g.b(obj);
                return obj;
            }
            this.label = 1;
            g.b(obj);
            p pVar = this.$this_createCoroutineUnintercepted$inlined;
            if (pVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            r.a(pVar, 2);
            return pVar.invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> e.m.d<j> a(l<? super e.m.d<? super T>, ? extends Object> lVar, e.m.d<? super T> dVar) {
        e.p.d.i.d(lVar, "$this$createCoroutineUnintercepted");
        e.p.d.i.d(dVar, "completion");
        e.m.j.a.g.a(dVar);
        if (lVar instanceof e.m.j.a.a) {
            return ((e.m.j.a.a) lVar).create(dVar);
        }
        e.m.g context = dVar.getContext();
        if (context == h.INSTANCE) {
            if (dVar != null) {
                return new a(dVar, dVar, lVar);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVar != null) {
            return new b(dVar, context, dVar, context, lVar);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> e.m.d<j> b(p<? super R, ? super e.m.d<? super T>, ? extends Object> pVar, R r, e.m.d<? super T> dVar) {
        e.p.d.i.d(pVar, "$this$createCoroutineUnintercepted");
        e.p.d.i.d(dVar, "completion");
        e.m.j.a.g.a(dVar);
        if (pVar instanceof e.m.j.a.a) {
            return ((e.m.j.a.a) pVar).create(r, dVar);
        }
        e.m.g context = dVar.getContext();
        if (context == h.INSTANCE) {
            if (dVar != null) {
                return new C0120c(dVar, dVar, pVar, r);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        if (dVar != null) {
            return new d(dVar, context, dVar, context, pVar, r);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> e.m.d<T> c(e.m.d<? super T> dVar) {
        e.m.d<T> dVar2;
        e.p.d.i.d(dVar, "$this$intercepted");
        e.m.j.a.c cVar = !(dVar instanceof e.m.j.a.c) ? null : dVar;
        return (cVar == null || (dVar2 = (e.m.d<T>) cVar.intercepted()) == null) ? dVar : dVar2;
    }
}
