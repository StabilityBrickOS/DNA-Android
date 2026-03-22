package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.p1;

/* loaded from: classes.dex */
public interface MainDispatcherFactory {
    p1 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
