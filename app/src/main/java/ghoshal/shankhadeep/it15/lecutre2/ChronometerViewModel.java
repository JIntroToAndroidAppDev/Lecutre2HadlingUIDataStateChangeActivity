package ghoshal.shankhadeep.it15.lecutre2;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

public class ChronometerViewModel extends ViewModel {

    @Nullable
    private long currentTime;

    @Nullable
    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(final long currentTime) {
        this.currentTime = currentTime;
    }
}
