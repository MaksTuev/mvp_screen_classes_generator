package ru.avs.express.android.ui.screen.test;

import android.content.Context;
import android.content.Intent;

/**
* Презентер экрана списка продуктов
*/
@Data
public class TestPresenter extends BasePresenter<TestDialogFragmentView> {

    private TestScreenModel screenModel;

    public TestPresenter(TestRoute route, BasePresenterDependency basePresenterDependency) {
        super(basePresenterDependency);
        screenModel = new TestScreenModel(); //todo init screen model here
    }

    @Override
    public void onLoad(boolean viewRecreated) {
        super.onLoad(viewRecreated);
        tryLoadData(viewRecreated);
    }

    private void tryLoadData(boolean viewRecreated) {
        if (viewRecreated) {
            getView().render(screenModel);
        } else {
            screenModel.setLoadState(LoadState.MAIN_LOADING);
            getView().render(screenModel);
            loadData(0);
        }
    }

    private void loadData(int page) {
        //example
        /*subscribeIoHandleError(Observable.<DataList<Unit>>empty(), //todo make real query
                dataList -> { //todo rename result
                    DataListMergeChanges mergeChanges = screenModel.getUnits().merge(dataList);
                    screenModel.setLoadState(screenModel.getUnits().isEmpty()
                            ? LoadState.EMPTY
                            : LoadState.NONE);
                    screenModel.setNormalPaginationState(screenModel.getUnits().canGetMore());
                    getView().render(screenModel);
                    getView().notifyListChanged(ListChanges.newInstance(mergeChanges));
                },
                e -> {
                    screenModel.setLoadState(screenModel.getUnits().isEmpty()
                            ? LoadState.ERROR
                            : LoadState.NONE);
                    screenModel.setErrorPaginationState();
                    getView().render(screenModel);
                });*/
    }

    public void loadMore() {
        loadData(screenModel.getUnits().getNextPage());
    }
    
}