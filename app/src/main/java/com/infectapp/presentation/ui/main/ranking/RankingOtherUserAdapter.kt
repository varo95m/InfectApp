package com.infectapp.presentation.ui.main.ranking

import android.view.View
import com.carmabs.ema.android.ui.EmaRecyclerAdapter
import com.infectapp.R
import com.infectapp.domain.INT_ONE
import com.infectapp.domain.model.InfectedUserModel
import kotlinx.android.synthetic.main.item_ranking.view.*


/**
 *
 * <p>
 * Copyright (C) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:jorge.valino@babel.es">Jorge Valiño Guerra</a>
 */
class RankingOtherUserAdapter(
        override val listItems: MutableList<InfectedUserModel>,
        private val userListener: (InfectedUserModel) -> Unit

) : EmaRecyclerAdapter<InfectedUserModel>() {
    override val layoutItemId: Int? = R.layout.item_ranking

    override fun View.bind(item: InfectedUserModel, viewType: Int) {
        this.setOnClickListener {
            userListener.invoke(item)
        }
        tvItemRankingUsername.text = item.username
        tvItemRankingPosition.text = item.userPosition.toString()
        tvItemRankingInfected.text = item.totalInfectedByUser.toString()
    }


}