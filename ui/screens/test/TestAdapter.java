package ru.avs.express.android.ui.screen.test;

import android.content.Context;
import android.content.Intent;

/**
* Адаптер экрана списка продуктов
*/
@Data
public class TestAdapter extends PaginationableAdapter {

    private TestScreenModel screenModel;
    private OnUnitActionListener onUnitActionListener;

    private OnHeaderActionListener onHeaderActionListener;

    public interface OnUnitActionListener {
        void onItemClick(Unit unit);
    }

    public interface OnHeaderActionListener {
    }
    
    public void setOnUnitActionListener(OnUnitActionListener onUnitActionListener) {
        this.onUnitActionListener = onUnitActionListener;
    }

    public void setOnHeaderActionListener(OnHeaderActionListener onHeaderActionListener) {
        this.onHeaderActionListener = onHeaderActionListener;
    }

    public void setData(TestScreenModel screenModel) {
        this.screenModel = screenModel;
    }

    @Override
    protected Range getExtraItemsRange() {
        return new Range(0, getHeaderCount());
    }

    @Override
    protected RecyclerView.ViewHolder onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FIRST_HEADER_VIEW_TYPE) {
            return TestHeaderViewHolder.newInstance(parent, onHeaderActionListener);
        } else if (viewType == LIST_ITEM_VIEW_TYPE) {
            return UnitViewHolder.newInstance(parent, onUnitActionListener);
        } else {
            throw new IllegalStateException("unsupported ViewType: "+ viewType);
        }
    }
    
    @Override
    protected void onBindCustomViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isHeaderPosition(position)) {
            ((HeaderViewHolder) holder).bind(screenModel);
        } else {
            ((UnitViewHolder) holder).bind(screenModel.getUnits()().get(getDataPosition(position)));
        }
    }
    
    private boolean isHeaderPosition(int position) {
        return position == 0;
    }
     
    private int getDataPosition(int position) {
        return position - getHeaderCount();
    }

    private int getHeaderCount(){
        return 1;
    }

    @Override
    protected int getCustomItemCount() {
        return screenModel == null ? 0 : screenModel.getUnits().size() + getHeaderCount();
    }
    
    @Override
    protected int getCustomItemViewType(int position) {
        return isHeaderPosition(position) ? FIRST_HEADER_VIEW_TYPE : LIST_ITEM_VIEW_TYPE;
    }
    
    private static class UnitViewHolder extends BindableViewHolder<Unit> {

        private Unit unit;

        public static UnitViewHolder newInstance(ViewGroup parent, OnUnitActionListener itemActionListener) {
            //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_list_item_layout, parent, false);
            //return new UnitViewHolder(view, itemActionListener); todo create list item layout
            return null;
        }

        public UnitViewHolder(View itemView, OnUnitActionListener clickListener) {
            super(itemView);
            itemView.setOnClickListener(v -> clickListener.onItemClick(unit));
            //todo find views here
        }

        @Override
        public void bind(Unit unit) {
            this.unit = unit;
            //todo render units here
        }
    }
    
    private static class TestHeaderViewHolder extends BindableViewHolder<TestScreenModel> {

        TestScreenModel screenModel;

        public static TestHeaderViewHolder newInstance(ViewGroup parent, OnHeaderActionListener headerActionListener) {
            //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_header_layout, parent, false);
            //return new HeaderViewHolder(view, headerActionListener); todo create header layout
            return null;
        }

        public TestHeaderViewHolder(View itemView, OnHeaderActionListener headerActionListener) {
            super(itemView);
            //todo find views and init listeners here
        }

        @Override
        public void bind(TestScreenModel screenModel) {
            this.screenModel = screenModel;
            //todo render data here
        }
    }
}