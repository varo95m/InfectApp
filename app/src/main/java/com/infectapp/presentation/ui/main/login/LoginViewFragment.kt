package com.infectapp.presentation.ui.main.login

import android.text.Editable
import android.text.TextWatcher
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.ui.MainToolbarsViewModel
import com.musketeers.richsnet.presentation.ui.login.LoginState
import kotlinx.android.synthetic.main.fragment_login.*
import org.kodein.di.generic.instance

class LoginViewFragment : BaseToolbarsFragment<LoginState, LoginViewModel, LoginNavigator.Navigation>() {

    override val viewModelSeed: LoginViewModel by instance()

    override val navigator: LoginNavigator by instance()

    private lateinit var vm: LoginViewModel

    override fun onError(error: Throwable): Boolean {
        return false
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onNormal(data: LoginState) {
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override val layoutId: Int = R.layout.fragment_login

    override fun onInitializedWithToolbarsManagement(viewModel: LoginViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        this.vm = viewModel
        mainToolbarViewModel.onActionShowToolbar(false)
        etLoginUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vm.onActionUserChange(p0.toString())
            }
        })
        etLoginPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vm.onActionPasswordChange(p0.toString())
            }
        })
        bLoginRegister.setOnClickListener {
            vm.onActionRegister()
        }
    }

}