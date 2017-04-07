package ru.avs.express.android.ui.screen.test;

import android.content.Context;
import android.content.Intent;

/**
* Маршрут экрана списка продуктов
*/
@Data
public class TestRoute extends DialogFragmentWithParamsAndResultRoute<Unit> {

    private String bookId;
    private Unit unit;    

    public TestRoute(String bookId, Unit unit) {
        this.bookId = bookId;
        this.unit = unit;        
    }

    public TestRoute(Bundle args) {
        bookId = args.getString(EXTRA_FIRST);
        unit = (Unit)args.getSerializable(EXTRA_SECOND);
        
    }

    @Override
    protected Bundle prepareBundle() {
        Bundle args = new Bundle();
        args.putString(EXTRA_FIRST, bookId);
        args.putUnit(EXTRA_SECOND, unit);        
        return args;
    }

    
}