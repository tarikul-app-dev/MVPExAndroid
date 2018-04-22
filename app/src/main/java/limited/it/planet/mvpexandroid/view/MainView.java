package limited.it.planet.mvpexandroid.view;

import java.util.List;

public interface MainView {
    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
} 