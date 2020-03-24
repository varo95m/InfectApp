package com.infectapp.presentation.ui.main.register.username

import android.text.Editable
import android.text.TextWatcher
import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.KODEIN_TAG_DIALOG_LOADING
import com.infectapp.presentation.KODEIN_TAG_DIALOG_SIMPLE
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.dialog.simple.SimpleDialog
import com.infectapp.presentation.dialog.simple.SimpleDialogData
import com.infectapp.presentation.ui.MainToolbarsViewModel
import com.infectapp.presentation.ui.main.register.username.RegisterUsernameViewModel.Companion.CREATE_ACCOUNT_SUCCESSFUL_DIALOG
import com.infectapp.presentation.ui.main.register.username.RegisterUsernameViewModel.Companion.CREATE_ACCOUNT_UNSUCCESSFUL_DIALOG
import kotlinx.android.synthetic.main.fragment_register_username.*
import org.kodein.di.generic.instance

class RegisterUsernameViewFragment : BaseToolbarsFragment<RegisterUsernameState, RegisterUsernameViewModel, RegisterUsernameNavigator.Navigation>() {

    override val layoutId: Int = R.layout.fragment_register_username

    override val navigator: RegisterUsernameNavigator by instance()

    override val viewModelSeed: RegisterUsernameViewModel by instance()

    private val simpleDialog: EmaDialogProvider by instance(KODEIN_TAG_DIALOG_SIMPLE)

    private val loadingDialog: EmaDialogProvider by instance(tag = KODEIN_TAG_DIALOG_LOADING)

    override fun onInitializedWithToolbarsManagement(viewModel: RegisterUsernameViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        etRegisterUsernameUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onActionUsernameChange(p0.toString())
            }
        })
        bRegisterUsernameNext.setOnClickListener {
            viewModel.onActionCreateAccount()
        }
    }

    override fun onAlternative(data: EmaExtraData) {
        when (data.type) {
            CREATE_ACCOUNT_SUCCESSFUL_DIALOG -> simpleDialog.show(SimpleDialogData(
                    title = "¡Bienvenido!",
                    message = "Hemos enviado un mensaje a tu cuenta de email. Verifica tu cuenta."
            ))
            CREATE_ACCOUNT_UNSUCCESSFUL_DIALOG -> simpleDialog.show(SimpleDialogData(
                    title = "¿What?",
                    message = "Ha surgido algún error, intentado de nuevo."
            ))
            else -> loadingDialog.show()
        }
    }

    override fun onNormal(data: RegisterUsernameState) {
        simpleDialog.hide()
        loadingDialog.hide()
        bRegisterUsernameNext.isEnabled = data.buttonNextEnable
    }

    override fun onError(error: Throwable): Boolean {
        return false
    }


    override fun onSingleEvent(data: EmaExtraData) {
    }

}