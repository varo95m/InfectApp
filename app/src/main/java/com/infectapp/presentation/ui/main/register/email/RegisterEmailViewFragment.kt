package com.infectapp.presentation.ui.main.register.email

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_register_email.*
import org.kodein.di.generic.instance

class RegisterEmailViewFragment : BaseToolbarsFragment<RegisterEmailState, RegisterEmailViewModel, RegisterEmailViewNavigator.Navigation>() {
    override fun onInitializedWithToolbarsManagement(viewModel: RegisterEmailViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        bRegisterEmailNext.setOnClickListener {
            viewModel.onActionNext()
        }
        etRegisterEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onActionEmailChange(p0.toString())
            }
        })
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: RegisterEmailState) {
        tvRegisterEmailError.visibility = if (data.emailError) View.VISIBLE else View.GONE
    }

    override fun onError(error: Throwable): Boolean {
        return false
    }

    override val layoutId: Int = R.layout.fragment_register_email

    override val navigator: RegisterEmailViewNavigator by instance()

    override val viewModelSeed: RegisterEmailViewModel by instance()

    override fun onSingleEvent(data: EmaExtraData) {
    }

}