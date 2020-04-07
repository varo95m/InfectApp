package com.infectapp.presentation.ui.main.news

import android.view.View
import com.carmabs.ema.android.ui.EmaRecyclerAdapter
import com.infectapp.R
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.NewModel
import kotlinx.android.synthetic.main.item_news.view.*


/**
 *
 * <p>
 * Copyright (C) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:jorge.valino@babel.es">Jorge Valiño Guerra</a>
 */
class NewsAdapter(
        override val listItems: MutableList<NewModel>

) : EmaRecyclerAdapter<NewModel>() {
    override val layoutItemId: Int? = R.layout.item_news

    override fun View.bind(item: NewModel, viewType: Int) {

        tvItemNewsMessage.text = item.message
        tvItemNewsDate.text = item.date
    }
}