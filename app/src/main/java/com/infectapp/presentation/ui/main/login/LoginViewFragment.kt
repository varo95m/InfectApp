package com.infectapp.presentation.ui.main.login

import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.KODEIN_TAG_DIALOG_LOADING
import com.infectapp.presentation.KODEIN_TAG_DIALOG_SIMPLE
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.dialog.simple.SimpleDialogData
import com.infectapp.presentation.ui.MainToolbarsViewModel
import com.infectapp.presentation.ui.main.login.LoginViewModel.Companion.FIELDS_EMPTY_DIALOG
import com.infectapp.presentation.ui.main.login.LoginViewModel.Companion.INVALID_FIELDS_DIALOG
import com.musketeers.richsnet.presentation.ui.login.LoginState
import kotlinx.android.synthetic.main.fragment_login.*
import org.kodein.di.generic.instance

class LoginViewFragment : BaseToolbarsFragment<LoginState, LoginViewModel, LoginNavigator.Navigation>() {

    override val viewModelSeed: LoginViewModel by instance()

    override val navigator: LoginNavigator by instance()

    private lateinit var vm: LoginViewModel

    private val simpleDialog: EmaDialogProvider by instance(KODEIN_TAG_DIALOG_SIMPLE)

    private val loadingDialog: EmaDialogProvider by instance(tag = KODEIN_TAG_DIALOG_LOADING)

    override fun onError(error: Throwable): Boolean {
        return false
    }

    override val layoutId: Int = R.layout.fragment_login

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onNormal(data: LoginState) {
        loadingDialog.hide()
        simpleDialog.hide()
    }

    override fun onAlternative(data: EmaExtraData) {
        when (data.type) {
            INVALID_FIELDS_DIALOG -> simpleDialog.show(SimpleDialogData(
                    title = "Upss",
                    message = "Usuario o contraseña incorrecto."
            ))
            FIELDS_EMPTY_DIALOG -> simpleDialog.show(SimpleDialogData(
                    title = "Upss",
                    message = "Los datos no pueden estar en blanco."
            ))
            else -> loadingDialog.show()
        }
    }


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
        bLoginJoin.setOnClickListener {
            vm.onActionLogin()
        }
        etLoginPassword.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                keyEvent?.action == KeyEvent.ACTION_DOWN && keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                viewModel.onActionLogin()
            }
            false
        }

    }

}