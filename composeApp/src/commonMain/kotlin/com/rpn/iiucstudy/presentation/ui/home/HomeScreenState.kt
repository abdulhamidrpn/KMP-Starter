package com.rpn.iiucstudy.presentation.ui.home

import com.rpn.iiucstudy.domain.model.Article
import com.rpn.iiucstudy.utils.Resource

data class HomeScreenState(
    val articles: Resource<List<Article>> = Resource.Idle
)

