package com.infectapp.presentation.ui.main.ranking

import android.graphics.Typeface
import android.view.View
import com.carmabs.ema.android.ui.EmaRecyclerAdapter
import com.infectapp.R
import com.infectapp.domain.model.InfectedUserModel
import kotlinx.android.synthetic.main.item_ranking.view.*
import kotlinx.android.synthetic.main.toolbar.view.*


/**
 *
 * <p>
 * Copyright (C) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:jorge.valino@babel.es">Jorge Valiño Guerra</a>
 */
class OtherUserAdapter(
    override val listItems: MutableList<InfectedUserModel>,
    private val userListener: (InfectedUserModel) -> Unit

) : EmaRecyclerAdapter<InfectedUserModel>() {
    override val layoutItemId: Int? = R.layout.item_ranking

    override fun View.bind(item: InfectedUserModel, viewType: Int) {
        val position = listItems.indexOf(item)
        this.setOnClickListener {
            userListener.invoke(item)
        }

        tv_ranking_item_other_user_name.text = item.username
        tv_ranking_item_other_user_infected.text = item.totalInfectedByUser.toString()

        if (item.isUserLogged)
            tv_ranking_item_other_user_name.typeface = Typeface.DEFAULT_BOLD
    }


}