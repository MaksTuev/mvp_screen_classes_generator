package ru.avs.express.android.ui.screen.test;

import android.content.Context;
import android.content.Intent;

/**
* Вью экрана списка продуктов
*/
@Data
public class TestDialogFragmentView extends LdsSwrPgnDialogFragmentView<TestScreenModel> {

    @Inject
    TestPresenter presenter;

    private PlaceHolderView placeHolderView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    
    private TestAdapter adapter;
    
    
    @Override
    public CorePresenter[] getPresenters() {
        return new CorePresenter[]{presenter};
    }

    @Override
    public ScreenConfigurator createScreenConfigurator(Context context, Bundle args) {
        return new TestScreenConfigurator(context, args);
    }

    @Override
    public void notifyListChanged(ListChanges listChanges) {
        adapter.notifyListChanged(listChanges);
    }

    @Override
    protected PlaceHolderView getPlaceHolderView() {
        return placeHolderView;
    }

    @Override
    protected SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }

    @Override
    protected PaginationableAdapter getPaginationableAdapter() {
        return adapter;
    }

    @Override
    protected void renderInternal(TestScreenModel screenModel) {
        adapter.setData(screenModel);
        //todo render model here
    }

    private void findViews() {
        placeHolderView = (PlaceHolderView)findViewById(R.id.placeholder);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        //todo find views here
    }

    private void initToolbar() {
        toolbar.setNavigationOnClickListener(view -> presenter.finish());
        //todo init toolbar here
    }

    private void initRecycler() {
        adapter = new TestAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemActionListener(null); //todo add listener
        adapter.setOnHeaderActionListener(null); //todo add listener
        adapter.setOnShowMoreListener(() -> presenter.loadMore());
        
    }

    
    private void initListeners() {
        //todo init listeners here
    }
}