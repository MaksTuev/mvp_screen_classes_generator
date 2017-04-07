package ru.avs.express.android.ui.screen.test;


import android.content.Context;
import android.os.Bundle;
import android.content.Intent;

import ru.avs.express.android.app.dagger.AppComponent;
        import ru.avs.express.android.app.dagger.scope.PerScreen;
        import ru.avs.express.android.ui.base.dagger.DialogFragmentScreenModule;
        import ru.avs.express.android.ui.base.dagger.CustomScreenModule;
        import ru.avs.express.android.ui.base.screen.configurator.DialogFragmentScreenConfigurator;
        import ru.avs.express.android.ui.base.screen.view.ScreenComponent;

import dagger.Component;
import dagger.Module;

/**
* Конфигуратор экрана списка продуктов
*/
public class TestScreenConfigurator extends DialogFragmentScreenConfigurator {

    @PerScreen
    @Component(dependencies = AppComponent.class, modules = {DialogFragmentScreenModule.class, TestScreenModule.class})
    interface TestScreenComponent extends ScreenComponent<TestDialogFragmentView> {
    }
    

    @Module
    public static class TestScreenModule extends CustomScreenModule<TestDialogFragmentRoute>{
        public TestScreenModule(TestDialogFragmentRoute route) {
            super(route);
        }
    }

    public TestScreenConfigurator(Context context, Bundle args) {
        super(context, args);
    }

    @Override
    protected ScreenComponent createScreenComponent(AppComponent appComponent,
                                                    DialogFragmentScreenModule dialogFragmentScreenModule,
                                                    Bundle args) {
        return DaggerTestScreenConfigurator_TestScreenComponent.builder()
                .appComponent(appComponent)
                .testScreenModule(new TestScreenModule(new TestDialogFragmentRoute(args)))
                .dialogFragmentScreenModule(dialogFragmentScreenModule)
                .build();
    }

    @Override
    public String getName() {
        return "Test";
    }

}