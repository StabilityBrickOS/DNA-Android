package c.l;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import c.l.m;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class q extends m {
    int P;
    private ArrayList<m> N = new ArrayList<>();
    private boolean O = true;
    boolean Q = false;
    private int R = 0;

    /* loaded from: classes.dex */
    class a extends n {
        final /* synthetic */ m a;

        a(q qVar, m mVar) {
            this.a = mVar;
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            this.a.T();
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends n {
        q a;

        b(q qVar) {
            this.a = qVar;
        }

        @Override // c.l.n, c.l.m.f
        public void c(m mVar) {
            q qVar = this.a;
            if (qVar.Q) {
                return;
            }
            qVar.a0();
            this.a.Q = true;
        }

        @Override // c.l.m.f
        public void e(m mVar) {
            q qVar = this.a;
            int i = qVar.P - 1;
            qVar.P = i;
            if (i == 0) {
                qVar.Q = false;
                qVar.p();
            }
            mVar.P(this);
        }
    }

    private void f0(m mVar) {
        this.N.add(mVar);
        mVar.v = this;
    }

    private void o0() {
        b bVar = new b(this);
        Iterator<m> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.P = this.N.size();
    }

    @Override // c.l.m
    public void N(View view) {
        super.N(view);
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            this.N.get(i).N(view);
        }
    }

    @Override // c.l.m
    public void R(View view) {
        super.R(view);
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            this.N.get(i).R(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.l.m
    public void T() {
        if (this.N.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (this.O) {
            Iterator<m> it = this.N.iterator();
            while (it.hasNext()) {
                it.next().T();
            }
            return;
        }
        for (int i = 1; i < this.N.size(); i++) {
            this.N.get(i - 1).a(new a(this, this.N.get(i)));
        }
        m mVar = this.N.get(0);
        if (mVar != null) {
            mVar.T();
        }
    }

    @Override // c.l.m
    public /* bridge */ /* synthetic */ m U(long j) {
        k0(j);
        return this;
    }

    @Override // c.l.m
    public void V(m.e eVar) {
        super.V(eVar);
        this.R |= 8;
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            this.N.get(i).V(eVar);
        }
    }

    @Override // c.l.m
    public void X(g gVar) {
        super.X(gVar);
        this.R |= 4;
        if (this.N != null) {
            for (int i = 0; i < this.N.size(); i++) {
                this.N.get(i).X(gVar);
            }
        }
    }

    @Override // c.l.m
    public void Y(p pVar) {
        super.Y(pVar);
        this.R |= 2;
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            this.N.get(i).Y(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.l.m
    public String b0(String str) {
        String b0 = super.b0(str);
        for (int i = 0; i < this.N.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(b0);
            sb.append("\n");
            sb.append(this.N.get(i).b0(str + "  "));
            b0 = sb.toString();
        }
        return b0;
    }

    @Override // c.l.m
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public q a(m.f fVar) {
        super.a(fVar);
        return this;
    }

    @Override // c.l.m
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public q b(View view) {
        for (int i = 0; i < this.N.size(); i++) {
            this.N.get(i).b(view);
        }
        super.b(view);
        return this;
    }

    public q e0(m mVar) {
        f0(mVar);
        long j = this.g;
        if (j >= 0) {
            mVar.U(j);
        }
        if ((this.R & 1) != 0) {
            mVar.W(s());
        }
        if ((this.R & 2) != 0) {
            mVar.Y(w());
        }
        if ((this.R & 4) != 0) {
            mVar.X(v());
        }
        if ((this.R & 8) != 0) {
            mVar.V(r());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.l.m
    public void f() {
        super.f();
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            this.N.get(i).f();
        }
    }

    @Override // c.l.m
    public void g(s sVar) {
        if (G(sVar.f898b)) {
            Iterator<m> it = this.N.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.G(sVar.f898b)) {
                    next.g(sVar);
                    sVar.f899c.add(next);
                }
            }
        }
    }

    public m g0(int i) {
        if (i < 0 || i >= this.N.size()) {
            return null;
        }
        return this.N.get(i);
    }

    public int h0() {
        return this.N.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.l.m
    public void i(s sVar) {
        super.i(sVar);
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            this.N.get(i).i(sVar);
        }
    }

    @Override // c.l.m
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public q P(m.f fVar) {
        super.P(fVar);
        return this;
    }

    @Override // c.l.m
    public void j(s sVar) {
        if (G(sVar.f898b)) {
            Iterator<m> it = this.N.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.G(sVar.f898b)) {
                    next.j(sVar);
                    sVar.f899c.add(next);
                }
            }
        }
    }

    @Override // c.l.m
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public q Q(View view) {
        for (int i = 0; i < this.N.size(); i++) {
            this.N.get(i).Q(view);
        }
        super.Q(view);
        return this;
    }

    public q k0(long j) {
        ArrayList<m> arrayList;
        super.U(j);
        if (this.g >= 0 && (arrayList = this.N) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.N.get(i).U(j);
            }
        }
        return this;
    }

    @Override // c.l.m
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public q W(TimeInterpolator timeInterpolator) {
        this.R |= 1;
        ArrayList<m> arrayList = this.N;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.N.get(i).W(timeInterpolator);
            }
        }
        super.W(timeInterpolator);
        return this;
    }

    @Override // c.l.m
    /* renamed from: m */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.N = new ArrayList<>();
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            qVar.f0(this.N.get(i).clone());
        }
        return qVar;
    }

    public q m0(int i) {
        if (i == 0) {
            this.O = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.O = false;
        }
        return this;
    }

    @Override // c.l.m
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public q Z(long j) {
        super.Z(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.l.m
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long y = y();
        int size = this.N.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.N.get(i);
            if (y > 0 && (this.O || i == 0)) {
                long y2 = mVar.y();
                if (y2 > 0) {
                    mVar.Z(y2 + y);
                } else {
                    mVar.Z(y);
                }
            }
            mVar.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
