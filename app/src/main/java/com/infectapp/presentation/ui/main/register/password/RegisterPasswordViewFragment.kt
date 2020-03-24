package com.infectapp.presentation.ui.main.register.password

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_register_password.*
import org.kodein.di.generic.instance

class RegisterPasswordViewFragment : BaseToolbarsFragment<RegisterPasswordState, RegisterPasswordViewModel, RegisterPasswordNavigator.Navigation>() {
    override fun onInitializedWithToolbarsManagement(viewModel: RegisterPasswordViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        etRegisterPasswordPw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onActionPasswordChange(p0.toString())
            }
        })
        etRegisterPasswordRepeat.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onActionRepeatPasswordChange(p0.toString())
            }
        })
        bRegisterPasswordNext.setOnClickListener { viewModel.onActionNext() }
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: RegisterPasswordState) {
        when {
            data.minLength -> {
                tvRegisterPasswordError.visibility = View.VISIBLE
                tvRegisterPasswordError.text = getString(R.string.register_password_min_lenght)
            }
            data.passwordNotEqual -> {
                tvRegisterPasswordError.visibility = View.VISIBLE
                tvRegisterPasswordError.text = getString(R.string.register_password_equal)
            }
            else -> {
                tvRegisterPasswordError.visibility = View.INVISIBLE
                tvRegisterPasswordError.text = STRING_EMPTY
            }
        }
        data.registerModel?.password?.apply {
            bRegisterPasswordNext.isEnabled = this.isNotEmpty() && data.repeatPassword.isNotEmpty() && !data.minLength && !data.passwordNotEqual
        }
    }

    override fun onError(error: Throwable): Boolean {
        return false
    }

    override val layoutId: Int = R.layout.fragment_register_password

    override val navigator: RegisterPasswordNavigator by instance()

    override val viewModelSeed: RegisterPasswordViewModel by instance()

    override fun onSingleEvent(data: EmaExtraData) {
    }

}