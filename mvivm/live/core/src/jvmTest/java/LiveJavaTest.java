import org.junit.jupiter.api.Test;

import live.MutableLive;
import live.Watcher;
import live.LiveBuildersKt.*;

public class LiveJavaTest {

    private void print(final int watcherNo, final int value) {
        System.out.println("Watcher " + watcherNo + ": " + value);
    }

    @Test
    public void should_have_a_valid_syntax() {
        MutableLive<Integer> liveInt = MutableLive.of(1);
        Watcher<?> watcher1 = liveInt.watch(x -> print(1, x));
        liveInt.setValue(2);
        liveInt.setValue(3);

        Watcher<?> watcher2 = liveInt.watch(x -> {
            print(2, x);
        });
        
        liveInt.setValue(4);
        liveInt.setValue(5);
//        liveInt.stop(watcher1)
        watcher1.stop();
        liveInt.setValue(6);
        liveInt.setValue(7);
//        liveInt.stop(watcher2)
        watcher2.stop();
        liveInt.setValue(8);
        watcher2.stop();
        liveInt.setValue(9);
        liveInt.setValue(10);
    }
}
