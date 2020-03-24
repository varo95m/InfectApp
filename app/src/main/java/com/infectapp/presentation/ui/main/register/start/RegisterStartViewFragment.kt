package com.infectapp.presentation.ui.main.register.start

import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_register_start.*
import org.kodein.di.generic.instance

class RegisterStartViewFragment : BaseToolbarsFragment<RegisterStartState, RegisterStartViewModel, RegisterStartNavigator.Navigation>() {
    override fun onInitializedWithToolbarsManagement(viewModel: RegisterStartViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        bRegisterStartNext.setOnClickListener{
            viewModel.onActionStart()
        }
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: RegisterStartState) {
    }

    override fun onError(error: Throwable): Boolean {
        return false
    }

    override val layoutId: Int = R.layout.fragment_register_start

    override val navigator: RegisterStartNavigator by instance()

    override val viewModelSeed: RegisterStartViewModel by instance()

    override fun onSingleEvent(data: EmaExtraData) {
    }

}