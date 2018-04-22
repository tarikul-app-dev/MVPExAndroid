package limited.it.planet.mvpexandroid.presenter;

import java.util.List;

import limited.it.planet.mvpexandroid.interfaces.FindItemInteractor;
import limited.it.planet.mvpexandroid.interfaces.MainPresenter;
import limited.it.planet.mvpexandroid.view.MainView;

/**
 * Created by Tarikul on 4/22/2018.
 */

public class MainPresenterIml implements MainPresenter,FindItemInteractor.OnFinishedListener  {
    private MainView mainView;
    private FindItemInteractor findItemsInteractor;

    public MainPresenterIml(MainView mainView,FindItemInteractor findItemInteractor){
        this.mainView = mainView;
        this.findItemsInteractor = findItemInteractor;
    }

    @Override
    public void onResume() {
        if(mainView!=null){
            mainView.showProgress();
        }
        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<String> items) {
        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}
