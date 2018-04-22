package limited.it.planet.mvpexandroid.interfaces;

import java.util.List;

public interface FindItemInteractor {
    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
} 