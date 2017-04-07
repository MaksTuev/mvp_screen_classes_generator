package ru.avs.express.android.ui.screen.test;

import android.content.Context;
import android.content.Intent;

/**
* Основная модель экрана списка продуктов
*/
@Data
public class TestScreenModel extends LdsSwrPgnScreenModel {

    private DataList<Unit> units = DataList.empty();
}